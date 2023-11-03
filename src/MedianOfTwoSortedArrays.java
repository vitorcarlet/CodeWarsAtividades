import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int fal = nums1.length;
        int sal = nums2.length;
        int sum= 0;
        double mediana=0;
        int[] result = new int[fal+sal];
        System.arraycopy(nums1,0,result,0,fal);
        System.arraycopy(nums2,0,result,fal,sal);
        System.out.println(Arrays.toString(result));
        if(result.length % 2 == 0){
             sum = result.length / 2;
            mediana = ((double)result[sum - 1] + result[sum]) / 2;
        }else{
            sum = (result.length / 2);
            mediana = result[sum];
            System.out.println(mediana);

        }
        return mediana;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4,4,5};
        int[] nums2 = {6,7,7,7};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
