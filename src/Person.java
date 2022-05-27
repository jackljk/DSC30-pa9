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
        this.nelems++;
        return this.tree.add(pn);
    }

    public ArrayList<String> getPhoneNumbers() {
        ArrayList<String> out = new ArrayList<String>();
        Iterator sortedTree = this.tree.iterator();
        for (int i = 0;i<this.nelems;i++){
            out.add((String) sortedTree.next());
        }
        return out;
    }

    public boolean deletePhoneNumber(String pn) {
        if (this.nelems == 1){
            return false;
        }
        this.nelems--;
        return this.tree.remove(pn);
    }
}
