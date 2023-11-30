package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.NoteTag;
import ru.onko.model.jooq.tables.pojos.NoteTagEntity;
import ru.onko.repository.jooq.NoteTagRepository;

import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.NoteTag.NOTE_TAG_ENTITY;

@Repository
@RequiredArgsConstructor
public class NoteTagRepositoryImpl implements NoteTagRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(NoteTagEntity noteTag) {
        return dsl.insertInto(NOTE_TAG_ENTITY)
                .set(dsl.newRecord(NOTE_TAG_ENTITY, noteTag))
                .returning()
                .fetchOne(NOTE_TAG_ENTITY.ID);
    }

    @Override
    public Optional<NoteTagEntity> findById(UUID id) {
        return dsl.selectFrom(NOTE_TAG_ENTITY)
                .where(NOTE_TAG_ENTITY.ID.eq(id))
                .fetchOptionalInto(NoteTagEntity.class);
    }

    @Override
    public NoteTagEntity update(NoteTagEntity noteTag) {
        return dsl.update(NOTE_TAG_ENTITY)
                .set(dsl.newRecord(NOTE_TAG_ENTITY, noteTag))
                .where(NOTE_TAG_ENTITY.ID.eq(noteTag.getId()))
                .returning()
                .fetchOneInto(NoteTagEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(NOTE_TAG_ENTITY)
                .where(NOTE_TAG_ENTITY.ID.eq(id))
                .execute();
    }
}
