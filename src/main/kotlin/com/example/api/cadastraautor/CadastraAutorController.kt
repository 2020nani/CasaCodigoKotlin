package com.example.api.cadastraautor

import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.created
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/autor")
class CadastraAutorController(
    val autorRepository: AutorRepository
) {

    @Post
    @Transactional
    fun cadastraAutor(@Body @Valid autorForm:AutorForm): HttpResponse<Any>{
        val autor: Autor = autorForm.converte()
        autorRepository.save(autor)
        val Uri = UriBuilder.of("autores/{id}")
            .expand(mutableMapOf(Pair("id", autor.id)))
        return created(autor, Uri)
    }
}