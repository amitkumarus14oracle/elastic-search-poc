package com.restart.elasticsearchdemo.service;

import com.restart.elasticsearchdemo.document.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByName(String itemName);

    List<Item> findByCategory(String category);

    List<Item> findByPriceBetween(double low, double high);
}
