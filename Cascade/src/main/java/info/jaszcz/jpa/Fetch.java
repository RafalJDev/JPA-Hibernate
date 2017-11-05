package info.jaszcz.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.jaszcz.jpa.domain.Employee;
import info.jaszcz.jpa.domain.Phone;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				
		Employee employee = entityManager.find(Employee.class, 1L);
			
		List<Phone> phones = employee.getPhones();
		
		System.out.println(phones);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
