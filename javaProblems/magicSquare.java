package javaProblems;

public class magicSquare {

    private int size;
    private int magicNumber;
    private int[][] result;

    public magicSquare(int size) {
        this.size = size;
        this.magicNumber = (int) (((size)*(Math.pow(size, 2)+1))/2);
        this.result = fullZeros(new int[size][size]);
        if(size == 7){
            fillSquareNotOdd(size, result);
        }
        else{
            this.result = fullNumbers(size,new int[size][size]);
            fillSquareOdd(size, result);
        }
    }

/* ---------------------------------------- Methods ---------------------------------------------- */
    private int[][] fullZeros(int[][] square){
        for(int i = 0; i < square.length; i++){
            for(int j = 0; j < square.length; j++){
                square[i][j] = 0;
            }
        }
        return square;
    }

    private int[][] fullNumbers(int s, int[][] square){
        for(int i = 0; i < s; i++){
            for(int j = 0; j < s; j++){
                square[i][j] = (s*i) + j + 1;    
            }
        }
        return square;
    }

    public void fillSquareNotOdd(int s, int[][]square){
        int r = s-1;
        int c = s/2;
    
        square[r][c] = 1;

        for(int i=2; i <= s*s; i++){
            int verification = square[(r+1)% s][(c+1) % s];
            if (verification == 0) {
                r = (r+1) % s;
                c = (c+1) % s;
            }
            else {
                r = (r-1+s) % s;
            }
            square[r][c] = i;
        }
    }

    public void fillSquareOdd(int s, int[][]square){
        int i,j;
        for ( i = 0; i<s/4; i++){
            for ( j = 0; j<s/4; j++){
                square[i][j] = (s*s + 1) - square[i][j];
            }   
        }
        
        for ( i = 0; i<s/4; i++){
            for ( j = 0; j<s/4; j++){
                square[i][j] = (s*s + 1) - square[i][j];
            }
        }

        for ( i = 0; i< s/4; i++){
            for ( j = 3* (s/4); j<s; j++){
                square[i][j] = (s*s + 1) - square[i][j];
            }
        }
        for ( i = 3* s/4; i<s; i++){
            for ( j = 0; j<s/4; j++){
                square[i][j] = (s*s + 1) - square[i][j];
            }
        }
        for ( i = 3* s/4; i<s; i++){
            for ( j = 3* s/4; j<s; j++){
                square[i][j] = (s*s + 1) - square[i][j];
            }
        }
     
        for ( i = s/4; i<3* s/4; i++){
            for ( j = s/4; j<3* s/4; j++){
                square[i][j] = (s*s + 1) - square[i][j];
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
        magicSquare Cuadrado = new magicSquare(4);
        System.out.println(Cuadrado.toString());
    }

}