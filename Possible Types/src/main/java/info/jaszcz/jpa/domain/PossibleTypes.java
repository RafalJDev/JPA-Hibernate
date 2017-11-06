package info.jaszcz.jpa.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PossibleTypes {
	@Id
	private long id;

	private int someInt;
	private short someShort;
	private float someFloat;
	private double someDouble;
	private boolean someBoolean;

	private Integer someInteger;
	private BigDecimal someBigDecimal;
	private BigInteger someBigInteger;

	private int[] integerArr;
	private double[] doubnleArray;

	private MyEnum myEnum;

	@Transient
	private int ignoreField;

	public int getIgnoreField() {
		return ignoreField;
	}

	public void setIgnoreField(int ignoreField) {
		this.ignoreField = ignoreField;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSomeInt() {
		return someInt;
	}

	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}

	public short getSomeShort() {
		return someShort;
	}

	public void setSomeShort(short someShort) {
		this.someShort = someShort;
	}

	public float getSomeFloat() {
		return someFloat;
	}

	public void setSomeFloat(float someFloat) {
		this.someFloat = someFloat;
	}

	public double getSomeDouble() {
		return someDouble;
	}

	public void setSomeDouble(double someDouble) {
		this.someDouble = someDouble;
	}

	public boolean isSomeBoolean() {
		return someBoolean;
	}

	public void setSomeBoolean(boolean someBoolean) {
		this.someBoolean = someBoolean;
	}

	public Integer getSomeInteger() {
		return someInteger;
	}

	public void setSomeInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}

	public BigDecimal getSomeBigDecimal() {
		return someBigDecimal;
	}

	public void setSomeBigDecimal(BigDecimal someBigDecimal) {
		this.someBigDecimal = someBigDecimal;
	}

	public BigInteger getSomeBigInteger() {
		return someBigInteger;
	}

	public void setSomeBigInteger(BigInteger someBigInteger) {
		this.someBigInteger = someBigInteger;
	}

	public int[] getIntegerArr() {
		return integerArr;
	}

	public void setIntegerArr(int[] integerArr) {
		this.integerArr = integerArr;
	}

	public double[] getDoubnleArray() {
		return doubnleArray;
	}

	public void setDoubnleArray(double[] doubnleArray) {
		this.doubnleArray = doubnleArray;
	}

	public MyEnum getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(MyEnum myEnum) {
		this.myEnum = myEnum;
	}

}
