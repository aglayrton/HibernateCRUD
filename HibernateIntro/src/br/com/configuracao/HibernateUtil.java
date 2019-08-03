package br.com.configuracao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*2ºPASSO
 * A utilização do Hibernate requer uma classe que promova a inicialização 
 * e que acesse o SessionFactory para obter um objeto Session. 
 * A classe executa o método configure(), que carrega as informações do arquivo
hibernate.cfg.xml e, então, cria o SessionFactory para obter o objeto Session.
 * */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Initial SessionFactory creation failed "+ e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	} 
}
