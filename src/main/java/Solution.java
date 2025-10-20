import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, ArrayList<List<Integer>>> m = new HashMap<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      for (int j = i + 1; j < nums.length && nums[i] <= 0; j++) {
        ArrayList<List<Integer>> entry = m.getOrDefault(nums[i] + nums[j], new ArrayList<>());
        List<Integer> t = new ArrayList<>();
        t.add(nums[i]);
        t.add(nums[j]);

        m.put(nums[i] + nums[j], entry.add());
      }
    }
  }
}
