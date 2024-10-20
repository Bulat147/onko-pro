/*
 * This file is generated by jOOQ.
 */
package ru.onko.model.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;

/**
 * This class is generated by jOOQ.
 */
@Builder
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RefreshTokenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private UUID name;
    private LocalDateTime expire;
    private UUID accountId;

    public RefreshTokenEntity() {}

    public RefreshTokenEntity(RefreshTokenEntity value) {
        this.id = value.id;
        this.name = value.name;
        this.expire = value.expire;
        this.accountId = value.accountId;
    }

    public RefreshTokenEntity(
        UUID id,
        UUID name,
        LocalDateTime expire,
        UUID accountId
    ) {
        this.id = id;
        this.name = name;
        this.expire = expire;
        this.accountId = accountId;
    }

    /**
     * Getter for <code>public.refresh_token.id</code>.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.refresh_token.id</code>.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Getter for <code>public.refresh_token.name</code>.
     */
    public UUID getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.refresh_token.name</code>.
     */
    public void setName(UUID name) {
        this.name = name;
    }

    /**
     * Getter for <code>public.refresh_token.expire</code>.
     */
    public LocalDateTime getExpire() {
        return this.expire;
    }

    /**
     * Setter for <code>public.refresh_token.expire</code>.
     */
    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }

    /**
     * Getter for <code>public.refresh_token.account_id</code>.
     */
    public UUID getAccountId() {
        return this.accountId;
    }

    /**
     * Setter for <code>public.refresh_token.account_id</code>.
     */
    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RefreshTokenEntity other = (RefreshTokenEntity) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.expire == null) {
            if (other.expire != null)
                return false;
        }
        else if (!this.expire.equals(other.expire))
            return false;
        if (this.accountId == null) {
            if (other.accountId != null)
                return false;
        }
        else if (!this.accountId.equals(other.accountId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.expire == null) ? 0 : this.expire.hashCode());
        result = prime * result + ((this.accountId == null) ? 0 : this.accountId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RefreshTokenEntity (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(expire);
        sb.append(", ").append(accountId);

        sb.append(")");
        return sb.toString();
    }
}
