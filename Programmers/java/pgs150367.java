import java.util.*;

class pgs150367 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = isBinaryTree(getFullBinary(numbers[i])) == true ? 1 : 0;
        }

        return answer;
    }

    public boolean isBinaryTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '0') {
            return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
        }

        return isBinaryTree(leftSubTree) && isBinaryTree(rightSubTree);
    }

    public String getFullBinary(Long number) {
        String binary = Long.toBinaryString(number);
        int length = binary.length();
        int lv = 1;
        int nodeCnt = 1;
        while (length > nodeCnt) {
            lv *= 2;
            nodeCnt += lv;
        }

        for (int i = 0; i < nodeCnt - length; i++) {
            binary = "0" + binary;
        }
        return binary;
    }

    private boolean isZeroTree(String binary) {
        int len = binary.length();
        if (binary.length() == 0) return true;

        int root = len / 2;
        String leftSubTree = binary.substring(0, root);
        String rightSubTree = binary.substring(root + 1);

        if (binary.charAt(root) == '1') {
            return false;
        }

        return isZeroTree(leftSubTree) && isZeroTree(rightSubTree);
    }
}