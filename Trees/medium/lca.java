import java.util.*;
class main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data= x;
            left= null;
            right= null;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        int [] arr = new int[2];
        for (int i =0;i< arr.length;i++){
            arr[i]= sc.nextInt();
        }
        sc.close();

        TreeNode head = arrTreeNode(nums);
        TreeNode node1= new TreeNode(arr[0]);
        TreeNode node2 = new TreeNode(arr[1]);
        TreeNode result =lowestCommonAncestor(head,node1,node2);
        TreeNode temp= result;
        System.out.println(temp.data);

    }

    public static TreeNode arrTreeNode(int [] nums){
        if (nums.length ==0){
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(head);
        int i =1;

        while (!queue.isEmpty() && i<nums.length){
            TreeNode curr= queue.poll();

            if (i< nums.length && nums[i]!=-1){
                curr.left= new TreeNode(nums[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i< nums.length && nums[i]!=-1){
                curr.right= new TreeNode(nums[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return head;
    }
    public static TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q){
        if (p.data>q.data){
            return lowestCommonAncestor(head, q, p);
        }
        return lca(head, p ,q);
    }
    public static TreeNode lca(TreeNode head, TreeNode low, TreeNode high){
        if(head == null){
            return null;
        }

        if (head.data< low.data){
            return lca(head.right, low , high);
        }
        if (head.data>high.data){
            return lca(head.left, low , high);
        }
        else {
            return head;
        }
    }
}