package com.restart.elasticsearchdemo.config;

import java.util.List;

import com.restart.elasticsearchdemo.document.Item;
import com.restart.elasticsearchdemo.repository.ItemRepository;
import com.restart.elasticsearchdemo.service.CSVParser;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataSetup {
    private final ItemRepository itemRepository;
    private final CSVParser csvParser;
    @PostConstruct
    public void setupData() {
        List<Item> itemList = csvParser.csvParser("items.csv");
        itemRepository.saveAll(itemList);
    }
}