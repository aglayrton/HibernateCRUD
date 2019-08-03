/* 3º As classes JavaBeans são usadas para representar os registros em uma tabela do banco de dados.
Os dados são obtidos e/ou lidos do banco de dados por meio de getters e setters. O mapeamento das
classes para as tabelas é realizado por meio do arquivo de mapeamento do Hibernate. Em geral, tem-se
um arquivo para cada classe e uma classe representando uma tabela*/

package br.com.pessoa;

import java.io.Serializable;

public class Pessoa implements Serializable{
	private int id;
	private String nome, apelido, endereco;
	
	public Pessoa(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
