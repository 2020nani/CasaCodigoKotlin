package com.example.api.cadastracategoria

import com.example.api.validacoescustomizada.CategoriaUnica
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
class CategoriaForm (
    @field:NotBlank
    @field:CategoriaUnica
    val nome: String
        )
/*
 nome é obrigatório
O nome não pode ser duplicado
 */