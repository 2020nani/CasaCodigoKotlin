package com.example.api.cadastralivro

import com.example.api.cadastraautor.AutorRepository
import com.example.api.cadastracategoria.CategoriaRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/livro")
class CadastraLivroController (
    val autorRepository: AutorRepository,
    val categoriaRepository: CategoriaRepository,
    val livroRepository: LivroRepository
        ){

    @Post
    @Transactional
    fun criaLivro(@Body @Valid livroForm: LivroForm): HttpResponse<Any>{

        val livro: Livro =  livroForm.converte(autorRepository,categoriaRepository)

        livroRepository.save(livro)
        val Uri = UriBuilder.of("livros/{id}")
            .expand(mutableMapOf(Pair("id", livro.id)))
        return HttpResponse.created(livro, Uri)
    }
}