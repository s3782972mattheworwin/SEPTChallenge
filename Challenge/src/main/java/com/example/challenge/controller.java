package com.example.challenge;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class controller {
    private final ItemRepository repository;

    controller(ItemRepository repository){
        this.repository = repository;
    }

    @GetMapping("/items")
    List<Item> all(){
        return repository.findAll();
    }

    @GetMapping("/items/{id}")
    Item one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new exception(id));
    }

    @PutMapping("/items/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id){
        return repository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setDesc(newItem.getDesc());
                    item.setId(newItem.getId());
                    item.setPrice(newItem.getPrice());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id.toString());
                    return repository.save(newItem);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteItem(@PathVariable Long id){
        repository.deleteById(id);
    }

}
