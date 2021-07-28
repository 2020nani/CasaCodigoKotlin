package com.example.api.cadastracategoria

import com.example.api.cadastraautor.Autor
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/categoria")
class CadastraCategoriaController(
    val categoriaRepository: CategoriaRepository
) {

    @Post
    @Transactional
    fun criaCategoria(@Body @Valid categoriaForm: CategoriaForm): HttpResponse<Any>{
        val categoria: Categoria = categoriaForm.converte()
        categoriaRepository.save(categoria)
        val Uri = UriBuilder.of("autores/{id}")
            .expand(mutableMapOf(Pair("id", categoria.id)))
        return HttpResponse.created(categoria, Uri)
    }
}