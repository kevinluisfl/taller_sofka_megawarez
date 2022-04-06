package com.sofka.megawarez.repository;

import com.sofka.megawarez.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}