package FlexibleVersion;

public class ArrayCountThread extends Thread{
    float[] arr;

    public ArrayCountThread(float[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        countArrValue(arr);
    }

    private void countArrValue(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
