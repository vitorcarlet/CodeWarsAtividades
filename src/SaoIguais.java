import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaoIguais {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            int sqrt = (int) Math.pow(a[i], 2);
            for(int j =0; j< b.length;j++){
                if(sqrt==2){
                    System.out.println("2");
                }
            }
            if (sqrt != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

            int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a,b));

    }
}
