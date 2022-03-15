package Exception;

public class RecursiveCommandException extends Exception{
    public RecursiveCommandException(){
        super("Script execution will be infinite");
    }
}