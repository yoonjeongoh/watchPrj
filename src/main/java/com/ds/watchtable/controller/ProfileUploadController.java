package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MenuUploadResultDTO;
import com.ds.watchtable.dto.ProfileUploadResultDTO;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class ProfileUploadController {

  @Value("${com.ds.upload.profilePath}")
  private String uploadPath;

  @ResponseBody
  @PostMapping("/profileUploadAjax")
  public ResponseEntity<List<ProfileUploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) {
    List<ProfileUploadResultDTO> profileUploadResultDTOS = new ArrayList<>();

    for (MultipartFile uploadFile : uploadFiles) {
      if (uploadFile.getContentType().startsWith("image") == false) {
        log.warn("this file is not image type");
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
      String originalName = uploadFile.getOriginalFilename();
      String pfileName = originalName.substring(originalName.lastIndexOf("\\")+1);
      log.info(pfileName);

      String pfolderPath = makeFolder();

      String puuid = UUID.randomUUID().toString();
      String saveName = uploadPath + File.separator + pfolderPath
              + File.separator + puuid + "_" + pfileName;
      Path savePath = Paths.get(saveName);
      try {
        uploadFile.transferTo(savePath);

        //썸네일 생성
        String thumbnailSaveName = uploadPath + File.separator + pfolderPath
                + File.separator + "s_" + puuid + "_" + pfileName;
        File thumbnailFile = new File(thumbnailSaveName);
        Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100,100);

        profileUploadResultDTOS.add(new ProfileUploadResultDTO(pfileName, puuid, pfolderPath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return new ResponseEntity<>(profileUploadResultDTOS, HttpStatus.OK);
  }

  @GetMapping("/profileDisplay")
  public ResponseEntity<byte[]> getFile(String fileName, String size) {
    ResponseEntity<byte[]> result2 = null;
    try {
      String srcFileName = URLDecoder.decode(fileName, "UTF-8");
      log.info("fileName : " + srcFileName); //시험해보는거임.
      File file = new File(uploadPath + File.separator + srcFileName);
      log.info("LYJ "+file.getName()+"/"+file);

      if (size != null && size.equals("1")) {
        //s_파일명.이미지일 경우 -> file.getName().substring(2)
        file = new File(file.getParent(), file.getName().substring(2));
      }

      log.info("file : " + file);
      HttpHeaders header = new HttpHeaders();
      header.add("Content-Type", Files.probeContentType(file.toPath()));
      result2 = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
              header, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return result2;
  }

  @PostMapping("/profileRemoveFile")
  public ResponseEntity<Boolean> removeFiles(String fileName) {
    String srcFileName = null;
    boolean result = false;
    try {
      srcFileName = URLDecoder.decode(fileName, "UTF-8");
      File file = new File(uploadPath + File.separator + srcFileName);
      result = file.delete();
      File thumbnail = new File(file.getParent(), "s_" + file.getName());
      result = thumbnail.delete();
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private String makeFolder() {
    String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    String folderPath = str.replace("/", File.separator);
    File uploadPathFolder = new File(uploadPath, folderPath);
    if (uploadPathFolder.exists() == false) {
      uploadPathFolder.mkdirs();
    }
    return folderPath;
  }
}