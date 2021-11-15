package algorithms;

/**
 * 堆排序
 */
public class HeapSort {

    public static int[] headSort(int[] arr){
        // 循环构建最大堆 从下至上取堆的第一个非叶子节点，然后上浮，循环结束，堆顶元素就是最大元素
        for (int i = arr.length/2-1;i >=0;i--){
            // 调整堆，进行比较交换
            adjustHead(arr,i,arr.length);
        }

        for (int j = arr.length - 1;j > 0;j--){
            // 堆顶元素与堆尾元素进行交换
            swap(arr,0,j);
            // 重新构建 j 个元素的最大堆
            adjustHead(arr,0,j);
        }
        return arr;
    }

    public static void adjustHead(int[] arr,int i,int length){
         // 取出当前元素，因为可能要交换
        int temp = arr[i];
        // 2*i+1 为左子树 i 的左子树
        for (int k = 2*i+1;k < length;k = 2*k+1){
            if (k+1 < length && arr[k] < arr[k+1]){ // 如果有右子数，且右子树大于左子树
                k++;
            }
            if (arr[k] > temp){ // 如果左/右子树大于当前根结点，则进行比较交换
                swap(arr,i,k);
                // 循环对子节点的所在的树进行判断
                i = k;
            }else {
                break;
            }
        }
    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {10,20,5,30,3,7,2,8,40,6,8,9,20};
        headSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
