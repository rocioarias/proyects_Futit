package java;

import java.util.Arrays;

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
        // If the array has only one or zero elements, doesn't need to be organizate. 
        if(toSort.length > 1){
            quickSort(0, toSort.length-1);
        } 
    }

    /*
     * To make a quick organization of the numbers, i decide to use QuickSort, that's because
     * has a lot of efficense with arrays, the worst case is O(n^2) but is a very weird situation.
     */
    private void quickSort(int lowIndex, int highIndex) {
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

    /*
     * replaceZeros is the one who is taking more time, that make the algorithm has an average of time O(n). 
     */

    private void replaceZeros(){
        toSort = Arrays.stream(toSort).map(i -> i == 0 ? -22 : i).toArray(); 
    }

    @Override
    public String toString() {
        String array = "";
        replaceZeros();
        for(int i = 0; i < toSort.length; i++){
            array += toSort[i] + " ";
        }
        return array;
    }
    
}
