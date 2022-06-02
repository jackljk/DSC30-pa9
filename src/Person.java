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
}
