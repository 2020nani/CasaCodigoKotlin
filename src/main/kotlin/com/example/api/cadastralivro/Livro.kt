package com.example.api.cadastralivro

import com.example.api.cadastraautor.Autor
import com.example.api.cadastracategoria.Categoria
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

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
