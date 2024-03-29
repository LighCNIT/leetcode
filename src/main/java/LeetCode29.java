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
		if (dividend == 0) {
			return 0;
		}
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean negative;
		negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
		long t = Math.abs((long) dividend);
		long d= Math.abs((long) divisor);
		int result = 0;
		for (int i=31; i>=0;i--) {
			if ((t>>i)>=d) {//找出足够大的数2^n*divisor
				result+=1<<i;//将结果加上2^n
				t-=d<<i;//将被除数减去2^n*divisor
			}
		}
		return negative ? -result : result;//符号相异取反
	}

	public static void main(String[] args) {
		System.out.println(divide(10,3));
	}
}
