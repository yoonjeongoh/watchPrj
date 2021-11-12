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
public class StoreImageDTO {

    private String bsPath;
    private String bsUuid;
    private String bsImgName;

    public String getImageURL(){
        try {
            return URLEncoder.encode(bsPath + "/" + bsUuid
                    +"_"+bsImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getThumbnailURL(){
        try {
            return URLEncoder.encode(bsPath + "/s_" + bsUuid
                    +"_"+bsImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
