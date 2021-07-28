package com.example.api.cadastraautor

import com.example.api.validacoescustomizada.EmailUnico
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Autor (
    @NotBlank
    val nome: String,
    @NotBlank
    @Email
    val email: String,
    @NotBlank
    @Size(max = 400)
    val descricao: String
        ){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreationTimestamp
    val criadoEm:LocalDate?=null
}
/*
O instante não pode ser nulo
O email é obrigatório
O email tem que ter formato válido
O nome é obrigatório
A descrição é obrigatória e não pode passar de 400 caracteres
 */