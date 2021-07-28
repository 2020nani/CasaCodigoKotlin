package com.example.api.cadastracategoria

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface CategoriaRepository: CrudRepository<Categoria, Long> {

    fun existsByNome(value: String): Boolean

}
