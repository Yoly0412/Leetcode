public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        restoreIpAddressesHelper(result, list, s, 0);
        return result;
    }
    private void restoreIpAddressesHelper(ArrayList<String> result, 
                                          ArrayList<String> list, 
                                          String s, int pos) {
            if (list.size() == 4) {
                if (pos == s.length()) {
                    String temp = new String();
                    for (int i = 0; i < 3; ++i) {
                        temp += (list.get(i) + ".");
                    }
                    temp += list.get(3);
                    result.add(temp);
                }
                return;
            }

            for (int i = pos; i <= pos + 3 && i < s.length(); ++i) {
                String cur = s.substring(pos, i + 1);
                if (isValidNum(cur)) {
                    list.add(cur);
                    restoreIpAddressesHelper(result, list, s, i + 1);
                    list.remove(list.size() - 1);
                }
            }
    }
    private boolean isValidNum (String s) {
        if (Integer.valueOf(s) < 0 || Integer.valueOf(s) > 255) {
            return false;
        }
        if (s.charAt(0) == '0' && !s.equals("0")) {
            return false;
        }
        return true;
    }
}
