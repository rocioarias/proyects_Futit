package java;

public class magicSquare {

    private int size;
    private int magicNumber;
    private int[][] result;

    public magicSquare(int size) {
        this.size = size;
        this.magicNumber = (int) (((size)*(Math.pow(size, 2)+1))/2);
        this.result = new int[size][size];
        if(size % 2 != 0){
            fillSquareOdd(size, result);
        }
        else if(size % 4 == 0){
            fillSquareMultipliesOfFour(size, result);
        }
        /*Last in work: n/4 + 2 */
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
            

            for (int i = 2; i <= s*s; i++) {
                /*
                 * To know if is empty or not, we have to verify if the spot has a zero, because
                 * by default is gonna be full of zeros, that's gonna be our parameter.
                 * There's two options:
                 * 1. If the current place is empty, we go the row under the actual. After doing that we go to the column 
                 * next to the current one.
                 * 2. If this place is NOT empty, we break the diagonal and go to the one thats up the current one without modifications
                 * in the column.
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
        /*
         * In this case, the most simple thing to do is the method of subArrays,
         * which consists of have four subMatrix, turn that subMatrix 180 degrees and 
         * switch them.
         * The first is gonna be the horizontal, that one is gonna have (s/4)x(s/2) dimention and
         * (s/2)x(s/4) the vertical one. 
         */

        int staticM = s/4;
        int index = 1;
        int lim = s-1-staticM;

        /*
         * Here we gonna insert all the numbers without changes.
         */

         for (int r = 0; r < s; r++) {
            for (int c = 0; c < s; c++) {
                if((c<staticM && (r<staticM || r > lim)) || (c>lim && (r<staticM || r > lim))){
                    square[r][c]=index;
                }
                else if((c>=staticM && r>=staticM && c<=lim && r<=lim)){
                    square[r][c]=index;
                }
                index++;
            }             
        }

        /*
         * In this part is gonna be complete the magic square, with all the last numbers, 
         * starting from the last row and the last column. 
         * Doing this inverse fill, we are gonna "rotating" the previous subMatrix's.
         */
        index = 1;
        for (int r = s-1; r >= 0; r--) {
            for (int c = s-1; c >= 0; c--) {
                if(square[r][c]==0)
                   square[r][c]=index;
                index++;               
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
        /* Test */
    public static void main(String[] args) {
        magicSquare Cuadrado = new magicSquare(8);
        System.out.println(Cuadrado.toString());
    }

}