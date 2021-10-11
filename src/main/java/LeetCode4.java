import java.util.Arrays;

/** 给定两个大小为 m 和 n 的有序数组nums1 和nums2。
 *  请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 *  你可以假设nums1和nums2不会同时为空。
 *  示例 1:
 *  nums1 = [1, 3]
 *  nums2 = [2]
 *  则中位数是 2.0
 *  示例 2:
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *  则中位数是 (2 + 3)/2 = 2.5
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @Author 李光华
 * @Date 2019/9/21 16:42
 **/
public class LeetCode4 {

    /**
     * @param nums1
     * @param nums2
     * @return
     * @Description: 这个算法并不满足题意，时间复杂度不是(log(m + n))
     * @author 李光华
     * @date 2019/9/21  17:15
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length + nums2.length == 0) {
            throw new IllegalArgumentException("nums1,nums2不能同时为空");
        }
        int[] c = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, c, 0, nums1.length);
        System.arraycopy(nums2, 0, c, nums1.length, nums2.length);
        Arrays.sort(c);
        if (c.length % 2 == 0) {
            return (c[c.length / 2 - 1] + c[c.length / 2]) / 2.0;
        } else {
            return c[(c.length - 1) / 2];
        }
    }

    /**
     * @Description: 这里膜拜下大佬写的O(log（min（m，n））算法，利用二分查找将复杂度降到log级别
     * @param A
     * @param B
     * @return
     * @author 李光华
     * @date 2019/9/21  17:20
     */
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays1(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {

    }
}
