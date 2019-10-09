import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ClassName LeetCode50
 * @Description
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 李光华
 * @Date 2019/10/9 14:53
 **/
public class LeetCode50 {
    /**
     * @Description: 使用快速幂算法
     * 时间复杂度 O(log n)
     * @param x 
     * @param n
     * @return 
     * @author 李光华
     * @date 2019/10/9  14:58
     */
    public static double myPow(double x, int n) {
        double temp = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                temp *= x;
            }
            x *= x;
        }
        return n > 0 ? temp : 1.0 / temp;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,-6));
    }
}
