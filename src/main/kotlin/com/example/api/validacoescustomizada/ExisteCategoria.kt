package com.example.api.validacoescustomizada

import com.example.api.cadastracategoria.CategoriaRepository
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
@Constraint(validatedBy = [ExisteCategoriaValidator::class])
annotation class ExisteCategoria(
    val message: String = "Ja existe uma categoria cadastrado com este nome",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []

)

@Singleton
class ExisteCategoriaValidator(
    val categoriaRepository: CategoriaRepository
) : ConstraintValidator<ExisteCategoria, Long> {

    override fun isValid(
        value: Long?,
        annotationMetadata: AnnotationValue<ExisteCategoria>,
        context: ConstraintValidatorContext
    ): Boolean {

        if(value == null) return false

        if(categoriaRepository.existsById(value)){
            return true
        }
        return false
    }

}
