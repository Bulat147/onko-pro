package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.PhotoEntity;

import java.util.UUID;

public interface PhotoRepository extends CrudRepository<PhotoEntity, UUID> {
}
