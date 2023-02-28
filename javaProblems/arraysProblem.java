package javaProblems;

public class arraysProblem {

    private int amountOfZeros;
    private int[] toSort;

    public void setAmountOfZeros(int amountOfZeros) {
        this.amountOfZeros = amountOfZeros;
    }

    public int getAmountOfZeros() {
        return amountOfZeros;
    }

    public arraysProblem(int[] toSort) {
        this.toSort = toSort;
        if(toSort.length > 1){
            quickSort(0, toSort.length-1);
        } 
    }

    private void replace(){
        int index = toSort.length - getAmountOfZeros();
        if(toSort.length % 2 != 0 || toSort.length > 3){
            index = index - 2;
        }
        else if(toSort.length == 1){
            index = 0;
        }
        else{
            index = index + 1;
        }
        for(int i = index; i < toSort.length; i++){
            toSort[i] = -10101;
        }
    }

    public void quickSort(int lowIndex, int highIndex) {
		int low = lowIndex, high = highIndex;
		int pivot = (toSort[high - 1] + toSort[high]) / 2;
		
        if((pivot == 0) || (toSort[lowIndex] == 0) || (toSort[highIndex] == 0)){
            setAmountOfZeros(getAmountOfZeros()+1);
        }
		
        while (low <= high) {
			while (toSort[low] > pivot) low++;
			while (toSort[high] < pivot) high--;
			if (low <= high) exchange(low++, high--);
		}
		
		if (lowIndex < high) quickSort(lowIndex, high);
		if (low < highIndex) quickSort(low, highIndex);
	}
	
	private void exchange(int fromIndex, int toIndex) {
		int temp = toSort[fromIndex];
		toSort[fromIndex] = toSort[toIndex];
		toSort[toIndex] = temp;
	}

    @Override
    public String toString() {
        String array = "";
        replace();
        for(int i = 0; i < toSort.length; i++){
            array += toSort[i] + " ";
        }
        return array;
    }


    public static void main(String[] args) {
        int[] prueba = {0,1,0};
        arraysProblem arrayPrueba = new arraysProblem(prueba);
        System.out.println(arrayPrueba.toString());
    }
    
}
