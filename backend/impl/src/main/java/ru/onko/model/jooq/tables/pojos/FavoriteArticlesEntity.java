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
public class FavoriteArticlesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID accountId;
    private UUID articleId;

    public FavoriteArticlesEntity() {}

    public FavoriteArticlesEntity(FavoriteArticlesEntity value) {
        this.accountId = value.accountId;
        this.articleId = value.articleId;
    }

    public FavoriteArticlesEntity(
        UUID accountId,
        UUID articleId
    ) {
        this.accountId = accountId;
        this.articleId = articleId;
    }

    /**
     * Getter for <code>public.favorite_articles.account_id</code>.
     */
    public UUID getAccountId() {
        return this.accountId;
    }

    /**
     * Setter for <code>public.favorite_articles.account_id</code>.
     */
    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    /**
     * Getter for <code>public.favorite_articles.article_id</code>.
     */
    public UUID getArticleId() {
        return this.articleId;
    }

    /**
     * Setter for <code>public.favorite_articles.article_id</code>.
     */
    public void setArticleId(UUID articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FavoriteArticlesEntity other = (FavoriteArticlesEntity) obj;
        if (this.accountId == null) {
            if (other.accountId != null)
                return false;
        }
        else if (!this.accountId.equals(other.accountId))
            return false;
        if (this.articleId == null) {
            if (other.articleId != null)
                return false;
        }
        else if (!this.articleId.equals(other.articleId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.accountId == null) ? 0 : this.accountId.hashCode());
        result = prime * result + ((this.articleId == null) ? 0 : this.articleId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FavoriteArticlesEntity (");

        sb.append(accountId);
        sb.append(", ").append(articleId);

        sb.append(")");
        return sb.toString();
    }
}
