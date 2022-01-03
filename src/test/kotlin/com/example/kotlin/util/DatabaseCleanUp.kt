package com.example.kotlin.util

import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Service
@ActiveProfiles("test")
class DatabaseCleanUp : InitializingBean {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    private lateinit var tableList: List<String>

    override fun afterPropertiesSet() {
        tableList = entityManager.metamodel
            .entities
            .stream()
            .filter { it.javaType.getAnnotation(Entity::class.java) != null }
            .map { it.name.uppercase() }
            .collect(Collectors.toList());
    }

    @Transactional
    fun execute() {
        entityManager.flush();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        tableList.forEach {
            entityManager.createNativeQuery("TRUNCATE TABLE " + it).executeUpdate();
            entityManager.createNativeQuery("ALTER TABLE " + it + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        }

        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }

}
