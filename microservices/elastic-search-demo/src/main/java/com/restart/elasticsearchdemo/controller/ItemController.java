
package com.restart.elasticsearchdemo.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.restart.elasticsearchdemo.document.Item;
import com.restart.elasticsearchdemo.service.ItemService;
import com.restart.elasticsearchdemo.service.ItemService1;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ItemService1 itemService1;
    @GetMapping("/{name}")
    public List<Item> getItemByName(@PathVariable("name") String name) {
        return itemService.findByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Item> getItemsByCategory(@PathVariable("category") String category) {
        return itemService.findByCategory(category);
    }

    @GetMapping("/prices/{low}/{high}")
    public List<Item> getItemsByPriceRange(@PathVariable("low") double low,
            @PathVariable("high") double high) {
        return itemService.findByPriceBetween(low, high);
    }

    @GetMapping("/name/search/{name}")
    public Set<Item> getItemsByPriceRange(@PathVariable("name") String name) {
        return itemService1.search(name).stream().map(SearchHit::getContent).collect(Collectors.toSet());
    }
}