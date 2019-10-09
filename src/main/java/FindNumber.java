/**
 * @ClassName FindNumber
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @Author 李光华
 * @Date 2019/10/9 17:46
 **/
public class FindNumber {

    /**
     * @Description: 异或操作 n^0 = n; n^n = 0
     * 时间复杂度 O(1) --- O(n)
     * @param nums
     * @return
     * @author 李光华
     * @date 2019/10/9  18:07
     */
    public static int singleNumber(int[] nums) {
        int target = 0;
        for (int i=0;i<nums.length;i++){
            target ^= nums[i];
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
