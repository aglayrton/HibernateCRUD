/*Já temos a classe que nos fornece o SessionFactory,  * o arquivo de configurações do Hibernate, 
 * a classe POJO e o arquivo de mapeamento para esta classe.Agora estamos prontos para definirmos
 *  a classe que de fato fará o trabalho. Essa classe é normalmente chamada de Classe Helper*/
package br.com.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.configuracao.HibernateUtil;
import br.com.pessoa.Pessoa;

public class Helper {
	//A classe Helper para execução da transação no Hibernate
	
	Session session = null;
	Transaction tx = null;
	
	public String salvarDados(Pessoa p) {
		try {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		return "Dados Inseridos com Sucesso!";
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public void alterarDados(Pessoa p){
		try {
			List<Pessoa> pessoa = new ArrayList<Pessoa>();
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//Buscando o dado persistido
			pessoa.add(p);
			session.update(p);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Pessoa> listarDados(){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "from Pessoa";
			Query query = session.createQuery(hql);
			lista = query.list();
			return lista;
		} catch (Exception e) {
			e.printStackTrace(); 
			return null;
		}
	}

	public List<Pessoa> buscarDados(int id){
		try {
			List<Pessoa> pessoa = new ArrayList<Pessoa>();
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//Buscando o dado persistido
			Pessoa p = (Pessoa) session.load(Pessoa.class, id);
			pessoa.add(p);
			return pessoa;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void excluir(Pessoa pessoa) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.delete(pessoa);
			tx.commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
