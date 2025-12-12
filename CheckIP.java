public class CheckIP {

    
    public static boolean isValidIPAddress(String ip) {
        if (ip == null) {
            return false;
        }

        
        String ipv4Pattern = 
            "^(?:(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?|0)\\.){3}" +
            "(?:25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?|0)$";

        return ip.matches(ipv4Pattern);
    }

    public static void main(String[] args) {
        
        String[] testIPs = {
            "192.168.1.1",
            "255.255.255.255",
            "0.0.0.0",
            "256.1.1.1",
            "192.168.01.1", // invalid: leading zero
            "192.168.1",
            "192.168.1.1.1",
            "abc.def.ghi.jkl",
            null
        };

        for (String ip : testIPs) {
            try {
                boolean valid = isValidIPAddress(ip);
                System.out.println(ip + " - " + (valid ? "VALID" : "INVALID"));
            } catch (Exception e) {
                System.out.println(ip + " - ERROR: " + e.getMessage());
            }
        }
    }
}
