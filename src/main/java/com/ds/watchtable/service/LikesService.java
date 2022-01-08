package com.ds.watchtable.service;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.entity.Likes;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;

public interface LikesService {

    default Likes dtoToEntity(LikesDTO likesDTO) {
        Likes likes = Likes.builder()
                .likesNum(likesDTO.getLikesNum())
                .member(Member.builder()
                        .memberNum(likesDTO.getMemberNum())
                        .build())
                .store(Store.builder()
                        .storeNum(likesDTO.getStoreNum())
                        .build())
                .build();
        return likes;
    }

    default LikesDTO entityToDTO(Likes likes) {
        LikesDTO likesDTO = LikesDTO.builder()
                .likesNum(likes.getLikesNum())
                .memberNum(likes.getMember().getMemberNum())
                .storeNum(likes.getStore().getStoreNum())
                .build();
        return likesDTO;
    }

}