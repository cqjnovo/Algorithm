package niuke.imitate;

/**
 * @description:验证IP地址
 * @author: lzy
 * @time: 2024/8/13 11:04
 */
public class BM85 {
    /**
     * 检查所给IP地址是否满足IPv4或者IPv6的规则
     * @param IP
     * @return
     */
    public String solve (String IP) {
        // write code here
        String[] ips = null;
        if (IP.contains(".")) {
            ips = IP.split("\\.",4);
        } else {
            ips = IP.split(":",8);
        }
        if (ips.length == 4) {
            if (checkIPv4(ips)) {
                return "IPv4";
            }
        } else if (ips.length == 8) {
            if (checkIPv6(ips)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    /**
     * 检查IPv4地址是否合法
     * @param ips
     * @return
     */
    public boolean checkIPv4(String[] ips) {
        for (String part: ips) {
            //判断是否包含前缀0 或 字母
            if (part.length() == 0) {
                return false;
            }
            int firstIdx = -1;
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                if (firstIdx == -1 && part.charAt(i) == '0') {
                    firstIdx = i;
                }
            }
            if (firstIdx == 0 && part.length() != 1) {
                return false;
            }
            int x = Integer.parseInt(part);
            if (x < 0 || x > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIPv6(String[] ips) {
        for (String part : ips) {
            if (part.length() > 4 || part.length() == 0) {
                return false;
            }
            for (int i = 0; i < part.length(); i++) {
                char c = part.charAt(i);
                if (!Character.isDigit(c)) {
                    if ((c >= 'a' && c <='f') || (c >= 'A' && c <= 'F')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
