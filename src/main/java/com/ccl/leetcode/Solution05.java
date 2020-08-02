package com.ccl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther ccl
 * @create 2020/7/26 21:57
 */
public class Solution05 {
    public static void main(String[] args) {
        String result = longestPalindrome("acttca");
        System.out.println(result);
       // System.out.println("abcdefghijk".substring(2,3));
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s.length() ==0) return "";
        if(s.length()<3){
            if(s.length() >1 && s.charAt(0) ==s.charAt(1)){
                return s.substring(0,2);
            }else{
                return s.substring(0,1);
            }
        }
        int max = 0;
        String result = "";
        for(int i=1;i<s.length();i++){
            String ss1 = isLevelOne(s,i,i-1,i+1);
            String ss2 = isLevelTwo(s,i-1,i,i);
            String ss = (ss1.length()>ss2.length()) ? ss1:ss2;
            if(ss.length() > max){
                max = ss.length();
                result = ss;
            }
        }

        return result;
    }

    public static String isLevelOne(String s, int current, int left, int right){
        if(left < 0 || right >= s.length()){
            return "";
        }
        while(true){
            //假设回文字符串长度为单数
            if(s.charAt(left) == s.charAt(right)){
                if(left-1 >= 0 && right+1 < s.length()){
                    left = left -1;
                    right = right + 1;
                }else{
                    return s.substring(left,right+1);
                }
            }else{
                    return s.substring(left+1,right);
            }
        }
    }

    public static String isLevelTwo(String s, int current, int left, int right){
        if(current < 0 || right >= s.length()){
            return "";
        }
        while(true){
            //假设回文字符串长度为双数
            if(s.charAt(current) == s.charAt(right)){
                if(current-1 >= 0 && right+1 < s.length()){
                    right = right +1;
                    current = current-1;
                }else{
                    return s.substring(current,right+1);
                }

            }else{
                if(right-current == 1) return s.substring(current,right);
                return s.substring(current+1,right);
            }
        }
    }
}
