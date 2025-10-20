public class Solution {
  public String longestPalindrome(String s) {
    int mid = s.length() / 2;
    String odd = "";
    String even = "";
    String longest = exp(s, mid - 1, mid);

    for (int i = mid; i < s.length() - 1; i++) {
      odd = exp(s, i - 1, i + 1);
      even = exp(s, i, i + 1);

      if (odd.length() > longest.length()) {
        longest = odd;
      }
      if (even.length() > longest.length()) {
        longest = even;
      }
      if (longest.length() > i - s.length() * 2 + 1) {
        break;
      }
    }
    for (int i = mid - 1; i > 0; i--) {
      odd = exp(s, i - 1, i + 1);
      even = exp(s, i - 1, i);

      if (odd.length() > longest.length()) {
        longest = odd;
      }
      if (even.length() > longest.length()) {
        longest = even;
      }
      if (longest.length() > i * 2 + 1) {
        break;
      }
    }
    return longest;
  }

  private String exp(String s, int l, int r) {
    while (r <= s.length() && l >= 0 && s.charAt(l) == s.charAt(r)) {
      r += 1;
      l -= 1;
    }
    return s.substring(l + 1, r);
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String result = solution.longestPalindrome("xaabacxcabaaxcabaax");
    System.out.println(result);
  }
}
