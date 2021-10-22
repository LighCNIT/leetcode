import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LeetCode15
 * @Description 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 李光华
 * @Date 2019/11/30 17:17
 **/
public class LeetCode15 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> targetList = new ArrayList<>();
		if (nums==null || nums.length<=2) return targetList;
		Arrays.sort(nums); // 排序
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int target = -nums[i];
			int left = i+1,right=nums.length-1;
			while (left < right){
				if (nums[left] + nums[right] == target){
					targetList.add( new ArrayList<>(Arrays.asList(nums[left],nums[right],-target)));
					left++;
					right--;
					// 因为不能重复所以出现相同的数字要进行排除
					while (left < right && nums[left] == nums[left-1]) left++;
					while (left < right && nums[right] == nums[right+1]) right--;
				}else if (nums[left] + nums[right] < target){
					left++;
				}else {
					right--;
				}
			}
		}
		return targetList;
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode15().threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
}
