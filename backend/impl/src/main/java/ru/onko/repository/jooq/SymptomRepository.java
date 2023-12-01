package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.SymptomEntity;

import java.util.List;
import java.util.UUID;

public interface SymptomRepository extends CrudRepository<SymptomEntity, UUID> {

    List<SymptomEntity> findByUserId(UUID userId);
}
