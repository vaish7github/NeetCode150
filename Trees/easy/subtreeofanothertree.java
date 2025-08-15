import java.util.*;

class main {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        TreeNode root = arrTreeNode(nums);
        TreeNode subNode = arrTreeNode(arr);
        boolean result = isSubtree(root, subNode);
        System.out.println(result);
    }

    public static TreeNode arrTreeNode(int[] nums) {
        if (nums.length == 0 || nums[0] == -1) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int i = 1;

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curr = queue.poll();

            if (i < nums.length && nums[i] != -1) {
                curr.left = new TreeNode(nums[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < nums.length && nums[i] != -1) {
                curr.right = new TreeNode(nums[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return head;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (findSubtree(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean findSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }

        if (!findSubtree(root.left, subRoot.left)) {
            return false;
        }
        if (!findSubtree(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }

}
