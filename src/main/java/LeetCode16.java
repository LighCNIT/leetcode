import java.util.Arrays;

/**
 * @author dell
 * @version 1.0
 * @description: 最接近的三数之和
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/15 11:09
 */
public class LeetCode16 {
	/**
	 * @title
	 * @description  双指针
	 * @author admin
	 * @updateTime 2021/10/15 11:15
	 * @throws
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0]+nums[1]+nums[2]; // 初始化值
		for (int i=0;i<nums.length;i++){
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i+1,right = nums.length-1;
			while (left < right){
				int three = nums[left]+nums[right]+nums[i];
				if (Math.abs(three-target) < Math.abs(closest-target)){ //
					closest = three;  //  找到更接近的则交换下
				}
				if (three > target){
					right--;
				}else if (three < target){
					left++;
				}else { // 如果相等则直接返回
					return target;
				}
			}
		}
		return closest;
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode16().threeSumClosest(new int[]{-1,2,1,-4},1));
	}
}
