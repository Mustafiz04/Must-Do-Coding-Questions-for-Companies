
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String S = br.readLine().trim();
			Solution obj = new Solution();
			List<String> ans = obj.find_permutation(S);
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
			System.out.println();

		}
	}
}

class Solution {
	List<String> ans = new ArrayList<>();

	public List<String> find_permutation(String S) {
		int n = S.length();
		if (n <= 1) {
			ans.add(S);
			return ans;
		}

		findPermutation(S, 0, n - 1);
		Collections.sort(ans);
		return ans;
	}

	void findPermutation(String s, int start, int end) {
		if (start == end) {
			ans.add(s);
		} else {
			for (int i = start; i <= end; i++) {
				String str = reverse(s, start, i);
				findPermutation(str, start + 1, end);
				reverse(str, start, i);
			}
		}
	}

	String reverse(String str, int left, int right) {
		char[] arr = str.toCharArray();
		while (left <= right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		return new String(arr);
	}
}