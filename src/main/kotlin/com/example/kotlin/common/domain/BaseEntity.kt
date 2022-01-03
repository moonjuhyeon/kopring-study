package com.example.kotlin.common.domain

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0;

    @CreatedDate
    private var createdDate: LocalDateTime = LocalDateTime.MIN;

    @LastModifiedDate
    private var updatedDate: LocalDateTime = LocalDateTime.MIN;

    fun getId(): Long {
        return this.id;
    }

    fun getCreatedDate(): LocalDateTime {
        return this.createdDate;
    }

    fun getUpdatedDate(): LocalDateTime {
        return this.updatedDate;
    }
}
