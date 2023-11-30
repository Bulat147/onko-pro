package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.NoteEntity;
import ru.onko.model.jooq.tables.pojos.NoteTagEntity;
import ru.onko.model.jooq.tables.pojos.SymptomEntity;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<NoteEntity, UUID> {

    List<NoteTagEntity> findTagsById(UUID id);

    List<SymptomEntity> findSymptomsById(UUID id);
}
