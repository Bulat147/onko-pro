package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.AccessHashEntity;

import java.util.UUID;

public interface AccessHashRepository extends CrudRepository<AccessHashEntity, UUID> {

}
