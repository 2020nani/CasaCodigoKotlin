package com.example.api.cadastralivro

import com.example.api.cadastraautor.Autor
import com.example.api.cadastracategoria.Categoria
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.*

@Entity
class Livro(
    @field:NotBlank
    val titulo: String,
    @field:NotBlank
    @field:Size(max = 500)
    val resumo: String,
    val sumario: String,
    @field:Min(20)
    @field:NotNull
    val preco: Double,
    @field:Min(100)
    @field:NotNull
    val paginas: Int,
    @field:NotBlank
    val isbn: String,
    @field:Future
    @field:NotNull
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val dataPublicacao: LocalDate,
    @field:NotNull
    @field:OneToOne
    val categoria: Categoria,
    @field:NotNull
    @field:OneToOne
    val autor: Autor
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreationTimestamp
    val criadoEm: LocalDate?=null
}
