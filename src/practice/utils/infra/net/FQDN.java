package practice.utils.infra.net;

import practice.utils.logger.DebugLogger;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class FQDN {
    public static String getIpAddressByHostName(String host){
        try {
            return Inet4Address.getByName(host).getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
