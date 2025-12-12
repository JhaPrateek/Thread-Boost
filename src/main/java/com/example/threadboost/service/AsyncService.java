package com.example.threadboost.service;

import com.example.threadboost.model.Item;
import com.example.threadboost.repo.InMemoryItemRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private final InMemoryItemRepository repo;

    public AsyncService(InMemoryItemRepository repo) { this.repo = repo; }

    private void simulate(long ms){
        try{ Thread.sleep(ms);}catch(Exception e){}
    }

    @Async("taskExecutor")
    public CompletableFuture<Item> create(String name,String value){
        simulate(200);
        Item i=new Item(UUID.randomUUID().toString(),name,value);
        repo.save(i);
        return CompletableFuture.completedFuture(i);
    }

    @Async("taskExecutor")
    public CompletableFuture<Item> read(String id){
        simulate(100);
        return CompletableFuture.completedFuture(repo.findById(id));
    }

    @Async("taskExecutor")
    public CompletableFuture<Collection<Item>> readAll(){
        simulate(50);
        return CompletableFuture.completedFuture(repo.findAll());
    }

    @Async("taskExecutor")
    public CompletableFuture<Item> update(String id,String name,String value){
        simulate(200);
        Item i=repo.findById(id);
        if(i!=null){
            i.setName(name);
            i.setValue(value);
            repo.save(i);
        }
        return CompletableFuture.completedFuture(i);
    }

    @Async("taskExecutor")
    public CompletableFuture<Item> delete(String id){
        simulate(100);
        return CompletableFuture.completedFuture(repo.delete(id));
    }
}
