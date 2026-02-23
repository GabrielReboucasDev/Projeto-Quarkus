package com.developer.project.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.developer.project.dto.LivroDTO;
import com.developer.project.entity.LivroEntity;
import com.developer.project.service.LivroService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Tag(name = "Livros", description = "Gerenciamento da biblioteca pessoal")
@Path("/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroController {

	@Inject
	LivroService livroService;

	@Operation(summary = "Cadastrar um novo livro")
	@POST
	public Response criar(@Valid LivroDTO dto) {
		LivroEntity livro = livroService.criar(dto);
		return Response.status(Response.Status.CREATED).entity(livro).build();
	}

	@Operation(summary = "Listar todos os livros")
	@GET
	public List<LivroEntity> listarTodos() {
		return livroService.listarTodos();
	}

	@Operation(summary = "Buscar livro por ID")
	@GET
	@Path("/{id}")
	public Response buscarPorId(@PathParam("id") Integer id) {
		LivroEntity livro = livroService.buscarPorId(id);
		if (livro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(livro).build();
	}

	@Operation(summary = "Atualizar informações de um livro")
	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Integer id, @Valid LivroDTO dto) {
		LivroEntity livro = livroService.atualizar(id, dto);
		if (livro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(livro).build();
	}

	@Operation(summary = "Deletar um livro da biblioteca")
	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") Integer id) {
		boolean removido = livroService.remover(id);
		if (!removido) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.noContent().build();
	}

}