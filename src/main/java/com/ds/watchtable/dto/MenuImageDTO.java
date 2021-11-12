package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuImageDTO {

    private String menuPath;
    private String menuUuid;
    private String menuImgName;

    public String getImageURL(){
        try {
            return URLEncoder.encode(menuPath + "/" + menuUuid
                    +"_"+menuImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getThumbnailURL(){
        try {
            return URLEncoder.encode(menuPath + "/s_" + menuUuid
                    +"_"+menuImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
