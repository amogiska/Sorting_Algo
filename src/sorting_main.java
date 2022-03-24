import java.util.Arrays;

public class sorting_main {

    private static void selection_sort(int[] arr){

        for(int i = 0; i < arr.length-1; i++){
            int min_index = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int tmp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = tmp;

        }
    }

    private static void insertion_sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            int j = i -1 ;

            //moves elements from arr[0..i-1] that are greater
            // than arr[i] to one position ahead.
            while(j >= 0 && arr[j] > val){
                arr[j + 1] = arr[j];
                j = j-1;
            }
            arr[j+1] = val;
        }
    }

    public static void merge_sort(int[] a, int n){
        if(n < 2){
            return;
        }

        int mid = n/2;
        int Left[] = new int[mid];
        int Right[] = new int[n-mid];

        for(int i = 0; i < mid; i++){
            Left[i] = a[i];
        }
        for(int i = mid; i < n; i++){
            Right[i - mid] = a[i];
        }

        merge_sort(Left, mid);
        merge_sort(Right, n - mid);

        merge(a, Left, Right, mid, n-mid);
    }

    private static void merge(int[] a, int[] left, int[] right, int num_left, int num_right) {
        int i = 0, j = 0, k = 0;
        while(i < num_left && j < num_right){
            if(left[i] <= right[j]){
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < num_left){
            a[k] = left[i];
            i++;
            k++;
        }

        while(j < num_right){
            a[k] = right[j];
            j++;
            k++;
        }
    }

    private static void quick_sort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
            int partition_index = partition(arr, low, high);
            quick_sort(arr, low, partition_index);
            quick_sort(arr, partition_index+1, high);

    }

    private static int partition(int[] arr, int low, int high) {
        int partition = low;

        for(int i = low+1; i < high; i++){
            if(arr[i] < arr[low]){
                partition++;
                swap(arr, partition, i);

            }
        }
        swap(arr, low, partition);
        return partition;
    }

    private static void swap(int[] arr, int first, int second){
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = { 5, 4, 3, 2, 6, 1};
        System.out.println(Arrays.toString(arr));
        //insert your favorite sorting algorithm
        quick_sort(arr, 0 , arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
