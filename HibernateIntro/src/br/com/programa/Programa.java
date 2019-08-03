package br.com.programa;

import java.util.List;

import br.com.helper.Helper;
import br.com.pessoa.Pessoa;

public class Programa {
	
	public static void main(String[] args) {
		//inserirDados();
		//alterarDados();
		//consultarDados();
		buscar();
	}
	private static void inserirDados() {
		Pessoa p = new Pessoa();
		p.setNome("Aglayrton");
		p.setEndereco("Rua Queiroz nº2");
		p.setApelido("aglayrton");
		
		Helper h =  new Helper();
		System.out.println(h.salvarDados(p));
	}
	
	private static void alterarDados() {
		Pessoa p = new Pessoa();
		p.setNome("Maria");
		p.setEndereco("Rua Queiroz nº2");
		p.setApelido("Josemilion");
		p.setId(2);
		
		//Pessoa pcolecoes = (Pessoa) session.load(Pessoa.class, p.getId());
		Helper h =  new Helper();
		h.alterarDados(p);
	}
	
	private static void consultarDados() {
		Helper h =  new Helper();
		List<Pessoa> plista = h.listarDados();
		System.out.println("Lista de Usuários:");
		for(Pessoa pessoa:plista){
			System.out.println("Cliente cadastrado é "+pessoa.getNome()+" com id "+pessoa.getId());
		}
	}
	
	private static void buscar() {
		Helper h = new Helper();
		List<Pessoa> pessoa = h.buscarDados(5);
		for(Pessoa pessoaIndividual : pessoa) {
			System.out.println("Usuário: "+pessoaIndividual.getNome());
		}
	}
	
	
}
