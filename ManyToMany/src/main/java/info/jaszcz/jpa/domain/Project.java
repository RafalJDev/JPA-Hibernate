package info.jaszcz.jpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToMany
	// @JoinTable creates "mapping" table ?
	//Simply shows the relations beetween tables employee and project
	//e.g. id_project1 points to id_employee1/2/3, id_project2 points to id_employee2/4/5 
	//// in polish to clearly see what was change (for learning purpose) 
	@JoinTable(name = "pracownicy_w_projektach", joinColumns = {
			@JoinColumn(name = "id_projektu") }, inverseJoinColumns = { @JoinColumn(name = "id_pracownika") })
	List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project() {
	}

	public Project(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
