package com.ds.watchtable.service;

import com.ds.watchtable.dto.MenuItemDTO;
import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.MenuItem;

public interface MenuItemService {
    void MenuItem(MenuItemDTO menuItemDTO);
    default MenuItem dtoToEntity(MenuItemDTO menuItemDTO){
        MenuItem menuItem = MenuItem.builder()
                .menuItemNum(menuItemDTO.getMenuItemNum())
                .menu(menuItemDTO.getMenu())
                .side(menuItemDTO.getSide())
                .drink(menuItemDTO.getDrink())
                .build();
        return menuItem;
    }

    default MenuItemDTO entityToDTO(MenuItem menuItem){
        MenuItemDTO menuItemDTO = MenuItemDTO.builder()
                .menuItemNum(menuItem.getMenuItemNum())
                .menu(menuItem.getMenu())
                .side(menuItem.getSide())
                .drink(menuItem.getDrink())
                .modDate(menuItem.getModDate())
                .regDate(menuItem.getRegDate())
                .build();
        return menuItemDTO;
    }

}
