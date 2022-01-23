package practice.utils.infra.net;


import org.apache.commons.net.util.SubnetUtils;


public class SubNets {

    public final String subnet;
    public SubNets(String subnet) {
        this.subnet = subnet;
    }

    /**
     * isValidRange
     * @param targetAddress
     * @return
     */
    public boolean isRange(String targetAddress) {
        SubnetUtils s = new SubnetUtils(subnet);
        s.setInclusiveHostCount(true);
        boolean ret = s.getInfo().isInRange(targetAddress);
        return ret;
    }
}
