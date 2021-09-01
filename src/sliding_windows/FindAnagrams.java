package sliding_windows;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    //方法一：枚举所有长度为p.length()的子串　
    public List<Integer> findAnagrams1(String s, String p) {
        //定义一个结果列表
        ArrayList<Integer> result = new ArrayList<>();

        //1.统计p中字母出现的频次
        int[]  pCharCounts= new int[26];
        for (int i = 0; i <p.length() ; i++) {
            pCharCounts[p.charAt(i)-'a']++;
        }

        //2.遍历s，以每一个字符作为起始，考察长度为p.length()的子串
        for (int i = 0; i <=s.length()-p.length(); i++) {
            //3.判断当前子串是否为p的字母异位词
            boolean isMatched = true;
            //定义一个数组，统计子串中所有字符频数
            int[]  sCharCounts= new int[26];

            for (int j = i; j <i+p.length(); j++) {
                sCharCounts[s.charAt(j)-'a']++;

                //判断字符频次如果超过了p中的频次，就一定不符合
                if(sCharCounts[s.charAt(j)-'a']>pCharCounts[s.charAt(j)-'a']){
                    isMatched = false;
                    break;
                }
            }
            if(isMatched){
                result.add(i);
            }
        }
        return result;
    }

    //方法二：滑动窗口，分别移动起始和结束位置
    public List<Integer> findAnagrams(String s, String p) {
        //定义一个结果列表
        ArrayList<Integer> result = new ArrayList<>();

        //1.统计p中字母出现的频次
        int[]  pCharCounts= new int[26];
        for (int i = 0; i <p.length() ; i++) {
            pCharCounts[p.charAt(i)-'a']++;
        }

        //定义一个数组，统计子串中所有字符频数
        int[]  subStringCharCounts= new int[26];
        //定义双指针，指向窗口的起始和结束位置
        int start = 0,end = 1;
        //2.移动指针，总是截取字符出现频次全部小于等于p中字符频次的子串
        while (end<=s.length()){
            //当前新增字符
            char newChar = s.charAt(end-1);
            subStringCharCounts[newChar-'a']++;

            //3.判断当前子串是否符合要求
            //如果新增字符导致子串频次超出p中频次，那么移动start，消除新增字符的影响
            while (subStringCharCounts[newChar-'a']>pCharCounts[newChar-'a']&&start<end){
                char removeChar = s.charAt(start);
                subStringCharCounts[removeChar-'a']--;
                start++;
            }

            //如果当前子串的长度等于p的长度，那么就算一个字母异位词
            if(end-start==p.length()){
                result.add(start);
            }

            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s= "abab",p= "ab";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagrams = findAnagrams.findAnagrams(s, p);
        System.out.println(anagrams);

    }
}
