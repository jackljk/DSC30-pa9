import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ContactListTest {
    private ContactList CL;
    private ArrayList<String> pns;

    @Before
    public void setUp() throws Exception {
        pns = new ArrayList<String>();
        for (int i = 0;i<5;i++){
            pns.add(i + " " + i+1);
        }
        CL = new ContactList();
    }

    @Test
    public void PersonsTests(){
        Person jack1 = new Person("Jack1", pns);

    }
}