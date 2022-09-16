public class Sort{
    public static void main(String[] args) {
        int[] nums = {5,1,4,6,8,3,7};
        insertSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void bubbleSort(int[] arr){
        int temp =0;
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    temp= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectSort(int[] arr){
        int temp,min=0;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
    public static void insertSort(int[] arr){
        System.out.println("insertsort");
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;
            while(position>0&&arr[position-1]>value){
                arr[position] = arr[position-1];
                position--;
            }
            arr[position] = value;
        }
    }
    public static void mergeSort(int[] arr){
        System.out.println("归并排序");
        int[] temp = new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length-1);
        for (int num : arr) {
            System.out.println(num);
        }
    }
    public static void internalMergeSort(int[] arr,int[] temp, int l,int r){
        int middle = l+(l-r)/2;
        if(l<r){
            internalMergeSort(arr, temp, l, middle);
            internalMergeSort(arr, temp, middle+1, r);;
            mergeSortedArray(arr, temp, l, middle, r);;
        }
    }
    public static void mergeSortedArray(int[] arr,int[] temp, int l, int middle, int r){
        for(int i=l;i<r;i++){
            temp[i] = arr[i];
        }
        int i = l;
        int j = middle+1;
        for (int k = l; k< r; k++) {
            if(i==middle+1){
                arr[k] = temp[j++];
            }else if(j==r+1){
                arr[k] = temp[i++];
            }else if(temp[i]<temp[j]){
                arr[k] = temp[i++];
            }else{
                arr[k] = temp[j++];
            }
        }
    }
}