package com.spring.pos.controller;

import com.spring.pos.dto.ItemDTO;
import com.spring.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value = "save")
    public boolean save(@RequestBody ItemDTO itemDTO) {
        boolean save = itemService.save(itemDTO);
        return save;
    }

    @GetMapping(value = "find-all")
    public List<ItemDTO> findAll() {
        List<ItemDTO> allItems = itemService.findAll();
        return allItems;
    }

    @GetMapping(value = "find-by-id")
    public ItemDTO findById(int id) {
        ItemDTO itemDTO = itemService.findById(id);
        return itemDTO;
    }

    @DeleteMapping(value = "delete")
    public boolean delete(int id) {
        boolean delete = itemService.delete(id);
        return delete;
    }

    @PutMapping(value = "update")
    public boolean update(@RequestBody ItemDTO itemDTO) {
        boolean update = itemService.update(itemDTO);
        return update;
    }
}
