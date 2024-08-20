package com.github.umarshabazov.testscheduler.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    @Nullable
    private Instant createdAt;

    @Column(name = "updated_at", insertable = false)
    @LastModifiedDate
    @Nullable
    private Instant updatedAt;

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    @Nullable
    private String createdBy;

    @Column(name = "updated_by", insertable = false)
    @LastModifiedBy
    @Nullable
    private String updatedBy;


    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
