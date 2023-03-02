package java;

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
        replaceZeros(); 
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
     * Now we have an array with all the zeros in the right, and plus that, all the numbers in order.
     * To mantein a good amount of time in the algorithm, the binary search is a good option
     * to find the first zero in the array. 
     */

     private static int binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
    
        while (left <= right) {
            int middle = (left + right) / 2;
    
            if ((arr[middle] == 0) && (arr[middle - 1] != 0)) {
                return middle;
            } else if (arr[middle] > 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
    /*
     * To replace the zeros in the array we have to check if the length of the array is bigger then one.
     * If the arrays only has one element we replace, if is necesary, the zero inside for the -22.
     * As a second scenario, we gonna use the binary search and do the replacement.
     */
    private void replaceZeros(){
        if(toSort.length == 1){
            if (toSort[0] == 0){toSort[0] = -22;}
        }
        else{
            int firstZero = binarySearch(toSort);
            if (firstZero != -1){
                    int zeros = 0;
                    for(int i = firstZero; i < toSort.length; i++){
                        toSort[i] = -22;
                        zeros++;
                    }
                    setAmountOfZeros(zeros);
                }
            }
    }

    @Override
    public String toString() {
        String array = "";
        for(int i = 0; i < toSort.length; i++){
            array += toSort[i] + " ";
        }
        return array;
    }

    /*
     *  ------------------------- TIMES OF THE ALGORITHM -----------------------------------------
     *    In average cases, the big O for quicksort is n*log(n) as the same for the binary serch wich is log(n), so the 
     *    time is determinated by replaceZeros().
     *    The ecuation is: 
     *    n 
     *    ∑ c = ((n - k) + 1) * c  || n = length of the array, k = index of the first zero in the array, c = the time of the replaces
     *  i = k  
     */
    
}
     