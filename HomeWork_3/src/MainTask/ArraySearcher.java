package MainTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArraySearcher {

    public static void getUniqueValues(String[] arr){
        HashSet<String> result = new HashSet<>(Arrays.asList(arr));
        System.out.println(result);
    }

    public static void getArrayInfo(String[] arr){
        HashMap<String, Integer> result = new HashMap<>();

        for(String str: arr){
            Integer quantity = result.get(str);
            result.put(str, quantity == null? 1 : quantity + 1);
        }

        for (Map.Entry<String, Integer> o: result.entrySet()){
            System.out.print(o.getKey() + " " + o.getValue() + " | ");
        }
        System.out.println();
    }
}
