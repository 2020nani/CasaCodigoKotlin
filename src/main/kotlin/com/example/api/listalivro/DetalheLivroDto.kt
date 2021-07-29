package com.example.api.listalivro

import com.example.api.cadastraautor.Autor
import com.example.api.cadastracategoria.Categoria
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.persistence.OneToOne
import javax.validation.constraints.*

class DetalheLivroDto(
    val nomeLivro: String,
    val resumo: String,
    val sumario: String,
    val preco: Double,
    val paginas: Int,
    val isbn: String,
    val dataPublicacao: LocalDate,
    val categoriaLivro: String,
    val autorNome: String,
    val autorDescricao: String
) {
}