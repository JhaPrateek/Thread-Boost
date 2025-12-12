package com.example.threadboost.service;

import com.example.threadboost.model.Item;
import com.example.threadboost.repo.InMemoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class BlockingService {

    private final InMemoryItemRepository repo;

    public BlockingService(InMemoryItemRepository repo) { this.repo = repo; }

    private void simulate(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e){ Thread.currentThread().interrupt(); }
    }

    public Item create(String name, String value){
        simulate(200);
        Item i=new Item(UUID.randomUUID().toString(),name,value);
        return repo.save(i);
    }

    public Item read(String id){
        simulate(100);
        return repo.findById(id);
    }

    public Collection<Item> readAll(){
        simulate(50);
        return repo.findAll();
    }

    public Item update(String id,String name,String value){
        simulate(200);
        Item i=repo.findById(id);
        if(i!=null){
            i.setName(name);
            i.setValue(value);
            repo.save(i);
        }
        return i;
    }

    public Item delete(String id){
        simulate(100);
        return repo.delete(id);
    }
}
