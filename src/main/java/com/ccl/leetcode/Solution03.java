package com.ccl.leetcode;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther ccl
 * @create 2020/7/26 21:57
 */
public class Solution03 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
        /*Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
        //hashMap.put(" ".charAt(0),1);
        System.out.println(hashMap.remove("h"));*/
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        if(s.length()==0){
            return 0;
        }
        int size = 1;
        int left = 0;
        Map<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(hashMap.get(s.charAt(i))==null){
                hashMap.put(s.charAt(i),i);
                size = Math.max(hashMap.size(),size);
            }else{
                int len = hashMap.get(s.charAt(i));
                for(int j=len;j>=left;j--){
                    hashMap.remove(s.charAt(j));
                }
                left = len+1;
                hashMap.put(s.charAt(i),i);
                size = Math.max(hashMap.size(),size);
            }
        }
        return size;
    }

    public static boolean isExist(String s){
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(hashMap.get(s.charAt(i)) != null){
                return false;
            }
        }
        return true;
    }

    public static int isCount(String s){
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(hashMap.get(s.charAt(i)) == null){
                hashMap.put(s.charAt(i),1);
                count++;
            }
        }
        return count;
    }
}
