package com.example.threadboost.controller;

import com.example.threadboost.model.Item;
import com.example.threadboost.service.BlockingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/blocking/items")
public class BlockingController {

    private final BlockingService service;

    public BlockingController(BlockingService service){ this.service=service; }

    @PostMapping
    public ResponseEntity<Item> create(@RequestParam String name,@RequestParam String value){
        return ResponseEntity.ok(service.create(name,value));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> read(@PathVariable String id){
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping
    public ResponseEntity<Collection<Item>> readAll(){
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable String id,@RequestParam String name,@RequestParam String value){
        return ResponseEntity.ok(service.update(id,name,value));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable String id){
        return ResponseEntity.ok(service.delete(id));
    }
}
