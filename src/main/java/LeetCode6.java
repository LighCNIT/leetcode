/**
 * @author dell
 * @version 1.0
 * @description:  Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/12 12:22
 */
public class LeetCode6 {
	/**
	 * @title
	 * @description 思路：先找出规律，显然
	 * 例如对一个4行的
	 *
	 * 0     6      12        18
	 * 1   5 7   11 13    17
	 * 2 4   8 10   14 16
	 * 3     9      15
	 * 对于n行的, s中的第i个字符：
	 * 对余数进行判断
	 *
	 * i%(2n-2) == 0 ----> row0
	 * i%(2n-2) == 1 & 2n-2-1 ----> row1
	 * i%(2n-2) == 2 & 2n-2-2 ----> row2
	 * ...
	 * i%(2n-2) == n-1 ----> row(n-1)
	 * 对 k = i%(2n-2)进行判断
	 * k<=n-1时候，s[i]就属于第k行
	 * k>n-1时候，s[i]就属于2n-2-k行
	 * 最后将rows拼接起来就行了
	 * @author admin
	 * @updateTime 2021/10/12 12:23
	 * @throws
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		StringBuilder target = new StringBuilder();
		int n = s.length();
		int step = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += step) {
				target.append(s.charAt(j + i));
				if (i != 0 && i != numRows - 1 && j + step - i < n) {
					target.append(s.charAt(j + step - i));
				}
			}
		}
		return target.toString();
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode6().convert("PAYPALISHIRING",3));
	}
}
