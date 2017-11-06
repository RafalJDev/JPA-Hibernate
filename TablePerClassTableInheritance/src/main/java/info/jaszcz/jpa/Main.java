package info.jaszcz.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.jaszcz.jpa.domain.Person;
import info.jaszcz.jpa.domain.Profesor;
import info.jaszcz.jpa.domain.Student;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Profesor profesor = new Profesor();
		profesor.setFirstName("Jan");
		profesor.setLastName("Nowaczek");
		profesor.setSalary(2343.0);
		
		Student student = new Student();
		student.setFirstName("Rafaello");
		student.setLastName("Jenkerro");
		student.setAverageGrade(4.75);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(profesor);
		entityManager.persist(student);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
