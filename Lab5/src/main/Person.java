package main;
public class Person {
	private String name; // Поле не может быть null, Строка не может быть пустой
	private int height; // Значение поля должно быть больше 0
	private long weight; // Поле не может быть null, Значение поля должно быть больше 0
	private String passportID; // Значение этого поля должно быть уникальным, Длина строки не должна быть
								// больше 29, Поле не может быть null
	private Color eyeColor; // Поле может быть null

	public Person(String name, int height, long weight, String passportID, Color eyeColor) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.passportID = passportID;
		this.eyeColor = eyeColor;
	}

	@Override
	public String toString() {
		return "Person {" +
				"name = '" + name + '\'' +
				", height = " + height +
				", weight = " + weight +
				", passportID = '" + passportID + '\'' +
				", eyeColor = " + eyeColor +
				"}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public String getPassportID() {
		return passportID;
	}

	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}

	public Color getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(Color eyeColor) {
		this.eyeColor = eyeColor;
	}
}