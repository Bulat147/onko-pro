package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.NoteTagEntity;

import java.util.UUID;

public interface NoteTagRepository extends CrudRepository<NoteTagEntity, UUID> {
}
