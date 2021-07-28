package com.example.api.validacoescustomizada

import com.example.api.cadastraautor.AutorRepository
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
@Constraint(validatedBy = [CategoriaUnicaValidator::class])
annotation class CategoriaUnica(
    val message: String = "Ja existe objeto cadastrado com este email",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []

)

@Singleton
class CategoriaUnicaValidator(
    val categoriaRepository: CategoriaRepository
) : ConstraintValidator<CategoriaUnica, String> {

    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<CategoriaUnica>,
        context: ConstraintValidatorContext
    ): Boolean {

        if(value == null) return true

        if(categoriaRepository.existsByNome(value)){
            return false
        }
        return true
    }

}
