package mine.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetCode
 * @description: 无重复字符的最长子串
 * @author: gyw
 * @create: 2022-06-15 11:25
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="jdhfjhf";
        int i = lengthOfLongestSubstring(s);
        System.out.println("最长字段长度是:"+i);
    }
    public  static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


    public static int lengthOfLongestSubstring3(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        if(s.length()> 5 * 10000){
            return 0;
        }
        int maxLength=s.length();
        while (maxLength>0) {
            for(int i=0;i<s.length()-maxLength+1;i++){
                String source=s.substring(i,i+maxLength);
                char[] chars = source.toCharArray();
                boolean flag=false;
                HashMap<Character, Integer> map = new HashMap<>();
                for(int n=0;n<chars.length;n++){
                    if(null!=map.get(chars[n])){
                        flag=true;
                        break;
                    }
                    else {
                        map.put(chars[n],n);
                    }
                }
                if(!flag){
                    return maxLength;
                }
            }
            maxLength--;
        }

        return 0;
    }
    /**
     * 理解成不重复后面有重复的了
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringR(String s) {
        if(s.length()<2){
            return 0;
        }
        int maxLength=s.length()/2;
        while (maxLength>0){
            for(int i=0;i<s.length()-maxLength+1;i++){
                String source = s.substring(i,i+maxLength);
                char[] chars = source.toCharArray();
                HashMap<Character, Integer> map = new HashMap<>();
                boolean flag=false;
                for(int m=0;m<chars.length;m++){
                    char aChar = chars[m];
                    if(null!=map.get(aChar)){
                        flag=true;
                    }
                    else {
                        map.put(aChar,m);
                    }
                }
                if(flag){
                    continue;
                }
                for (int j = i+maxLength; j +maxLength< s.length()+1; j++) {
                    if(source.equals(s.substring(j,j+maxLength))){
                        return maxLength;
                    }
                }
            }
            maxLength--;
        }
        return 0;
    }
}
