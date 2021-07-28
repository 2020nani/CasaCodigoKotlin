package com.example.api.validacoescustomizada

import com.example.api.cadastralivro.LivroRepository
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [TituloUnicoValidator::class])
annotation class TituloUnico(
    val message: String = "Ja existe um livro cadastrado com este titulo",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []

)

@Singleton
class TituloUnicoValidator(
    val livroRepository: LivroRepository
) : ConstraintValidator<TituloUnico, String> {

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<TituloUnico>,
        context: ConstraintValidatorContext
    ): Boolean {

        if(value == null) return true

        if(livroRepository.existsByTitulo(value)){
            return false
        }
        return true
    }

}
