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
    private void restoreIpAddressesHelper(ArrayList<String> result, ArrayList<String> list, String s, int pos) {
            if (list.size() == 4) {
                if (pos == s.length()) {
                    StringBuilder temp = new StringBuilder();
                    for (String ss: list) {
                        temp.append(ss + ".");
                    }
                    temp.deleteCharAt(temp.length() - 1);
                    result.add(temp.toString());
                }
                return;
            }

            for (int i = pos; i < pos + 3 && i < s.length(); i++) {
                if (s.charAt(pos) == '0' && i > pos) {
                    break;
                }
                String pre = s.substring(pos, i + 1);
                int num = Integer.parseInt(pre);
                if (num > 255) {
                    continue;
                }
            
                list.add(pre);
                restoreIpAddressesHelper(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
    }
}