import java.util.*;

public class pgs12904 {

	public int solution(String s)
	{
		char[] arr = s.toCharArray();

		for (int i = s.length(); i > 1; i--) {
			for (int j = 0; j <= s.length() - i; j++) {
				boolean isPalindrome = true;
				int left = j, right = j + i - 1;
				while (left < right) {
					if (arr[left] != arr[right]) {
						isPalindrome = false;
						break;
					}
					left++;
					right--;
				}
				if (isPalindrome) {
					return i;
				}
			}
		}

		return 1;
	}
}
