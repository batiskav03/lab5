package exception;

public class ElementMustNotBeEmptyException extends Exception{
    public ElementMustNotBeEmptyException(){
        super("Element cant be empty");
    }

}
