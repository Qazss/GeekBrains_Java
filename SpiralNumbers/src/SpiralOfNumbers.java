public class SpiralOfNumbers {
    private int dimension;
    private int[][] spiralArr;
    private int actualNum = 1;
    private int spiralNumber;

    public SpiralOfNumbers(int dimension){
        this.dimension = dimension;

        spiralArr = new int[dimension][dimension];
        spiralNumber = dimension / 2;

        for(int i = 0; i < spiralNumber; i++){
            fillUpSide(spiralArr, i);
            fillRightSide(spiralArr, i);
            fillBottomSide(spiralArr, i);
            fillLeftSide(spiralArr, i);
        }

        if(!isEven(dimension)) {
            spiralArr[spiralNumber][spiralNumber] = dimension * dimension;
        }
    }

    private void fillUpSide(int[][] arr, int offset){
        for(int i = offset; i < arr.length - 1 - offset; i++){
            arr[offset][i] = actualNum ++;
        }
    }

    private void fillRightSide(int[][] arr, int offset){
        for(int i = offset; i < arr.length - 1 - offset; i++){
            arr[i][arr.length - 1 - offset] = actualNum ++;
        }
    }

    private void fillBottomSide(int[][] arr, int offset){
        for(int i = arr.length - 1 - offset; i > offset; i--){
            arr[arr.length - 1 - offset][i] = actualNum ++;
        }
    }

    private void fillLeftSide(int[][] arr, int offset){
        for(int i = arr.length - 1 - offset; i > offset; i--){
            arr[i][offset] = actualNum ++;
        }
    }

    private boolean isEven(int num){
        return num % 2 == 0;
    }

    public void printSpiral(){
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++){
                System.out.print(spiralArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
