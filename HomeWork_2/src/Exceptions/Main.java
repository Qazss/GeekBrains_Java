package Exceptions;

import Exceptions.MyExceptions.*;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = String.valueOf(i + j);
            }
        }
        //arr[2][2] = "a";

        try{
            System.out.println(ArraySum.getArraySum(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
