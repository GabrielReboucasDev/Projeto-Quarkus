package com.developer.project.controller;

import java.util.List;

import com.developer.project.dto.LivroDTO;
import com.developer.project.entity.LivroEntity;
import com.developer.project.service.LivroService;

import jakarta.inject.Inject;
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

@Path("/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivroController {

	@Inject
	LivroService livroService;

	@POST
	public Response criar(LivroDTO dto) {
		LivroEntity livro = livroService.criar(dto);
		return Response.status(Response.Status.CREATED).entity(livro).build();
	}

	@GET
	public List<LivroEntity> listarTodos() {
		return livroService.listarTodos();
	}

	@GET
	@Path("/{id}")
	public Response buscarPorId(@PathParam("id") Integer id) {
		LivroEntity livro = livroService.buscarPorId(id);
		if (livro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(livro).build();
	}

	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Integer id, LivroDTO dto) {
		LivroEntity livro = livroService.atualizar(id, dto);
		if (livro == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(livro).build();
	}

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