package info.jaszcz.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.jaszcz.jpa.domain.Employee;
import info.jaszcz.jpa.domain.Project;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Project project1 = new Project();
		project1.setName("ProjektRJ 1");
		Project project2 = new Project();
		project2.setName("ProjektRJ 2");
		
		Employee employee1 = new Employee("Jan", "Nowak",22344.3);
		Employee employee2 = new Employee("Maria", "Nowak",32344.3);
		Employee employee3 = new Employee("Raf", "Jaas",42344.3);
		Employee employee4 = new Employee("Kuun", "Brat",52344.3);
		Employee employee5 = new Employee("Dla", "Czego",62344.3);
		
		List<Employee> employees1 = new ArrayList<Employee>();
		employees1.add(employee1);
		employees1.add(employee2);
		employees1.add(employee3);		
		List<Employee> employees2 = new ArrayList<Employee>();
		employees2.add(employee2);
		employees2.add(employee4);
		employees2.add(employee5);
		
		project1.setEmployees(employees1);
		project2.setEmployees(employees2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(project1);
		entityManager.persist(project2);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.persist(employee4);
		entityManager.persist(employee5);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
