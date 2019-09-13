import java.util.Arrays;

public class MergeSortImpl {

    public static void main(String[] args) {
        MergeSortImpl obj = new MergeSortImpl();
        int[] array = {3,2,5,3,7,5,1,8};
        obj.mergeSort(array, 0, array.length-1);;
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int start, int end) {

        if(start > end)
            return;

        if(start == end)
            return;

        int mid = (start + end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid+1, end);

        merge(array, start, mid, end);
    }

    public void merge(int[] array, int start, int mid, int end) {
        int[] result = new int[end-start+1];
        int i=start;
        int j= mid+1;
        int k=0;
        while (i<=mid && j<=end) {
            if(array[i]<=array[j]) {
                result[k++] = array[i++];
            } else {
                result[k++] = array[j++];
            }
        }
        if(i > mid) {
            while (j<=end) {
                result[k++] = array[j++];
            }
        } else if (j > end) {
            while (i<=mid) {
                result[k++] = array[i++];
            }
        }
//        array = result;
        i = start;
       for (int p= 0; p< result.length; p++) {
            array[i++] = result[p];
       }
    }
}
