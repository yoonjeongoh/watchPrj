package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Data
@AllArgsConstructor
public class ProfileUploadResultDTO implements Serializable {
  private String pfileName;
  private String puuid;
  private String pfolderPath;
  public String getImageURL(){
    try {
      return URLEncoder.encode(pfolderPath + "/" + puuid
        +"_"+pfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
  public String getThumbnailURL(){
    try {
      return URLEncoder.encode(pfolderPath + "/s_" + puuid
        +"_"+pfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
