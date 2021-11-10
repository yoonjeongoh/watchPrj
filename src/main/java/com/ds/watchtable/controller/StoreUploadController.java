package com.ds.watchtable.controller;

import com.ds.watchtable.dto.StoreUploadResultDTO;
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
public class StoreUploadController {

  @Value("${com.ds.upload.storePath}")
  private String uploadPath;

  @ResponseBody
  @PostMapping("/storeUploadAjax")
  public ResponseEntity<List<StoreUploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) {
    List<StoreUploadResultDTO> storeUploadResultDTOS = new ArrayList<>();

    for (MultipartFile uploadFile : uploadFiles) {
      if (uploadFile.getContentType().startsWith("image") == false) {
        log.warn("this file is not image type");
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
      String originalName = uploadFile.getOriginalFilename();
      String sfileName = originalName.substring(originalName.lastIndexOf("\\")+1);
      log.info(sfileName);

      String sfolderPath = makeFolder();

      String suuid = UUID.randomUUID().toString();
      String saveName = uploadPath + File.separator + sfolderPath
              + File.separator + suuid + "_" + sfileName;
      Path savePath = Paths.get(saveName);
      try {
        uploadFile.transferTo(savePath);

        //썸네일 생성
        String thumbnailSaveName = uploadPath + File.separator + sfolderPath
                + File.separator + "s_" + suuid + "_" + sfileName;
        File thumbnailFile = new File(thumbnailSaveName);
        Thumbnailator.createThumbnail(savePath.toFile(), thumbnailFile, 100,100);

        storeUploadResultDTOS.add(new StoreUploadResultDTO(sfileName, suuid, sfolderPath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return new ResponseEntity<>(storeUploadResultDTOS, HttpStatus.OK);
  }

  @GetMapping("/storeDisplay")
  public ResponseEntity<byte[]> getFile(String fileName, String size) {
    ResponseEntity<byte[]> result = null;
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
      result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),
              header, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return result;
  }

  @PostMapping("/storeRemoveFile")
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