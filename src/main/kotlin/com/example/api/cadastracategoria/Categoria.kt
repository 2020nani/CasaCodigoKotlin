package com.example.api.cadastracategoria

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Categoria (
    @field:NotBlank
    val nome: String
        ){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreationTimestamp
    var criadoEm: LocalDate? = null

}
