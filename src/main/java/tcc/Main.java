package tcc;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import models.Aluno;
import models.Curso;

public class Main {

	private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "connection.db";  

    static {
       emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

   // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
       return emFactoryObj.createEntityManager();
       }
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		URI uri = URI.create("http://www.google.com.br");
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> conteudoGoogle = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);	

		EntityManager entityMgr = getEntityManager();
		
		Curso ti = new Curso(1, "TI", null);
		Aluno lucas = new Aluno(1, "Lucas", ti);
		Aluno pedro = new Aluno(13, "Pedro", ti);
		try {
			entityMgr.getTransaction().begin();
			entityMgr.persist(lucas);
			entityMgr.persist(pedro);
			entityMgr.persist(ti);
			entityMgr.flush();
			entityMgr.getTransaction().commit();
		} catch (Exception ex) {
			entityMgr.getTransaction().rollback();
		}
	}

}
