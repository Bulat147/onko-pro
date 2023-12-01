package ru.onko.repository.jooq;

import ru.onko.model.jooq.tables.pojos.ArticleEntity;
import ru.onko.model.jooq.tables.pojos.PhotoEntity;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends CrudRepository<ArticleEntity, UUID> {

    List<ArticleEntity> findFavoritesByAccountId(UUID id);

    List<PhotoEntity> findPhotosById(UUID id);


    List<ArticleEntity> findAll();
}
