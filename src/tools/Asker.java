package tools;
import java.lang.*;
import data.*;
import java.util.Scanner;
import exception.*;



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


    public Asker(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Спрашивает имя
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
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askName();
        }

        return name;
    }

    /**
     * Спрашивает координаты
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
     * Спрашивает (x) координату
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
            JsonProcessing.log.warning("NumberFormatException");
            return askX();

        }
        catch (ElementMustNotBeEmptyException ex)
        {

            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askX();

        }

        return x;
    }

    /**
     * Спрашивает (у) координату
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
            JsonProcessing.log.warning("NumberFormatException");
            return askY();
        }
        catch (ElementMustNotBeEmptyException ex)
        {
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            System.out.println(ex.getMessage());
            return askY();
        }

        return y;
    }

    /**
     * Спрашивает возраст
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
            JsonProcessing.log.warning("NumberFormatException");
            return askAge();
        }
        catch (ElementMustNotBeEmptyException ex)
        {
            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askAge();
        } catch (InvalidElementValueException ex) {
            System.out.println("Age cant be negative");
            JsonProcessing.log.warning("InvalidElementValueException");

            return askAge();
        }

        return askage;
    }

    /**
     * Спрашивает цвет дракона
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
            JsonProcessing.log.warning("IllegalArgumentException");
            return askColor();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askColor();
        }

        return color;
    }

    /**
     * Спрашивает тип дракона
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
            JsonProcessing.log.warning("IllegalArgumentException");
            return askDragonType();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
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
            JsonProcessing.log.warning("IllegalArgumentException");
            return askDragonCharacter();

        } catch (ElementMustNotBeEmptyException ex) {
            System.out.println(ex.getMessage());
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
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
     * Спрашивает количество зубов
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
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askToothCount();
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            JsonProcessing.log.warning("IllegalArgumentException");
            return askToothCount();
        }
        return tooth;
    }

    /**
     * Спрашивает количество глаз
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
            JsonProcessing.log.warning("ElementMustNotBeEmptyException");
            return askEyesCount();
        } catch (IllegalArgumentException ex) {
            System.out.println("There is no such type");
            JsonProcessing.log.warning("IllegalArgumentException");
            return askEyesCount();
        }
        return eyes;
    }

}
