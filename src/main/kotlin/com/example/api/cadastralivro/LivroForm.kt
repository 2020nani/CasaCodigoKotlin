package com.example.api.cadastralivro

import com.example.api.cadastraautor.AutorRepository
import com.example.api.cadastracategoria.CategoriaRepository
import com.example.api.validacoescustomizada.ExisteCategoria
import com.example.api.validacoescustomizada.ExisteAutor
import com.example.api.validacoescustomizada.IsbnUnico
import com.example.api.validacoescustomizada.TituloUnico
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.*

@Introspected
class LivroForm(
    @field:NotBlank
    @field:TituloUnico
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
    @field:IsbnUnico
    val isbn: String,
    @field:Future
    @field:NotNull
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val dataPublicacao: LocalDate,
    @field:NotNull
    @field:ExisteCategoria
    val categoriaId: Long,
    @field:NotNull
    @field:ExisteAutor
    val autorId: Long

) {
    fun converte(autorRepository: AutorRepository, categoriaRepository: CategoriaRepository): Livro {
        val autor = autorRepository.findById(autorId).get()
        val categoria = categoriaRepository.findById(categoriaId).get()
        return Livro(titulo,resumo,sumario,preco,paginas,isbn,dataPublicacao,categoria,autor)
    }

}
/*
Isbn é único
Data que vai entrar no ar precisa ser no futuro
A categoria não pode ser nula
O autor não pode ser nulo
 */