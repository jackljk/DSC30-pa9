import java.util.*;   

public class Person {
	
    // Add instance variables here
    TreeSet<String> tree;
    int nelems;
    String name;
	
	public Person(String name, ArrayList<String> pnArray) {
        this.tree = new TreeSet<String>();
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
        return new ArrayList<>(this.tree);
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
