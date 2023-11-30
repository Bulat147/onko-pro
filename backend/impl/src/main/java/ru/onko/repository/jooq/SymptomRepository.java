package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.SymptomEntity;

import java.util.UUID;

public interface SymptomRepository extends CrudRepository<SymptomEntity, UUID> {
}
