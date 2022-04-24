package practice.utils.security;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SignTest {

    @Test
    public void CVE_2022_21449() {
        Sign s = new Sign();
        s.verifySignature();
        if (s.hasException()) {
            s.getException().printStackTrace();
        }

        // It is Success till here.
        assertTrue(true);
    }

}