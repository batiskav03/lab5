package data;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Float y; //Значение поля должно быть больше -578, Поле не может быть null

    public Coordinates(long x, float y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public Float getY() {
        return y;
    }


    @Override
    public String toString() {
        return "{x = " + x + ", y = " + y + "}";
    }
}
