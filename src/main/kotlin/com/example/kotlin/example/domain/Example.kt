package com.example.kotlin.example.domain

import com.example.kotlin.common.domain.BaseEntity
import javax.persistence.Entity

@Entity
class Example private constructor(
        _name: String
) : BaseEntity() {

    companion object {
        fun from(_name: String): Example {
            return Example(_name);
        }
    }

    private val name: String = _name;

    fun getName(): String {
        return this.name;
    }
}
