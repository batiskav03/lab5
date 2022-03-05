package tools;
import Exception.*;
import data.*;
import java.util.Scanner;



public class Asker {
    private final Scanner scanner;
    public Asker(Scanner scanner) {
        this.scanner = scanner;
    }
    public String askName() {
        String name;
        try{
            System.out.print("Enter title:");
            name = scanner.nextLine().trim();
            if (name.equals("")) throw new ElementMustNotBeEmptyException();
        }
        catch (ElementMustNotBeEmptyException e) {
            System.out.println(e.getMessage());
            return askName();
        }

        return name;
    }

    public Coordinates askCoordinates() {
        Coordinates coordinates;
        System.out.println("Enter coordinates:");
        coordinates = new Coordinates(askX(),askY());
        return coordinates;
    }

    public long askX() {
        String strX;
        long x;
        System.out.print("x = ");
        strX = scanner.nextLine().trim();
        x = Long.parseLong(strX);
        return x;
    }

    public float askY(){
        String strY;
        float y;
        System.out.print("y = ");
        strY = scanner.nextLine().trim();
        y = Float.parseFloat(strY);
        return y;
    }

    public Integer askAge(){
        String age;
        int askage;
        System.out.print("Enter age:");
        age = scanner.nextLine().trim();
        askage = Integer.parseInt(age);
        return askage;
    }

    public Color askColor(){
        String strColor;
        Color color;
        System.out.print("Choose color (black, yellow or blue):");
        strColor = scanner.nextLine().trim();
        String str = strColor.toUpperCase();
        color = Color.valueOf(str);
        return color;
    }

    public DragonType askDragonType(){
        String strType;
        DragonType dragonType;
        System.out.print("Choose type of dragon (water, underground, air, fire):");
        strType = scanner.nextLine().trim();
        String str = strType.toUpperCase();
        dragonType = DragonType.valueOf(str);
        return dragonType;
    }

    public DragonCharacter askDragonCharacter(){
        String strType;
        DragonCharacter dragonCharacter;
        System.out.print("Choose dragon character (wise, evil or good):");
        strType = scanner.nextLine().trim();
        String str = strType.toUpperCase();
        dragonCharacter = DragonCharacter.valueOf(str);
        return dragonCharacter;
    }

    public DragonHead askDragonHead(){
        DragonHead dragonhead;
        System.out.println("Enter eyes and tooth count of dragon:");
        dragonhead = new DragonHead(askEyesCount(),askToothCount());
        return dragonhead;
    }

    public float askToothCount(){
        String strTooth;
        float tooth;
        System.out.print("Enter tooth count:");
        strTooth = scanner.nextLine().trim();
        tooth = Float.parseFloat(strTooth);
        return tooth;
    }

    public long askEyesCount() {
        String strEyes;
        long eyes;
        System.out.print("Enter eyes count:");
        strEyes = scanner.nextLine().trim();
        eyes = Long.parseLong(strEyes);
        return eyes;
    }

}
