package ru.onko.repository.jooq.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.onko.model.jooq.tables.pojos.ArticleEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.liquibase.enabled=false")
class ArticleRepositoryImplTest {

    @Autowired
    private ArticleRepositoryImpl repository;

    @Test
    void findFavoritesByAccountId() {
        List<ArticleEntity> favoritesByAccountId = repository.findFavoritesByAccountId(UUID.fromString("fa9bc6f1-9c97-4e78-83e2-8864dd84d58e"));
        System.out.println(favoritesByAccountId);
    }
}