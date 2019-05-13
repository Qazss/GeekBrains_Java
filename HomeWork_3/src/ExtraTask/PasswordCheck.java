package ExtraTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {
    private static final String passwordRegexp = "^(?=\\S*[0-9])(?=\\S*[A-z])(?=\\S*[a-z])(?=\\S*[@#$%^&+=])\\S{8,20}$";

    public static void checkPassword(String password) throws PasswordCheckException{
        Pattern pattern = Pattern.compile(passwordRegexp);
        Matcher matcher = pattern.matcher(password);
        boolean isCorrect = matcher.matches();

        if(isCorrect){
            System.out.println("Пароль корректен");
        } else {
            throw new PasswordCheckException(password);
        }
    }
}
