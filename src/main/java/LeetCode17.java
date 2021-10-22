import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合（看手机九宫格就知道）
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        List<String> target = new ArrayList<>();
        Map<Character,String> all = new HashMap<Character, String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };
        if (digits == null || digits.length()==0){
            return target;
        }
        back(target,all,digits,0,new StringBuffer());
        return target;
    }

    /**
     * 回溯处理字符串
     * @param target
     * @param map
     * @param digits
     * @param index
     * @param stringBuffer
     */
    public void back(List<String> target,Map<Character,String> map,String digits,int index,StringBuffer stringBuffer){
        if (index == digits.length()){
            target.add(stringBuffer.toString());
        }else {
            char c = digits.charAt(index);
            String s = map.get(c);
            for (int i=0;i<s.length();i++){
                stringBuffer.append(s.charAt(i));
                back(target,map,digits,index+1,stringBuffer);
                stringBuffer.deleteCharAt(index); // 这里要删掉之前拼接的字符串，不然长度就错了
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode17().letterCombinations("23"));
    }
}
