package ru.onko.repository.jooq;

import java.util.Optional;

public interface CrudRepository<E, ID> {

    ID save(E id);

    Optional<E> findById(ID id);

    E update(E e);

    void deleteById(ID id);
}
