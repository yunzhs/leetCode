package mine.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetCode
 * @description: 前十道
 * @author: gyw
 * @create: 2022-06-14 14:21
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        System.out.println(Arrays.toString(twoSum(nums, 11)));
    }

    /**
     * 标签：哈希映射
     * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)
     * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 核心要学会降低时间复杂度
     */
    public static int[] twoSumGod(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int x=0;x<nums.length;x++){
            for(int y=x+1;y<nums.length;y++){
                if(nums[x]+nums[y]==target){
                    return new int[] {x,y};
                }
            }
        }
        return null;
    }
    //题目理解错误,写成了找出所有数之和为输入目标,其实是想复杂了
    public static int[] allSum(int[] nums, int target) {
        for(int x=0;x<nums.length;x++){
            ArrayList<Integer> arrList = new ArrayList<>();
            ArrayList<Integer> excludeList = new ArrayList<>();
            arrList.add(x);
            int sum=nums[x];
            int m=x+1;
            for(int y=m;y<nums.length;y++){
                if(excludeList.contains(y)){
                    continue;
                }
                sum=sum+nums[y];
                if(sum>target){
                    if(excludeList.size()==nums.length-x+1){
                        y=nums.length;
                    }
                    else {
                        y=x+1;
                        sum=nums[x];
                        excludeList.add(m++);
                        arrList.clear();
                        arrList.add(x);
                    }
                    continue;
                }
                arrList.add(y);
                if(sum==target){
                    int[] result=new int[arrList.size()];
                    for (int i = 0; i < arrList.size(); i++) {
                        result[i]=arrList.get(i);
                    }
                    return result;
                }
            }
        }
        return null;
    }
}
