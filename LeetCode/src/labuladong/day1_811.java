package labuladong;

import org.junit.Test;

import java.util.List;

/*
输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
    而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。
输入：cpdomains = ["9001 discuss.leetcode.com"]
输出：["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
解释：例子中仅包含一个网站域名："discuss.leetcode.com"。 按照前文描述，子域名 "leetcode.com" 和 "com" 都会被访问，
    所以它们都被访问了 9001 次。
 */

public class day1_811 {
    public static void main(String[] args) {
        String str = "test_https://www.baidu.com/";
        //截取_之后字符串
        String str1 = str.substring(str.indexOf("_"));
//        String str2 = str.substring(str1.length()+1, str.length());
        System.out.println(str1);

    }

    @Test
    public void test01(){
        Solution solution = new Solution();
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        solution.subdomainVisits(s);
    }

    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            int length = cpdomains.length;
            int a[] = new int[length];
            String str[][] = new String[length][];
            String temp[] = new String[length];
            for (int i = 0; i <length ; i++) {
                a[i] = Integer.parseInt(cpdomains[i].substring(0, cpdomains[i].indexOf(" ")));
                str[i]=(cpdomains[i].substring(cpdomains[i].indexOf(" "))).split("\\.",-1);
            }
            for (int i = 0; i <str[i].length -1; i++) {
                int len = str[i].length;
                str[i][len-2-i] = str[i][len-2-i] +"." + str[i][len-1-i];
            }
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < str[i].length; j++) {
                    System.out.print(str[i][j]+"  ");
                }
                System.out.println();
            }
            return null;
        }
    }
}
