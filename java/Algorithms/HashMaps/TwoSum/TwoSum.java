import java.util.Arrays;
import java.util.HashMap;

class TwoSum {

  public int[] onePass(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int length = nums.length;

    for (int i = 0; i < length; i++) {
        // Only register new keys
        if (! map.containsKey(nums[i])) 
            map.put(nums[i], i); 

        int complement;
        complement = target - nums[i];

        /* While we are iterating and inserting elements into the hash table, we
         * also look back to check if current element's complement already exists
         * in the hash table. If it exists, we have found a solution and return
         * the indices immediately.
         */

        if (map.containsKey(complement) && map.get(complement) != i)
            return new int[] {map.get(complement), i};
    }
    // In case there is no solution, we'll just return null
    return null;
  }

  public static void main(String[] args) {
    int [] onepass = new int[2];

    int [] nums = {3, 2, 4};
    int target = 6;


    System.out.println("nums = " + Arrays.toString(nums));
    System.out.println("target = " + target);

    TwoSum obj = new TwoSum();

    System.out.println("\nOne Pass");
    onepass= obj.onePass(nums, target);
    System.out.println(Arrays.toString(onepass));

  }

}
