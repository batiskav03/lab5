package data;

public class DragonHead {
    private long eyesCount;
    private float toothCount;

    public DragonHead(long eyesCount, float toothCount) {
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }

    @Override
    public String toString() {
        return "{eyes = " + eyesCount + ", tooth = " + toothCount + "}";
    }
}