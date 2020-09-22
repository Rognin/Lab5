package main;

import java.time.LocalDate;

public class LabWork implements Comparable<LabWork> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double minimalPoint; //Значение поля должно быть больше 0
    private String description; //Длина строки не должна быть больше 843, Поле не может быть null
    private Difficulty difficulty; //Поле не может быть null
    private Person author; //Поле не может быть null


    public LabWork(Long id, String name, Coordinates coordinates, LocalDate creationDate, double minimalPoint, String description, Difficulty difficulty, Person author) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.minimalPoint = minimalPoint;
        this.description = description;
        this.difficulty = difficulty;
        this.author = author;
    }

    public LabWork(String name, Coordinates coordinates, double minimalPoint, String description, Difficulty difficulty, Person author) {
        this.id = (long) Main.getSet().size() + 1;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.minimalPoint = minimalPoint;
        this.description = description;
        this.difficulty = difficulty;
        this.author = author;
    }

    public LabWork(Long id, String name, Coordinates coordinates, double minimalPoint, String description, Difficulty difficulty, Person author) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.minimalPoint = minimalPoint;
        this.description = description;
        this.difficulty = difficulty;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public double getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(double minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "LabWork {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", coordinates = " + coordinates +
                ", creationDate = " + creationDate +
                ", minimalPoint = " + minimalPoint +
                ", description = '" + description + '\'' +
                ", difficulty = " + difficulty +
                ", author = " + author +
                "}";
    }

    @Override
    public int compareTo(LabWork lw) {

        if (this.getMinimalPoint() == lw.getMinimalPoint()) {
            return 0;
        }

        if (this.getMinimalPoint() < lw.getMinimalPoint()) {
            return -1;
        } else {
            return 1;
        }
    }
}