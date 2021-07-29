package com.example.api.listalivro

import com.example.api.cadastralivro.Livro
import com.example.api.cadastralivro.LivroRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.stream.Collectors

@Controller(value = "/livros")
class ListaLivroController(
    val livroRepository: LivroRepository
) {

    @Get
    fun listaLivros(): HttpResponse<Any>{
        val livros: List<Livro> = livroRepository.findAll().toList()
        val livrosDto = livros.stream().map {livro -> LivroDto(livro.id, livro.titulo) }.collect(Collectors.toList())

        return HttpResponse.ok( livrosDto )
    }

    @Get(value = "/{id}")
    fun listaLivroPorId(@PathVariable("id") id:Long): HttpResponse<Any>{
        val livro = livroRepository.findById(id)
        if(livro.isPresent){
            return HttpResponse.ok(DetalheLivroDto(
                livro.get().titulo,
                livro.get().resumo,
                livro.get().sumario,
                livro.get().preco,
                livro.get().paginas,
                livro.get().isbn,
                livro.get().dataPublicacao,
                livro.get().categoria.nome,
                livro.get().autor.nome,
                livro.get().autor.descricao
            ))
        }
        return HttpResponse.unprocessableEntity()
    }
}