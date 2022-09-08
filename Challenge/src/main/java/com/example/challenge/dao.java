package com.example.challenge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class dao {
    private static final Logger log = LoggerFactory.getLogger(dao.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Item("01", "chair", "sit on it", 10)));
            log.info("Preloading " + repository.save(new Item("02", "table", "eat on it", 20)));
        };
    }
}
