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
public class ProfileImageDTO {

    private String profilePath;
    private String profileUuid;
    private String profileImgName;

    public String getImageURL(){
        try {
            return URLEncoder.encode(profilePath + "/" + profileUuid
                    +"_"+profileImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String getThumbnailURL(){
        try {
            return URLEncoder.encode(profilePath + "/s_" + profileUuid
                    +"_"+profileImgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
