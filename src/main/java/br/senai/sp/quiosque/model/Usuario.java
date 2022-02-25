package br.senai.sp.quiosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {
	private Long id;
	private String nome;
	private int cep;
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private int celular;
	private int telefone;
	private String email;
	private String prodInteresse;
	private String genero;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNasc;
	
	public int getIdade() {
		int dia = dataNasc.get(Calendar.DAY_OF_MONTH);
		int mes = dataNasc.get(Calendar.MONTH);
		int ano = dataNasc.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes+1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
		}
	
	
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProdInteresse() {
		return prodInteresse;
	}

	public void setProdInteresse(String prodInteresse) {
		this.prodInteresse = prodInteresse;
	}
	
	

}
