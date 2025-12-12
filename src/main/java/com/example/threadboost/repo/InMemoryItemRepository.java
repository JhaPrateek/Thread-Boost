package com.example.threadboost.repo;

import com.example.threadboost.model.Item;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryItemRepository {

    private final Map<String, Item> store = new ConcurrentHashMap<>();

    public Item save(Item item) {
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(String id) { return store.get(id); }

    public Collection<Item> findAll() { return store.values(); }

    public Item delete(String id) { return store.remove(id); }
}
