package com.example.api.cadastralivro

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface LivroRepository : CrudRepository<Livro, Long> {
    fun existsByTitulo(value: String): Boolean
    fun existsByIsbn(value: String): Boolean

}