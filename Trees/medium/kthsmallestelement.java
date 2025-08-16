import java.util.*;

class main {
    static int count = 0;
    static TreeNode result = null;

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
        int k = sc.nextInt();
        sc.close();
        TreeNode head = arrTreeNode(nums);
        int value =kthSmallest(head, k);
        System.out.println(value);
    }

    public static TreeNode arrTreeNode(int[] nums) {
        if (nums.length == 0) {
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

    public static int kthSmallest(TreeNode head, int k) {
        helper(head, k);
        return result.data;
    }

    public static void helper(TreeNode head, int k) {
        if (head == null) {
            return;
        }
        helper(head.left, k);
        count++;
        if (count == k) {
            result = head;
            return;
        }
        helper(head.right, k);
    }
}