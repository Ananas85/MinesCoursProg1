package session.demo1test;

import org.junit.Test;
import session.demo1.v1.NatParInt;

import static org.junit.Assert.assertEquals;

public class NatParIntTest {

    @Test
    public void testSomme() {
        NatParInt x = new NatParInt(5);
        assertEquals(x.somme(x), 10);
    }

}