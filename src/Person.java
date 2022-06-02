import java.lang.reflect.Array;
import java.util.*;   

public class Person {
	
    // Add instance variables here
    Sorts<String> s;
    HashSet<String> tree;
    int nelems;
    String name;
	
	public Person(String name, ArrayList<String> pnArray) {
        this.tree = new HashSet<>();
        this.name = name;
        this.nelems = pnArray.size();
        this.tree.addAll(pnArray);
	}
	
    public String getName() {
        return this.name;
    }

    public boolean addPhoneNumber(String pn) {
        if (this.tree.add(pn)){
            this.nelems++;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getPhoneNumbers() {
        ArrayList<String> out = new ArrayList<>(this.tree);
        s.Modified_QuickSort(out, 0, this.nelems, 10);
        return out;
    }

    public boolean deletePhoneNumber(String pn) {
        if (this.tree.remove(pn)){
            if (this.nelems == 1){
                throw new IllegalArgumentException();
            }
            this.nelems--;
            return true;
        } else {
            return false;
        }
    }


    // Function to perform Radix sort
    // on String array
    public static void radixSort(String input[],
                                 int radix,
                                 int width)
    {
        for (int i = 0; i < width; i++) {
            performRadixSort(input, i, radix);
        }
    }
    public static void performRadixSort(String input[],
                                        int position,
                                        int radix)
    {

        // Creating a temporary count array
        int countArray[] = new int[radix];
        int nos = input.length;

        // Populating the count array
        for (String value : input) {
            countArray[getDigit(position,
                    value, radix)]++;
        }

        // Normalizing count array
        for (int i = 1; i < radix; i++) {
            countArray[i]
                    = countArray[i]
                    + countArray[i - 1];
        }

        String tempArray[] = new String[nos];
        // Building the final temporary array
        for (int i = nos - 1; i >= 0; i--) {
            tempArray[--countArray[getDigit(
                    position, input[i], radix)]]
                    = input[i];
        }
        // Copying into the actual array
        for (int i = 0; i < nos; i++) {
            input[i] = tempArray[i];
        }
    }
    // Hashing the input value, radix = 26
    // It takes the character at
    // (length - position) location
    // and convert it to ascii value and
    // return the ascii value
    public static int getDigit(int position,
                               String value,
                               int radix)
    {
        int nos = value.length() - 1;
        char c = value.toLowerCase().charAt(nos - position);
        return (int)c - 97;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String arr[]
                = { "BCDEF", "dbaqc", "abcde", "bbbbb" };
        System.out.println("Input:"
                + Arrays.toString(arr));

        // Radix is the maximum value from
        // the input array
        // For String maximum value is 26
        radixSort(arr, 26, arr[0].length());
        System.out.println("Output:"
                + Arrays.toString(arr));
    }
}
