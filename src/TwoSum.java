import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {


        int targetSum[] = new int[2];

        HashMap<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndexMap.containsKey(complement)) {

                return new int[]{numIndexMap.get(complement), i};
            }

            numIndexMap.put(nums[i], i);
        }


        return new int[0];
    }



}
