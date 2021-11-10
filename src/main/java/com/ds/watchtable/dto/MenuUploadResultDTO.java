package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Data
@AllArgsConstructor
public class MenuUploadResultDTO implements Serializable {
  private String mfileName;
  private String muuid;
  private String mfolderPath;
  public String getImageURL(){
    try {
      return URLEncoder.encode(mfolderPath + "/" + muuid
        +"_"+mfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
  public String getThumbnailURL(){
    try {
      return URLEncoder.encode(mfolderPath + "/s_" + muuid
        +"_"+mfileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
