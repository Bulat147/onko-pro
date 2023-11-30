package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.Symptom;
import ru.onko.model.jooq.tables.pojos.SymptomEntity;
import ru.onko.repository.jooq.SymptomRepository;

import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.Symptom.SYMPTOM_ENTITY;

@Repository
@RequiredArgsConstructor
public class SymptomRepositoryImpl implements SymptomRepository {

    private final DSLContext dsl;

    @Override
    public UUID save(SymptomEntity symptom) {
        return dsl.insertInto(SYMPTOM_ENTITY)
                .set(dsl.newRecord(SYMPTOM_ENTITY, symptom))
                .returning()
                .fetchOne(SYMPTOM_ENTITY.ID);
    }

    @Override
    public Optional<SymptomEntity> findById(UUID id) {
        return dsl.selectFrom(SYMPTOM_ENTITY)
                .where(SYMPTOM_ENTITY.ID.eq(id))
                .fetchOptionalInto(SymptomEntity.class);
    }

    @Override
    public SymptomEntity update(SymptomEntity symptomEntity) {
        return dsl.update(SYMPTOM_ENTITY)
                .set(dsl.newRecord(SYMPTOM_ENTITY, symptomEntity))
                .where(SYMPTOM_ENTITY.ID.eq(symptomEntity.getId()))
                .returning()
                .fetchOneInto(SymptomEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(SYMPTOM_ENTITY)
                .where(SYMPTOM_ENTITY.ID.eq(id))
                .execute();
    }
}
