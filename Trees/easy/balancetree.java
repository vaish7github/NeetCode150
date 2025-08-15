import java.util.*;

class main{
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            data= x;
            left= null;
            right = null;
        }
    }

    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums = new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();

        TreeNode head = arrtooTreeNode(nums);
        boolean result =isBalanced(head);
        System.out.print(result);
    }

    public static TreeNode arrtooTreeNode(int [] nums){
        if (nums.length == 0 || nums[0]==-1){
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        Queue <TreeNode> queue= new LinkedList<>();
        queue.offer(head);
        int i =1;

        while (!queue.isEmpty() && i< nums.length){

            TreeNode curr= queue.poll();
            if (i< nums.length && nums[i]!=-1){
                curr.left = new TreeNode(nums[i]);
                queue.offer(curr.right);
            }
            i++;
            if (i< nums.length && nums[i]!=-1){
                curr.right = new TreeNode(nums[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return head;
    }

    public static boolean isBalanced(TreeNode head){
        return (balance(head))!=-1;
    }

    public static int balance(TreeNode head){
        if (head == null){
            return 0;
        }

        int leftheight = balance(head.left);
        if (leftheight==-1){
            return -1;
        }
        int rightheight = balance(head.right);
        if (rightheight==-1){
            return -1;
        }

        if (Math.abs(leftheight-rightheight)>1){
            return -1;
        }
        return (Math.max(leftheight, rightheight))+1;

    }
}
