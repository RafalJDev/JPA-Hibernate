package info.jaszcz.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//in polish to clearly see what was change (for learning purpose)
@DiscriminatorValue(value="profesorek")
public class Profesor extends Person {
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
