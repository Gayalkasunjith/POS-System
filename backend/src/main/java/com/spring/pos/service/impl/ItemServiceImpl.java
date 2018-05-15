package com.spring.pos.service.impl;

import com.spring.pos.domain.Item;
import com.spring.pos.dto.ItemDTO;
import com.spring.pos.repository.ItemRepository;
import com.spring.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public boolean save(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getQty());
        Item save = itemRepository.save(item);
        if (itemDTO != null && save != null) {
            return save != null;
        } else {
            return save != null;
        }
    }

    @Override
    public List<ItemDTO> findAll() {
        Iterable<Item> allItems = itemRepository.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        try {
            if (itemDTOS != null) {
                for (Item item :
                        allItems) {
                    ItemDTO itemDTO = new ItemDTO(item.getId(), item.getDescription(), item.getPrice(), item.getQty());
                    itemDTOS.add(itemDTO);
                }
                return itemDTOS;
            } else {
                return itemDTOS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemDTOS;
    }

    @Override
    public ItemDTO findById(int id) {
        Item item = itemRepository.findOne(id);
        ItemDTO itemDTO = null;
        if (item != null) {
            itemDTO = new ItemDTO(item.getId(), item.getDescription(), item.getPrice(), item.getQty());
            return itemDTO;
        } else {
            return itemDTO;
        }
    }

    @Override
    public boolean delete(int id) {
        itemRepository.delete(id);
        ItemDTO byId = findById(id);
        if (byId == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getQty());
        Item update = itemRepository.save(item);
        if (update != null) {
            return true;
        } else {
            return false;
        }
    }
}
