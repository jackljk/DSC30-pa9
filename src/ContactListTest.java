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
            pns.add(String.valueOf(i+10));
        }
        CL = new ContactList();
    }

    @Test
    public void PersonsTests(){
        Person jack1 = new Person("Jack1", pns);
        assertEquals("Jack1", jack1.getName());
        System.out.println(jack1.getPhoneNumbers());
        jack1.addPhoneNumber("619-509-3136");
        assertTrue(jack1.addPhoneNumber("20"));
        assertFalse(jack1.addPhoneNumber("20"));
        jack1.addPhoneNumber("9");
        System.out.println(jack1.getPhoneNumbers());
        jack1.deletePhoneNumber("9");
        System.out.println(jack1.getPhoneNumbers());
        assertTrue(jack1.deletePhoneNumber("20"));
        assertFalse(jack1.deletePhoneNumber("20"));
    }
}