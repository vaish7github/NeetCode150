import java.util.*;

class main {
    static int i = 0; // this is a pointer for inorder tracks the current position
    static int p = 0; // this is a pointer for preorder tracks the current position

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
        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        sc.close();

        TreeNode result = buildTree(preorder, inorder);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(result);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    System.out.print("null");
                    continue;
                }
                System.out.print(curr.data + " ");
                queue.offer(curr.left);

                queue.offer(curr.right);

            }
            System.out.println();
        }

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);

        // we take the Integer
    }

    public static TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }
        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.data);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}