package MainTask;

public class Main {
    public static void main(String[] args) {
        // 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся)
        String[] string = {"красный", "синий", "желтый", "красный", "зеленый", "синий","фиолетовый", "красный",
                           "черный", "желтый", "красный", "зеленый", "синий","серый", "белый"};

        ArraySearcher.getUniqueValues(string);
        ArraySearcher.getArrayInfo(string);


        // 2. Телефонный справочник
        try {
            PhoneBook.addNumber("89035534313", "Иванов");
            PhoneBook.addNumber("89991085634", "Иванов");
            PhoneBook.addNumber("+79853421325", "Петров");
        } catch (PhoneNumberException e) {
            e.printStackTrace();
        }

        PhoneBook.getNumber("Иванов");
    }
}
