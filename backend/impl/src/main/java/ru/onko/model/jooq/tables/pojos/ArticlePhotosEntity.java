/*
 * This file is generated by jOOQ.
 */
package ru.onko.model.jooq.tables.pojos;


import java.io.Serializable;
import java.util.UUID;

import lombok.Builder;

/**
 * This class is generated by jOOQ.
 */
@Builder
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ArticlePhotosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID articleId;
    private UUID photoId;

    public ArticlePhotosEntity() {}

    public ArticlePhotosEntity(ArticlePhotosEntity value) {
        this.articleId = value.articleId;
        this.photoId = value.photoId;
    }

    public ArticlePhotosEntity(
        UUID articleId,
        UUID photoId
    ) {
        this.articleId = articleId;
        this.photoId = photoId;
    }

    /**
     * Getter for <code>public.article_photos.article_id</code>.
     */
    public UUID getArticleId() {
        return this.articleId;
    }

    /**
     * Setter for <code>public.article_photos.article_id</code>.
     */
    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    /**
     * Getter for <code>public.article_photos.photo_id</code>.
     */
    public UUID getPhotoId() {
        return this.photoId;
    }

    /**
     * Setter for <code>public.article_photos.photo_id</code>.
     */
    public void setPhotoId(UUID photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ArticlePhotosEntity other = (ArticlePhotosEntity) obj;
        if (this.articleId == null) {
            if (other.articleId != null)
                return false;
        }
        else if (!this.articleId.equals(other.articleId))
            return false;
        if (this.photoId == null) {
            if (other.photoId != null)
                return false;
        }
        else if (!this.photoId.equals(other.photoId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.articleId == null) ? 0 : this.articleId.hashCode());
        result = prime * result + ((this.photoId == null) ? 0 : this.photoId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArticlePhotosEntity (");

        sb.append(articleId);
        sb.append(", ").append(photoId);

        sb.append(")");
        return sb.toString();
    }
}
