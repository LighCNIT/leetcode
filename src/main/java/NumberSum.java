import com.google.common.primitives.Ints;

import java.util.*;

/**
 * @Auther: Ligh
 * @Date: 2018/9/22 16:16
 * @Description:给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *      你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 */
public class NumberSum {

    /** * * 功能描述: 
     * 时间复杂度 O（n²）
     * @param: 
     * @return: 
     * @auther: Ligh
     * @date: 2018/9/22 16:24
    */
    public static int[] twoSum(int[] nums,int target){
        for (int i = 0 ; i < nums.length; i++){
            for (int j = i+1 ; j < nums.length ; j ++){
                if (nums[j] + nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /** * * 功能描述:
     *  时间复杂度 O（n）
     * @param:
     * @return:
     * @auther: Ligh
     * @date: 2018/9/22 18:27
    */
    public static int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> m = new HashMap();
        for (int i = 0 ; i < nums.length; i++){
            m.put(nums[i],i);
        }
        for (int j = 0 ; j < nums.length ; j++){
            int element = target - nums[j];
            if (m.containsKey(element) && m.get(element) != j){
                return new int[]{j,m.get(element)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /** * * 功能描述:
     *  时间复杂度 O(n)上一个方法的改良版
     * @param:
     * @return:
     * @auther: Ligh
     * @date: 2018/9/22 18:59
    */
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> m = new HashMap();
        for (int i = 0 ; i < nums.length; i++){
            int element = target - nums[i];
            if (m.containsKey(element)){
                return new int[]{m.get(element),i};
            }
            m.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] nums1 = twoSum(nums,22);
        int[] nums2 = twoSum1(nums,9);
        int[] nums3 = twoSum2(nums,9);

        Ints.asList(nums1).forEach(i -> System.out.print(i+","));
        System.out.println();
        Ints.asList(nums2).forEach(e -> System.out.print(e+","));
        System.out.println();
        Ints.asList(nums3).forEach(e -> System.out.print(e+","));

    }
}
