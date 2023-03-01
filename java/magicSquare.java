package java;

public class magicSquare {

    private int size;
    private int magicNumber;
    private int[][] result;

    public magicSquare(int size) {
        this.size = size;
        this.magicNumber = (int) (((size)*(Math.pow(size, 2)+1))/2);
        this.result = new int[size][size];
        fillSquareOdd(size, result);
        /*Working in a the other options = Odd 2, multiples of 4 and multiples of 4 + 2 */
    }

/* ---------------------------------------- Methods ---------------------------------------------- */
    /* Case 1 being n odd with the Siamese method. */
    public void fillSquareOdd(int s, int[][]square){

            /* 
             * We have to initializate the rows and the columns, being the first one
             * in the last position, and the column in the middle. 
             * After doing that, the square is gonna have the number one in that specific coordinates
             * as an start.
             */
            int r = s-1;
            int c = s/2;
            square[r][c] = 1;
            
            /*
             * There's two options:
             * 1. If this place is empty, we go the row under the actual. After doing that we go to the column
             * next to the current one.
             * 2. If this place is NOT empty, we break the diagonal and go to the one thats up the current one without modifications
             * in the column.
             */
            for (int i = 2; i <= s*s; i++) {
                /*
                 * To know if is empty or not, we have to verify if the spot has a zero, because
                 * automatically is gonna be full of zeros, so that's gonna be our parameter.
                 */
                if (square[(r+1)%s][(c+1)%s] == 0) {
                    r = (r+1)%s;
                    c = (c+1)%s;
                } else {
                    r = (r-1+s)%s;
                }

                /*
                 * When we have the place correctly, is time to put the number in the square.
                 */

                square[r][c] = i;
            }        
    }

    public void fillSquareMultipliesOfFour(int s, int[][] square) {
        /* Fill the square with diagonals*/
        int num = 1, j=0, i=0;
        for(i = 0; i < s; i++){
            for(j = 0; j < s; j++){
                square[i][j] = num;
                num++; 
            } 
        }



    }

    @Override
    public String toString() {
        String auxiliarString = "";
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result.length; j++){
                if(j==0){
                    auxiliarString += "\n" + result[i][j];
                }
                else{
                    auxiliarString += " " + result[i][j];
                }
            }
        }
        return auxiliarString;
    }

/* --------------------------------- Setters and Getters ------------------------------------- */    
    public int getSize() {
        return size;
    }

    /* 
     * When you are setting the size, at the same time you are setting a new 
     * magic number, that two numbers has to be relationated.  
    */

    public void setSize(int size) {
        this.size = size;
        this.magicNumber = (int) (((size)*(Math.pow(size, 2)+1))/2);
    }

    /* 
     * This has to be stricly relationated with the size, you can't change the magic number directly, 
     * the size is determinating the magic number.
     */
    public void setMagicNumber(int magicNumber) {
        throw new RuntimeException("To change the magic number, change the size of the magic square");
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public int[][] getResult() {
        return result;
    }


    public void setResult(int[][] result) {
        this.result = result;
    }
/* ---------------------------------------------------------------------------------- */    

    public static void main(String[] args) {
        magicSquare Cuadrado = new magicSquare(6);
        System.out.println(Cuadrado.toString());
    }

}