package info.jaszcz.jpa.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// in polish to clearly see what was change (for learning purpose)
@DiscriminatorValue(value = "studencik")
public class Student extends Person {
	private double averageGrade;

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

}
