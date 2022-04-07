package com.sofka.megawarez.service.interfaces;

import com.sofka.megawarez.domain.Item;

import java.util.List;

public interface IItem {

    public List<Item> getItems();

    public Item createItem(Item item);

    public Item updateItem(Integer id, Item item);

    public Item deleteItem(Integer id);
}
