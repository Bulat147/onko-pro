package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.Photo;
import ru.onko.model.jooq.tables.pojos.PhotoEntity;
import ru.onko.repository.jooq.PhotoRepository;

import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.Photo.PHOTO_ENTITY;

@Repository
@RequiredArgsConstructor
public class PhotoRepositoryImpl implements PhotoRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(PhotoEntity photo) {
        return dsl.insertInto(PHOTO_ENTITY)
                .set(dsl.newRecord(PHOTO_ENTITY, photo))
                .returning()
                .fetchOne(PHOTO_ENTITY.ID);
    }

    @Override
    public Optional<PhotoEntity> findById(UUID id) {
        return dsl.selectFrom(PHOTO_ENTITY)
                .where(PHOTO_ENTITY.ID.eq(id))
                .fetchOptionalInto(PhotoEntity.class);
    }

    @Override
    public PhotoEntity update(PhotoEntity photo) {
        return dsl.update(PHOTO_ENTITY)
                .set(dsl.newRecord(PHOTO_ENTITY, photo))
                .where(PHOTO_ENTITY.ID.eq(photo.getId()))
                .returning()
                .fetchOneInto(PhotoEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(PHOTO_ENTITY)
                .where(PHOTO_ENTITY.ID.eq(id))
                .execute();
    }
}
