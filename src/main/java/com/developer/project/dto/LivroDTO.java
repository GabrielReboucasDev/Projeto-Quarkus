package com.developer.project.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LivroDTO {

	@NotBlank(message = "Título é obrigatório")
	public String titulo;

	@NotBlank(message = "Autor é obrigatório")
	public String autor;

	@NotNull(message = "Ano de publicação é obrigatório")
	@Min(value = 1000, message = "Ano inválido")
	public Integer anoPublicacao;

	@NotNull(message = "Data de leitura é obrigatória")
	public LocalDate dataLeitura;

	@NotNull
	@Min(value = 1, message = "Avaliação mínima é 1")
	@Max(value = 10, message = "Avaliação máxima é 10")
	public Integer avaliacao;

	@Size(max = 500, message = "Observações devem ter no máximo 500 caracteres")
	public String observacoes;

}