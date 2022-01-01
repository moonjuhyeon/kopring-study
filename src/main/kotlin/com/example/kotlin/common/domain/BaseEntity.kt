package com.example.kotlin.common.domain

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0;

    @CreatedDate
    private val createdDate: LocalDateTime = LocalDateTime.now();

    @CreatedBy
    private val createdBy: Long = 0;

    @LastModifiedDate
    private val updatedDate: LocalDateTime = LocalDateTime.now();

    @LastModifiedBy
    private val updatedBy: Long = 0;

    fun getId(): Long {
        return this.id;
    }

    fun getCreatedDate(): LocalDateTime {
        return this.createdDate;
    }

    fun getCreatedBy(): Long {
        return this.createdBy;
    }

    fun getUpdatedDate(): LocalDateTime {
        return this.updatedDate;
    }

    fun getUpdatedBy(): Long {
        return this.updatedBy;
    }
}