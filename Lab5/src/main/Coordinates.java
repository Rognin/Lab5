package main;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates {" +
                "x = " + x +
                ", y = " + y +
                "}";
    }
}