import java.util.*;
class main{
    static int diameter=0;
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data=x;
            left= null;
            right=null;
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();
        TreeNode head =  arrTreeNode(nums);
        int result = diameterOfBinaryTree(head);
        System.out.println(result);
    }

    public static TreeNode arrTreeNode(int [] nums){
        if (nums.length ==0){
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(head);
        int i =1;
        while (!queue.isEmpty() && i< nums.length){
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

    public static int diameterOfBinaryTree(TreeNode head){
        length(head);
        return diameter;        
    }
    public static int length(TreeNode head){
        if (head ==null){
            return 0;
        }
        int left = length(head.left);
        int right = length(head.right);
        diameter = Math.max(diameter, left+right);

        return Math.max(left,right)+1;
    }


}