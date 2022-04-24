package practice.utils.infra.net;

import org.junit.jupiter.api.Test;
import practice.utils.logger.DebugLogger;

public class FQDNTest {
    @Test
    public void ホストからIPアドレス引き() {
        var debug = new DebugLogger();
        debug.next("ipAddress:");
        String ipAddress = FQDN.getIpAddressByHostName("yahoo.co.jp");
        debug.logging(System.out, DebugLogger.IOResource.CONSOLE);
        System.out.println(ipAddress);
    }

}