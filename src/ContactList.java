import java.util.*;

public class ContactList {
	
	// Add instance variables here\
    private TreeMap<String, Person> contacts;
    private int noContacts;

    public ContactList() {
        this.contacts = new TreeMap<String, Person>();
        this.noContacts = 0;
    }

    public boolean createContact(Person person) {
        if (this.contacts.put(person.getName(), person) == null){
            this.noContacts++;
            return true;
        } else {
            return false;
        }
    }

    public boolean lookupContact(String name) {
        return this.contacts.containsKey(name);
    }

    public Person getContact(String name) {
        return this.contacts.get(name);
    }

    public Person[] getContactByRange(String start, String end) {
        if (start.compareTo(end) > 0 || this.contacts.lastEntry().getKey().compareTo(end) > 0){
            throw new IllegalArgumentException();
        }
        Collection<Person> values = this.contacts.subMap(start, end).values();
        return values.toArray(new Person[0]);
    }

    public boolean deleteContact(String name) {
        if (this.contacts.remove(name) == null){
            return false;
        } else {
            this.noContacts--;
            return true;
        }
    }

    public int size() {
        return this.noContacts;
    }

    public String[] fetchAllNames() {
        ArrayList<String> values = new ArrayList<>(this.contacts.keySet());
        return values.toArray(new String[0]);
    }

    public String[] fetchAllPhoneNumbers() {
        TreeSet<String> pns = new TreeSet<>();
        for (Person temp : this.contacts.values()) {
            pns.addAll(temp.getPhoneNumbers());
        }
        return pns.toArray(new String[0]);
    }
}
