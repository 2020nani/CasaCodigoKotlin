package com.example.api.cadastracategoria

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller(value = "/categoria")
class CadastraCategoriaController {

    @Post
    @Transactional
    fun criaCategoria(@Body @Valid categoriaForm: CategoriaForm){

    }
}