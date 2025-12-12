package com.example.threadboost.controller;

import com.example.threadboost.model.Item;
import com.example.threadboost.service.AsyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/async/items")
public class AsyncController {

    private final AsyncService service;

    public AsyncController(AsyncService service){ this.service=service; }

    @PostMapping
    public CompletableFuture<ResponseEntity<Item>> create(@RequestParam String name,@RequestParam String value){
        return service.create(name,value).thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity<Item>> read(@PathVariable String id){
        return service.read(id).thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Collection<Item>>> readAll(){
        return service.readAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity<Item>> update(@PathVariable String id,@RequestParam String name,@RequestParam String value){
        return service.update(id,name,value).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity<Item>> delete(@PathVariable String id){
        return service.delete(id).thenApply(ResponseEntity::ok);
    }
}
