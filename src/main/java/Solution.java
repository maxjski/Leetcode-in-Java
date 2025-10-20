import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<Integer>> m = new HashMap<>();

    int i = 0;
    for (String str : strs) {
      char[] s = str.toCharArray();
      Arrays.sort(s);
      if (m.containsKey(new String(s))) {
        List<Integer> l = m.get(new String(s));
        l.add(i);
        m.put(new String(s), l);
      } else {
        List<Integer> l = new ArrayList<>();
        l.add(i);
        m.put(new String(s), l);
      }
      i++;
    }

    List<List<String>> result = new ArrayList<>();
    for (List<Integer> entry : m.values()) {
      List<String> fl = new ArrayList<>();
      for (Integer x : entry) {
        fl.add(strs[x]);
      }
      result.add(fl);
    }
    return result;
  }
}
