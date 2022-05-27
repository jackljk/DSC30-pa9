import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class ContactListTest {
    private ContactList CL;
    private ArrayList<String> pns;
    private ArrayList<String> pns2;

    @Before
    public void setUp() throws Exception {
        pns = new ArrayList<String>();
        for (int i = 0;i<5;i++){
            pns.add(String.valueOf(i+10));
        }

        pns2 = new ArrayList<String>();
        for (int i = 0;i<5;i++){
            pns2.add(String.valueOf(i+100));
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

    @Test
    public void ContactsTests(){
        Person jack1 = new Person("Jack1", pns);
        System.out.println(jack1);
        Person jack2 = new Person("Jack2", pns);
        Person Matt = new Person("Aack", new ArrayList<>(Collections.singletonList("619-509-3136")));
        System.out.println(Matt);
        assertTrue(CL.createContact(jack1));
        assertFalse(CL.createContact(jack1));
        assertTrue(CL.createContact(jack2));
        assertFalse(CL.lookupContact("Matt"));
        assertTrue(CL.lookupContact("Jack1"));
        assertEquals(jack1, CL.getContact("Jack1"));
        assertNull(CL.getContact("Matt"));
        System.out.println(Arrays.toString(CL.fetchAllNames()));
        System.out.println(Arrays.toString(CL.fetchAllPhoneNumbers()));
        CL.createContact(Matt);
        System.out.println(Arrays.toString(CL.fetchAllNames()));
        System.out.println(Arrays.toString(CL.fetchAllPhoneNumbers()));
        assertEquals(3, CL.size());
        assertFalse(CL.deleteContact("Matt"));
        assertTrue(CL.deleteContact("Aack"));
        System.out.println(Arrays.toString(CL.fetchAllNames()));
        System.out.println(Arrays.toString(CL.fetchAllPhoneNumbers()));
        CL.createContact(Matt);
        System.out.println(Arrays.toString(CL.getContactByRange("Aack", "Jack2")));
    }
}