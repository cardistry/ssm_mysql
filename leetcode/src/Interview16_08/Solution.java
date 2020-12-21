package Interview16_08;

class Solution {
    // one[2] = 2 数值的字符串表示
    private static final String[] one = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // ten[2] = 2 * 10 数值的字符串表示
    private static final String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    /**
     * 解法二：分治法 + 哈希表方式（1ms）
     */
    public static String numberToWords(int num) {
        if (num == 0) {
            return one[0];
        }
        StringBuilder sb = new StringBuilder();
        if (num / 1_000_000_000 > 0) {
            // 取十亿位
            sb.append(one[num / 1_000_000_000]);
            sb.append(" Billion");
            num = num % 1_000_000_000;
        }
        if (num / 1_000_000 > 0) {
            // 取百万位（亿、千万、百万）
            getThree(num / 1_000_000, sb);
            sb.append(" Million");
            num = num % 1_000_000;
        }
        if (num / 1000 > 0) {
            // 取千位（十万、万、千）
            getThree(num / 1000, sb);
            sb.append(" Thousand");
            num = num % 1000;
        }
        if (num > 0) {
            // 取个位（百、十、个）
            getThree(num, sb);
        }
        return sb.toString();
    }

    public static void getThree(int num, StringBuilder sb) {
        if (num / 100 > 0) {
            // 取百位
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(one[num / 100]);
            sb.append(" Hundred");
            num = num % 100;
        }
        if (num == 0) {
            return;
        }
        // 取十位
        if (num < 20) {
            // 可直接取值的情况：10，11，12，13...19
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(one[num]);
        } else {
            // [20, 99] 的情况，需要十位 + 个位分别转换字符串
            if (sb.length() > 0) {
                sb.append(" ");
            }
            // 十位转换
            sb.append(ten[num / 10]);
            num = num % 10;
            if (num > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                // 个位转换
                sb.append(one[num]);
            }
        }
    }
}
