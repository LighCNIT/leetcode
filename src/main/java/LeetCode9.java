/**
 * @ClassName LeetCode9
 * @Description
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 李光华
 * @Date 2019/10/9 10:50
 **/
public class LeetCode9 {

    /**
     * @Description:
     *  解法思路： 反转一半的数字即可
     *  如：1221是回文数这样处理 --》1221%10得到第一位 1；而后 1221/10=122 ;122%10 得到第二位2
     *  此时反转后的数字为1*10+2 = 12；
     *  依次类推当 原始数据小于反转后的数字时代表已反转一半数字
     * @param x
     * @return
     * @author 李光华
     * @date 2019/10/9  11:28
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertNumber = 0;
        while (x > revertNumber) {
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertNumber || x == revertNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }
}
