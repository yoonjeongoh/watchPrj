package com.ds.watchtable.service;

import com.ds.watchtable.dto.MenuItemDTO;
import com.ds.watchtable.entity.MenuItem;
import com.ds.watchtable.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService{
    @Autowired
    final private MenuItemRepository menuItemRepository;

    @Override
    public void MenuItem(MenuItemDTO menuItemDTO) {
        MenuItem menuItem = dtoToEntity(menuItemDTO);
        menuItemRepository.save(menuItem);
    }
}
