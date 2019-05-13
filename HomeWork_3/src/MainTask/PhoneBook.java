package MainTask;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private static HashMap<String, String> phoneBook = new HashMap<>();
    private static final String phoneRegexp = "^(\\+7|8)\\d{10}$";
    private static final String lastNameRegexp = "^[А-Я][а-я]+$";

    public static void addNumber(String number, String lastName) throws PhoneNumberException{

        if(isCorrectData(number, phoneRegexp) && isCorrectData(lastName, lastNameRegexp)) {
            phoneBook.put(number, lastName);
        } else {
            throw new PhoneNumberException(number, lastName);
        }
    }

    public static void getNumber(String lastName){
        boolean findRecord = false;

        for (Map.Entry<String, String> o: phoneBook.entrySet()){
            if(o.getValue().equals(lastName)) {
                System.out.println(o.getKey() + " " + o.getValue());
                findRecord = true;
            }
        }

        if(!findRecord){
            System.out.println("Нет данных по указанной Фамилии");
        }
    }

    private static boolean isCorrectData(String string, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        return m.matches();
    }
}
