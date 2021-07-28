package com.example.api.validacoescustomizada

import com.example.api.cadastraautor.AutorRepository
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
@Constraint(validatedBy = [ExisteAutorValidator::class])
annotation class ExisteAutor(
    val message: String = "Nao existe um livro cadastrado com este id",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []

)

@Singleton
class ExisteAutorValidator(
    val autorRepository: AutorRepository
) : ConstraintValidator<ExisteAutor, Long> {

    override fun isValid(
        value: Long?,
        annotationMetadata: AnnotationValue<ExisteAutor>,
        context: ConstraintValidatorContext
    ): Boolean {

        if(value == null) return false

        if(autorRepository.existsById(value)){
            return true
        }
        return false
    }

}
