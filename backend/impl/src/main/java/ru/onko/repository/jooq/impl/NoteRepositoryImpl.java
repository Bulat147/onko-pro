package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.pojos.NoteEntity;
import ru.onko.model.jooq.tables.pojos.NoteTagEntity;
import ru.onko.model.jooq.tables.pojos.SymptomEntity;
import ru.onko.repository.jooq.NoteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.Note.NOTE_ENTITY;

@Repository
@RequiredArgsConstructor
public class NoteRepositoryImpl implements NoteRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(NoteEntity note) {
        return dsl.insertInto(NOTE_ENTITY)
                .set(dsl.newRecord(NOTE_ENTITY, note))
                .returning()
                .fetchOne(NOTE_ENTITY.ID);
    }

    @Override
    public Optional<NoteEntity> findById(UUID id) {
        return dsl.selectFrom(NOTE_ENTITY)
                .where(NOTE_ENTITY.ID.eq(id))
                .fetchOptionalInto(NoteEntity.class);
    }

    @Override
    public NoteEntity update(NoteEntity note) {
        return dsl.update(NOTE_ENTITY)
                .set(dsl.newRecord(NOTE_ENTITY, note))
                .where(NOTE_ENTITY.ID.eq(note.getId()))
                .returning()
                .fetchOneInto(NoteEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(NOTE_ENTITY)
                .where(NOTE_ENTITY.ID.eq(id))
                .execute();
    }

    @Override
    public List<NoteTagEntity> findTagsById(UUID id) {
        //language=sql
        return dsl.selectFrom("note_tag WHERE id in (SELECT tag_id FROM notes_tags WHERE note_id = :id)", id)
                .fetchInto(NoteTagEntity.class);
    }

    @Override
    public List<SymptomEntity> findSymptomsById(UUID id) {
        //language=sql
        return dsl.selectFrom("symptom WHERE id in (SELECT symptom_id FROM notes_symptoms WHERE note_id = :id", id)
                .fetchInto(SymptomEntity.class);
    }

    @Override
    public List<NoteEntity> searchByAccountId(UUID id) {
        return dsl.selectFrom(NOTE_ENTITY)
                .where(NOTE_ENTITY.ACCOUNT_ID.eq(id))
                .fetchInto(NoteEntity.class);
    }
}
