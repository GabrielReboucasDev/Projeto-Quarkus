package com.developer.project.service;

import java.util.List;

import com.developer.project.dto.LivroDTO;
import com.developer.project.entity.LivroEntity;
import com.developer.project.repository.LivroRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class LivroService {

	@Inject
	LivroRepository livroRepository;

	@Transactional
	public LivroEntity criar(LivroDTO dto) {
		LivroEntity livro = new LivroEntity();
		atualizarDados(livro, dto);
		livroRepository.persist(livro);
		return livro;
	}

	public List<LivroEntity> listarTodos() {
		return livroRepository.listAll();
	}

	public LivroEntity buscarPorId(Integer id) {
		return livroRepository.findById(id);
	}

	@Transactional
	public LivroEntity atualizar(Integer id, LivroDTO dto) {
		LivroEntity livro = livroRepository.findById(id);
		if (livro == null) {
			return null;
		}
		atualizarDados(livro, dto);
		return livro;
	}

	@Transactional
	public boolean remover(Integer id) {
		return livroRepository.deleteById(id);
	}

	private void atualizarDados(LivroEntity livro, LivroDTO dto) {
		livro.titulo = dto.titulo;
		livro.autor = dto.autor;
		livro.anoPublicacao = dto.anoPublicacao;
		livro.dataLeitura = dto.dataLeitura;
		livro.avaliacao = dto.avaliacao;
		livro.observacoes = dto.observacoes;
	}

}