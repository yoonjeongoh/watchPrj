package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Data
@AllArgsConstructor
public class StoreUploadResultDTO implements Serializable {
  private String sfileName;
  private String suuid;
  private String sfolderPath;
  public String getImageURL(){
    try {
      return URLEncoder.encode(sfolderPath + "/" + suuid
        +"_"+sfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
  public String getThumbnailURL(){
    try {
      return URLEncoder.encode(sfolderPath + "/s_" + suuid
        +"_"+sfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
