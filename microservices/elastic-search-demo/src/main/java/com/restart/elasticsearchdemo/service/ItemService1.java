package com.restart.elasticsearchdemo.service;

import com.restart.elasticsearchdemo.document.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService1 {
    private final ElasticsearchOperations elasticsearchOperations;

    public ItemService1(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public int saveIndex(Item item) {
        Item itemEntity = elasticsearchOperations.save(item);
        return itemEntity.getId();
    }

    public List<Integer> saveIndexBulk(List<Item> itemList) {
        List<Integer> itemIds = new ArrayList<>();
        elasticsearchOperations.save(itemList).forEach(item -> itemIds.add(item.getId()));
        return itemIds;
    }

    public String findByCategory(Item item) {
        return elasticsearchOperations.delete(item);
    }

    public SearchHits<Item> search(String name) {
        // Get all item with given name
        //criterion query
        Criteria criteria = new Criteria("name").matches(name);
        Query searchQuery = new CriteriaQuery(criteria);

        //String query
        //Query query = new StringQuery("{ \"match\": { \"name\": { \"query\": \"" + name + " \" } } } ");

        //native query
        //Query query = NativeQuery.builder().withQuery(q -> q.match(m -> m.field("name").query(name))).build();


        return elasticsearchOperations.search(searchQuery, Item.class);
    }
}
