package ru.onko.repository.jooq.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.onko.model.jooq.tables.pojos.NoteTagEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.liquibase.enabled=false")
class NoteRepositoryImplTest {

    @Autowired
    private NoteRepositoryImpl repository;

    @Test
    void findTagsById() {
        List<NoteTagEntity> tags = repository.findTagsById(UUID.fromString("006fa7f2-060e-4813-8cc8-abae07af3aae"));
        System.out.println(tags);
    }
}