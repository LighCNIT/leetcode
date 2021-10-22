import java.util.HashMap;
import java.util.Map;

/**
 * @author dell
 * @version 1.0
 * @description: 罗马数字转整数
 * @date 2021/10/14 10:32
 */
public class LeetCode13 {

	public int romanToInt(String s) {
		Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};

		int target = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int value = symbolValues.get(s.charAt(i));
			if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
				target -= value;
			} else {
				target += value;
			}
		}
		return target;
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode13().romanToInt("LVIII"));
	}
}
