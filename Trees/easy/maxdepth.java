import java.util.*;
class main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right ;
        TreeNode(int x){
            data=x;
            left= null;
            right = null;
        }
    }

    public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        int n = sc.nextInt();
        int [] nums= new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }

        sc.close();

        TreeNode head = arrTreeNode(nums);
        int result =maxDepth(head);
        System.out.print(result);
    }

    public static TreeNode arrTreeNode(int [] nums){
        if (nums.length ==0 || nums[0]==-1){
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode > queue= new LinkedList<>();

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

    public static int maxDepth(TreeNode head){
        if (head == null){
            return 0;
        }

        int left= maxDepth(head.left)+1;
        int right = maxDepth(head.right)+1;

        return Math.max(left,right);
    }
}