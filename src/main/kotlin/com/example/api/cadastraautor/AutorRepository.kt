package com.example.api.cadastraautor

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface AutorRepository: CrudRepository<Autor, Long> {
    fun existsByEmail(value: String): Boolean

}
