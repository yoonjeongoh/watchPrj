package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Pos;

public interface PosService {
    void posSetting(PosDTO posDTO);

//    PosDTO getPos(Long posNum);


    default Pos dtoToEntity(PosDTO posDTO) {
        Pos pos = Pos.builder()
                .menu1(posDTO.getMenu1())
                .menu2(posDTO.getMenu2())
                .menu3(posDTO.getMenu3())
                .menu4(posDTO.getMenu4())
                .drink1(posDTO.getDrink1())
                .drink2(posDTO.getDrink2())
                .table2(posDTO.getTable2())
                .table4(posDTO.getTable4())
                .table6(posDTO.getTable6())
                .build();
        return pos;
}
    default PosDTO entityToDTO(Pos entity){
        PosDTO pos = PosDTO.builder()
                .menu1(entity.getMenu1())
                .menu2(entity.getMenu2())
                .menu3(entity.getMenu3())
                .menu4(entity.getMenu4())
                .drink1(entity.getDrink1())
                .drink2(entity.getDrink2())
                .table2(entity.getTable2())
                .table4(entity.getTable4())
                .table6(entity.getTable6())
                .build();
        return pos;
    }


}
