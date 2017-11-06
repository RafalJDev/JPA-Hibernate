package info.jaszcz.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.jaszcz.jpa.domain.Employee;
import info.jaszcz.jpa.domain.Phone;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(2344.3);
		Phone phones1= new Phone();		
		phones1.setType("mobile");
		phones1.setNumber("12343245");
		phones1.setEmployee(employee);
		Phone phones2= new Phone();		
		phones2.setNumber("23452345423");
		phones2.setType("home");
		phones2.setEmployee(employee);
		
		entityManager.getTransaction().begin();
		entityManager.persist(phones1);
		entityManager.persist(phones2);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
