package info.jaszcz.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.jaszcz.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.3);
		employee.setSalary2(new BigDecimal("123456.3"));
				
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
