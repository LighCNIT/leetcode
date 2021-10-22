/**
 * @author dell
 * @version 1.0
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 *  输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/13 18:18
 */
public class LeetCode11 {
	/**
	 * @title
	 * @description 思路：观察下柱状图就能知道其实我们就是求出 area = Min（height[i],height[j]）*(|j-i|)的最大值来
	 * 可以使用双指针解决这个问题。一个指向数组开头，一个指向数组结尾，然后两个指针向中间靠拢，每次去除Max（area）即可
	 * 时间复杂度O（n） 如果使用暴力算法时间复杂度为O（n²）
	 *
	 * @author admin
	 * @updateTime 2021/10/13 18:20
	 * @throws
	 */
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int temp = 0;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			temp = Math.max(temp, area);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
}
