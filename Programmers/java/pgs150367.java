import java.util.*;

class pgs150367 {
    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long number : numbers) {
            String result = changeBinary(number);

            if (isBinaryTree(result)) {
                answer.add(1);
            } else {
                answer.add(0);
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean isBinaryTree(String result) {
        int root = result.length() / 2;

        if (result.length() == 0) {
            return true;
        }

        String left = result.substring(0, root);
        String right = result.substring(root + 1);

        if (result.charAt(root) == '0') {
            return isZeroTree(left) && isZeroTree(right);
        }

        return isBinaryTree(left) && isBinaryTree(right);
    }

    public boolean isZeroTree(String result) {
        int root = result.length() / 2;

        if (result.length() == 0) {
            return true;
        }

        if (result.charAt(root) == '1') {
            return false;
        }

        String left = result.substring(0, root);
        String right = result.substring(root + 1);

        return isZeroTree(left) && isZeroTree(right);
    }


    public String changeBinary(long num) {
        String result = Long.toBinaryString(num);

        int level = 1;
        int nodeCnt = 1;
        while (result.length() > nodeCnt) {
            level *= 2;
            nodeCnt += level;
        }

        return "0".repeat(nodeCnt - result.length()) + result;
    }

}