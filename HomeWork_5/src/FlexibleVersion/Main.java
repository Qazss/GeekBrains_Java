package FlexibleVersion;

import java.util.ArrayList;

public class Main {
    static final int size = 1000000;

    public static void main(String[] args) {
        countArray1();
        countArray2(3);
    }

    private static void countArray1(){
        float[] arr = initArray();

        long start = System.currentTimeMillis();
        countArrValue(arr);
        long finish = System.currentTimeMillis();

        System.out.println("Метод 1: " + (finish-start));
    }

    private static void countArray2(int threadQuantity){
        int dimension = size / threadQuantity;
        int residue = size - (threadQuantity * dimension);

        float[] arrMain = initArray();
        ArrayList<float[]> arrParts = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        long start = System.currentTimeMillis();

        // Разибваем основной массив на подмассивы
        if(isEven(threadQuantity)){
            for(int i = 0; i < threadQuantity; i++){
                arrParts.add(new float[dimension]);
                System.arraycopy(arrMain, i * dimension, arrParts.get(i), 0, dimension);
            }
        } else {
            for(int i = 0; i < threadQuantity - 1; i++) {
                arrParts.add(new float[dimension]);
                System.arraycopy(arrMain, i * dimension, arrParts.get(i), 0, dimension);
            }
            arrParts.add(new float[dimension + residue]);
            System.arraycopy(arrMain, size - (dimension + residue), arrParts.get(threadQuantity-1), 0, dimension + residue);
        }

        // Создаем и стартуем Потоки
        for(int i = 0; i < threadQuantity; i++){
            threads.add(new ArrayCountThread(arrParts.get(i)));
            threads.get(i).start();
        }

        for(Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Склеиваем массивы в один
        if(isEven(threadQuantity)) {
            for (int i = 0; i < threadQuantity; i++) {
                System.arraycopy(arrParts.get(i), 0, arrMain, dimension * i, dimension);
            }
        } else {
            for (int i = 0; i < threadQuantity - 1; i++) {
                System.arraycopy(arrParts.get(i), 0, arrMain, dimension * i, dimension);
            }
            System.arraycopy(arrParts.get(threadQuantity -1), 0, arrMain, size - (dimension + residue), dimension + residue);
        }

        long finish = System.currentTimeMillis();

        System.out.println("Метод 2: " + (finish-start));
     }

    private static float[] initArray(){
        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    private static void countArrValue(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
