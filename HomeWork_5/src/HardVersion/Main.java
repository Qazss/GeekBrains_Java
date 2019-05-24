package HardVersion;

public class Main {
    static final int size = 1000000;
    static final int half = size / 2;

    public static void main(String[] args) {
        countArray1();
        countArray2();
    }

    private static void countArray1(){
        float[] arr = initArray();

        long start = System.currentTimeMillis();
        countArrValue(arr);
        long finish = System.currentTimeMillis();

        System.out.println("Метод 1: " + (finish-start));
    }

    private static void countArray2(){
        float[] arrMain = initArray();
        float[] arrHalf1 = new float[half];
        float[] arrHalf2 = new float[half];

        long start = System.currentTimeMillis();
        System.arraycopy(arrMain, 0, arrHalf1, 0, half);
        System.arraycopy(arrMain, half, arrHalf2, 0, half);

        Runnable countTask1 = new Runnable() {
            @Override
            public void run() {
                countArrValue(arrHalf1);
            }
        };

        Runnable countTask2 = new Runnable() {
            @Override
            public void run() {
                countArrValue(arrHalf2);
            }
        };

        Thread thread1 = new Thread(countTask1);
        Thread thread2 = new Thread(countTask2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrHalf1, 0, arrMain, 0, half);
        System.arraycopy(arrHalf2, 0, arrMain, half, half);
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
}

