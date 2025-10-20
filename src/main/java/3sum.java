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
      for (int j = i + 1; j < nums.length && nums[j] <= 0; j++) {
        ArrayList<List<Integer>> entry = m.getOrDefault(nums[i] + nums[j], new ArrayList<>());
        List<Integer> t = new ArrayList<>();
        t.add(i);
        t.add(j);
        entry.add(t);
        m.put(nums[i] + nums[j], entry);
      }
    }

    for (int i = nums.length - 1; i > 0 && nums[i] >= 0; i--) {
      for (int j = i - 1; j > 0 && nums[j] >= 0; j--) {
        ArrayList<List<Integer>> entry = m.getOrDefault(nums[i] + nums[j], new ArrayList<>());
        List<Integer> t = new ArrayList<>();
        t.add(i);
        t.add(j);
        entry.add(t);
        m.put(nums[i] + nums[j], entry);
      }
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (m.containsKey(-nums[i])) {
        List<List<Integer>> l = m.get(-nums[i]);
        for (List<Integer> entry : l) {
          List<Integer> fentry = new ArrayList<>();
          fentry.add(nums[i]);
          fentry.add(nums[entry.get(0)]);
          fentry.add(nums[entry.get(1)]);
          result.add(fentry);
        }
      }
    }
    return result;
  }
}
