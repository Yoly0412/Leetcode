public class Solution1 {
    public String intToRoman(int num) {
        String result = "";
        int temp = num;
        int[] factors = {1000, 100, 10, 1};
        String[][] symbols = {
            { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
            { "", "M", "MM", "MMM"},
        };
        for (int i = 0; i <= 3; ++i) {
            temp = num / factors[i];
            result += symbols[3 - i][temp];
            num %= factors[i];
        }
        return result;
    }
}