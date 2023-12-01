package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.NoteTagEntity;

import java.util.List;
import java.util.UUID;

public interface NoteTagRepository extends CrudRepository<NoteTagEntity, UUID> {

    List<NoteTagEntity> findByUserId(UUID userId);
}
