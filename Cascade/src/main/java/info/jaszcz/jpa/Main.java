package info.jaszcz.jpa;

import java.util.ArrayList;
import java.util.List;

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

		List<Phone> phones = new ArrayList<Phone>();
		Phone phones1 = new Phone();
		phones1.setType("mobile");
		phones1.setNumber("12343245");
		phones.add(phones1);
		Phone phones2 = new Phone();
		phones2.setType("global");
		phones2.setNumber("4564745546");
		phones.add(phones1);
		phones.add(phones2);
		employee.setPhones(phones);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
