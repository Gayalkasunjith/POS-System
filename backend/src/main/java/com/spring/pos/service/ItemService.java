package com.spring.pos.service;

import com.spring.pos.domain.Item;
import com.spring.pos.dto.CustomerDTO;
import com.spring.pos.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    boolean save(ItemDTO itemDTO);

    List<ItemDTO> findAll();

    ItemDTO findById(int id);

    boolean delete(int id);

    boolean update(ItemDTO itemDTO);
}
