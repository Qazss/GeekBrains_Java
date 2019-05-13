package Exceptions;

import Exceptions.MyExceptions.*;

public class ArraySum {
    private static int size = 4;

    public static int getArraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        if(!isArrSizeCorrect(arr)) throw new MyArraySizeException("Некорректная длина массива");

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(isInteger(arr[i][j])) {
                    result += Integer.parseInt(arr[i][j]);
                } else {
                    throw new MyArrayDataException("Некорректный символ в " + i + " строке " + j + " столбце массива");
                }
            }
        }
        return result;
    }

    private static boolean isArrSizeCorrect(String[][] arr){

        if(arr.length == size){
            for(int i = 0; i < arr.length; i++){
                if(arr[i].length != size){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean isInteger(String a){

        try {
            Integer.parseInt(a);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
