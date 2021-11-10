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

    private String menuUuid;
    private String menuImgName;
    private String menuPath;

    public String getImageURL(){
        try {
            return URLEncoder.encode(menuImgName + "/" + menuUuid
                    +"_"+menuPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getThumbnailURL(){
        try {
            return URLEncoder.encode(menuImgName + "/s_" + menuUuid
                    +"_"+menuPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
