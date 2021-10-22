package algorithms;

/**
 * 快速排序
 * 原理： 1。 找出基准数partition
 *       2。 左边是小于等于partition，右边是大于等于parttition的数
 *       3。 然后将基准数放到正确的位置
 *       4。 最后分别对partition左右两边的数进行递归调用
 */
public class QuickSort {

    public static void quickSort(int[] array){
        if (array == null || array.length==0) return;
        sort(array,0,array.length-1);
    }

    public static void sort(int[] array,int left,int right){
        if (left >= right) return;
        int base = array[left];
        int i = left,j = right;
        while (i != j ){
            while (base <= array[j] && i < j){
                j--;
            }
            while (base >= array[i] && i < j){
                i++;
            }
            if ( i < j ){
                //comp
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[i];
        array[i] = base;

        sort(array,left,i-1);
        sort(array,i+1,right);
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,31,1,13,34,123,5,1,7,123,58,3,31};
        quickSort(array);
        System.out.println(array);
    }
}
