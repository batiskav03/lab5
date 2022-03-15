package tools;
import exception.*;
import data.*;
import java.util.Scanner;

/**
 * The type Asker.
 *
 * @author Калабухов Максим Класс - Спрашивает свойства объекта Dragon
 */
public class Asker {

    /**
     * Свойство - Scanner
     */
    private final Scanner scanner;

    /**
     * Instantiates a new Asker.
     *
     * @param scanner Scanner
     */
    public Asker(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Ask name string.
     *
     * @return the string
     */
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

    /**
     * Ask coordinates.
     *
     * @return the coordinates
     */
    public Coordinates askCoordinates() {
        Coordinates coordinates;
        System.out.println("Enter coordinates:");
        coordinates = new Coordinates(askX(),askY());
        return coordinates;
    }

    /**
     * Ask x long.
     *
     * @return the long
     */
    public long askX() {
        String strX;
        long x;
        try {
            System.out.print("x = ");
            strX = scanner.nextLine().trim();
            if (strX.equals("")) throw new ElementMustNotBeEmptyException();
            x = Long.parseLong(strX);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Invalid value");
            return askX();

        }
        catch (ElementMustNotBeEmptyException ex)
        {

            System.out.println(ex.getMessage());
            return askX();

        }

        return x;
    }

    /**
     * Ask y float.
     *
     * @return the float
     */
    public float askY(){
        String strY;
        float y;
        try {
            System.out.print("y = ");
            strY = scanner.nextLine().trim();
            if (strY.equals("")) throw new ElementMustNotBeEmptyException();
            y = Float.parseFloat(strY);
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Invalid value");
            return askY();
        }
        catch (ElementMustNotBeEmptyException ex)
        {
            System.out.println(ex.getMessage());
            return askY();
        }

        return y;
    }

    /**
     * Ask age integer.
     *
     * @return the integer
     */
    public Integer askAge(){
        String age;
        int askage;
        try {
            System.out.print("Enter age:");
            age = scanner.nextLine().trim();
            if (age.equals("")) throw new ElementMustNotBeEmptyException();
            askage = Integer.parseInt(age);
            if (askage <= 0) throw new InvalidElementValueException();
        } catch (NumberFormatException ex)
        {
            System.out.println("Invalid value");
            return askAge();
        }
        catch (ElementMustNotBeEmptyException ex)
        {
            System.out.println(ex.getMessage());
            return askAge();
        } catch (InvalidElementValueException ex) {
            System.out.println("Age cant be negative");
            return askAge();
        }

        return askage;
    }

    /**
     * Ask color.
     *
     * @return the color
     */
    public Color askColor(){
        String strColor;
        Color color;
        try {
            System.out.print("Choose color (black, yellow or blue):");
            strColor = scanner.nextLine().trim();
            String str = strColor.toUpperCase();
            if (str.equals("")) throw new ElementMustNotBeEmptyException();
            color = Color.valueOf(str);
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            return askColor();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            return askColor();
        }

        return color;
    }

    /**
     * Ask dragon type.
     *
     * @return the dragon type
     */
    public DragonType askDragonType(){
        String strType;
        DragonType dragonType;
        try {
            System.out.print("Choose type of dragon (water, underground, air, fire):");
            strType = scanner.nextLine().trim();
            String str = strType.toUpperCase();
            if (str.equals("")) throw new ElementMustNotBeEmptyException();
            dragonType = DragonType.valueOf(str);
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            return askDragonType();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            return askDragonType();
        }
        return dragonType;
    }

    /**
     * Ask dragon character.
     *
     * @return the dragon character
     */
    public DragonCharacter askDragonCharacter(){
        String strType;
        DragonCharacter dragonCharacter;
        try {
            System.out.print("Choose dragon character (wise, evil or good):");
            strType = scanner.nextLine().trim();
            String str = strType.toUpperCase();
            if (str.equals("")) throw new ElementMustNotBeEmptyException();
            dragonCharacter = DragonCharacter.valueOf(str);
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            return askDragonCharacter();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            return askDragonCharacter();

        }
        return dragonCharacter;
    }

    /**
     * Ask dragon head.
     *
     * @return the dragon head
     */
    public DragonHead askDragonHead(){
        DragonHead dragonhead;
        System.out.println("Enter eyes and tooth count of dragon:");
        dragonhead = new DragonHead(askEyesCount(),askToothCount());
        return dragonhead;
    }

    /**
     * Ask tooth count.
     *
     * @return the float
     */
    public float askToothCount(){
        String strTooth;
        float tooth;
        try {
            System.out.print("Enter tooth count:");
            strTooth = scanner.nextLine().trim();
            if (strTooth.equals("")) throw new ElementMustNotBeEmptyException();
            tooth = Float.parseFloat(strTooth);
        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            return askToothCount();
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            return askToothCount();
        }
        return tooth;
    }

    /**
     * Ask eyes count.
     *
     * @return the long
     */
    public long askEyesCount() {
        String strEyes;
        long eyes;
        try {
            System.out.print("Enter eyes count:");
            strEyes = scanner.nextLine().trim();
            if (strEyes.equals("")) throw new ElementMustNotBeEmptyException();
            eyes = Long.parseLong(strEyes);
        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            return askEyesCount();
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            return askEyesCount();
        }
        return eyes;
    }

}
