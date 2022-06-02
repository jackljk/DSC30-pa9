/*
 * NAME: Jack Kai Lim
 * PID:  A16919063
 */
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.ArrayList;

/**
 * Sorts class.
 * @param <T> Generic type
 * @author Jack Kai Lim
 * @since  04/28/2022
 */
public class Sorts<T extends Comparable<? super T>> {

    private static final int MIDDLE_IDX = 2;

    /**
     * This method performs insertion sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void InsertionSort(ArrayList<T> list, int start, int end) {
        /* Implementation of insertion sort */
        int j;
        T tempT; //Temp store of the element to perform swap
        for (int i = start;i<(end + 1);i++){
           j = i;
           while ((j > start) && (list.get(j - 1).compareTo(list.get(j))) > 0){
               tempT = list.get(j);
               list.set(j, list.get(j - 1));
               list.set(j - 1, tempT);
               j--;
           }
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<T> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / MIDDLE_IDX;
            MergeSort(list, start, mid);
            MergeSort(list , mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param m the middle index we want to merge
     * @param r right-most index we want to merge
     */
    private void merge(ArrayList<T> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs quick sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void QuickSort(ArrayList<T> list, int start, int end) {
        /* Implements Quicksort using a recursive method */
        if (start < end){ //Base Case
            int p = partition(list, start, end); // Partitions and gets the partition index
            /* Recursively calls the sorts to continue to sort */
            QuickSort(list, start, p - 1);
            QuickSort(list, p, end);
        }
    }

    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param h right-most index we want to merge
     * @return The point where the partition ends
     */
    private int partition(ArrayList<T> arr, int l, int h) {
        // Partition and puts values smaller than pivot on the left and values larger than the
        // pivot to the right
        int midpoint = l + (h - l)/MIDDLE_IDX;
        T pivot = arr.get(midpoint);
        // Keeps looping until the low pointer passes the high
        while (l <= h){
            while (arr.get(l).compareTo(pivot) < 0){
                //Keeps moving the low point 1 to the right until it reaches a value larger than
                // the pivot
                l++;
            }
            while (arr.get(h).compareTo(pivot) > 0){
                //Keeps moving the low point 1 to the right until it reaches a value smaller than
                // the pivot
                h--;
            }
            if (l<=h){
                //Swaps the 2 values when the pointers stop moving and the pointers haven't
                // passed each other
                T temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);
                // Moves the pointers after the swap
                l++;
                h--;
            }
        }
        return l;
    }

    /**
     * This method performs a modified QuickSort that switches to insertion sort
     * after a certain cutoff
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     * @param cutoff the minimum length of an subsection of the arraylist
     *               such that we switch to Insertion Sort
     */
    public void Modified_QuickSort(ArrayList<T> list, int start, int end, int cutoff) {
        // Reuses Partition from Quicksort, performs recursive element the same as quick sort but
        // has an additional Base Case
        if (end - start <= cutoff){
            InsertionSort(list, start, end);
        } else {
            if (start < end){ //Base Case
                int p = partition(list, start, end); // Partitions and gets the partition index
                /* Recursively calls the sorts to continue to sort */
                Modified_QuickSort(list, start, p - 1, cutoff);
                Modified_QuickSort(list, p, end, cutoff);
            }
        }
    }
    /**
     * This method performs cocktail sort on the input list
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void cocktailSort(ArrayList<T> list, int start, int end){
        // Implements Cocktail sort
        int p = start + 1; // Int to keep track when traversing forward and backward
        while (true){ //Endless loop until a break happens when 0 swaps occur
            int swapF = 0;//Keeps track of number of swaps going forward
            int swapB = 0;//Keeps track of number of swaps going backwards
            while (p != end){
                // Traversing forwards
                if (list.get(p).compareTo(list.get(p - 1)) < 0){
                    // Swaps the 2 adjacent elements if the element on the right is less than the
                    // element on the left
                    T temp = list.get(p);
                    list.set(p, list.get(p - 1));
                    list.set(p - 1, temp);
                    swapF++;
                }
                p++;
            }
            if (swapF == 0){ //Breaks if no swaps occur going forward
                break;
            }
            while (p - 1 != start){
                if (list.get(p).compareTo(list.get(p - 1)) < 0){
                    // Swaps the 2 adjacent elements if the element on the right is less than the
                    // element on the left
                    T temp = list.get(p);
                    list.set(p, list.get(p - 1));
                    list.set(p - 1, temp);
                    swapB++;
                }
                p--;
            }
            if (swapB == 0){//Breaks if no swaps occur going backwards
                break;
            }
        }
    }
}
