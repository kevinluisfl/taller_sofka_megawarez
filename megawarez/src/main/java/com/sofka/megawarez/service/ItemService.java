package com.sofka.megawarez.service;

import com.sofka.megawarez.domain.Item;
import com.sofka.megawarez.repository.ItemRepository;
import com.sofka.megawarez.service.interfaces.IItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class ItemService implements IItem{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    @Transactional
    public Item createItem(Item item) {
        item.setCreatedAt(Instant.now());
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item updateItem(Integer id, Item item) {
        item.setId(id);
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item deleteItem(Integer id) {
        var item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
            return item.get();
        }else {
            return null;
        }
    }
}
