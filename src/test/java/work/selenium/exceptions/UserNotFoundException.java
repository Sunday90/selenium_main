package work.selenium.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String userName) {
        super(String.format("Сотрудник %s не найден.",userName));
    }

}
