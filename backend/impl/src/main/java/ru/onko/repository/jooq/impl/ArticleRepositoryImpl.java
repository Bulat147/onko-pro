package ru.onko.repository.jooq.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.onko.model.jooq.tables.Article;
import ru.onko.model.jooq.tables.pojos.ArticleEntity;
import ru.onko.model.jooq.tables.pojos.PhotoEntity;
import ru.onko.repository.jooq.ArticleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.onko.model.jooq.tables.Article.ARTICLE_ENTITY;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {

    private final DSLContext dsl;

    @Override
    public List<ArticleEntity> findFavoritesByAccountId(UUID id) {
        //language=sql
        return dsl.selectFrom("article WHERE id in (SELECT article_id FROM favorite_articles WHERE account_id = :id)", id)
                .fetchInto(ArticleEntity.class);
    }

    @Override
    public List<PhotoEntity> findPhotosById(UUID id) {
        //language=sql
        return dsl.selectFrom("photo WHERE id in (SELECT photo_id FROM article_photos WHERE article_id = :id)", id)
                .fetchInto(PhotoEntity.class);
    }

    @Override
    public UUID save(ArticleEntity article) {
        return dsl.insertInto(ARTICLE_ENTITY)
                .set(dsl.newRecord(ARTICLE_ENTITY, article))
                .returning()
                .fetchOne(ARTICLE_ENTITY.ID);
    }

    @Override
    public Optional<ArticleEntity> findById(UUID id) {
        return dsl.selectFrom(ARTICLE_ENTITY)
                .where(ARTICLE_ENTITY.ID.eq(id))
                .fetchOptionalInto(ArticleEntity.class);
    }

    @Override
    public ArticleEntity update(ArticleEntity article) {
        return dsl.update(ARTICLE_ENTITY)
                .set(dsl.newRecord(ARTICLE_ENTITY, article))
                .where(ARTICLE_ENTITY.ID.eq(article.getId()))
                .returning()
                .fetchOneInto(ArticleEntity.class);
    }

    @Override
    public void deleteById(UUID id) {
        dsl.delete(ARTICLE_ENTITY)
                .where(ARTICLE_ENTITY.ID.eq(id))
                .execute();
    }
}
