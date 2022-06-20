package practice.utils.infra.net;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubNetsTest {

    @Test
    public void isCorrectNetwork() {
        SubNets sub = new SubNets("192.168.0.2/31");
        assertFalse(sub.isRange("192.168.0.1"));
        assertTrue(sub.isRange("192.168.0.2"));
        assertTrue(sub.isRange("192.168.0.3"));
        assertFalse(sub.isRange("192.168.0.4"));

        SubNets wide = new SubNets("172.16.254.0/23");
        assertFalse(wide.isRange("172.16.253.255"));
        assertTrue(wide.isRange("172.16.254.0"));
        assertTrue(wide.isRange("172.16.254.255"));
        assertTrue(wide.isRange("172.16.255.255"));
        assertFalse(wide.isRange("172.15.253.255"));
        assertFalse(wide.isRange("172.17.0.0"));

    }
}