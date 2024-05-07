package com.restart.elasticsearchdemo.repository;

import com.restart.elasticsearchdemo.document.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item, Integer> {
    List<Item> findByName(String name);

    List<Item> findByCategory(String category);

    List<Item> findByPriceBetween(Double low, Double high);

}
