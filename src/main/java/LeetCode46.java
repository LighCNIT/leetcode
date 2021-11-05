import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> target = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0 ; i < nums.length;i++){
            numList.add(nums[i]);
        }
        int length = nums.length;
        backtrack(length,target,numList,0);
        return target;
    }

    /**
     * 回溯算法
     * @param n
     * @param target
     * @param numList
     * @param begin
     */
    public void backtrack(int n,List<List<Integer>> target,List<Integer> numList,int begin){
        if (n == begin){
            target.add(new ArrayList<>(numList));
        }
        for (int i = 0 ; i < n ;i++){
            // 交换元素
            Collections.swap(numList,begin,i);
            // 递归下一个
            backtrack(n,target,numList,begin+1);
            Collections.swap(numList,begin,i);


        }
    }
}
