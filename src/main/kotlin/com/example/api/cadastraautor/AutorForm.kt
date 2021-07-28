package com.example.api.cadastraautor

import com.example.api.validacoescustomizada.EmailUnico
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class AutorForm (
    @field:NotBlank
    val nome: String,
    @field:NotBlank
    @field:Email
    @field:EmailUnico
    val email: String,
    @field:NotBlank
    @field:Size(max = 400)
    val descricao: String
        ) {
    fun converte(): Autor {

        return Autor(nome, email, descricao)
    }
}