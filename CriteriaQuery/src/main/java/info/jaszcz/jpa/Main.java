package info.jaszcz.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import info.jaszcz.jpa.domain.Address;
import info.jaszcz.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		// select e from employee e where e.salary > 3000.0 and e.salary<5000.0

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeee = criteriaQuery.from(Employee.class);

		Path<Double> salary = employeee.get("salary");
		criteriaQuery.select(employeee).where(criteriaBuilder.and(criteriaBuilder.greaterThan(salary, 3000.0),
				criteriaBuilder.lessThan(salary, 5000.0)));

		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
		List<Employee> employees = query.getResultList();

		for (Employee empl : employees) {
			System.out.println(empl.getFirstName());
			System.out.println(empl.getLastName());
			System.out.println(empl.getSalary());
		}

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void addEmployees() {
		addEmployees("Mateo", "Tylde", 1234.8);
		addEmployees("Mateo345", "Tylde2", 4500.8);
		addEmployees("Mateo45", "Tylde3", 3006.8);
		addEmployees("Mate1o", "Tylde4", 12234.8);
		addEmployees("Mateo54", "Tylde5", 11234.8);
	}

	public static void addEmployees(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
