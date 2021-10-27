/**
 * @author dell
 * @version 1.0
 * @description: 两数相除
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数dividend除以除数divisor得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/26 18:19
 */
public class LeetCode29 {

	public static int divide(int dividend, int divisor) {
		return dividend ^ divisor;
	}

	public static void main(String[] args) {
		System.out.println(divide(10,3));
	}
}
