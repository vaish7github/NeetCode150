import java.util.*;
class main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data = x;
            left= null;
            right = null;
        }
    }

    public static void main(String [] args){
        Scanner sc= new Scanner (System.in);
        int n = sc.nextInt();
        int [] nums= new int [n];
        for (int i=0;i< nums.length ;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();

        TreeNode head= arrtotTreeNode(nums);
        TreeNode result = invertTree(head);

        Queue<TreeNode> queue = new LinkedList<>();
        if (result != null){
            queue.offer(result);
        }
        while (!queue.isEmpty()){
            int queuesixe = queue.size();
            for (int i =0;i< queuesixe;i++){
                TreeNode curr= queue.poll();

                System.out.print(curr.data+" ");
                if (curr.left!= null){
                    queue.offer(curr.left);
                }
                if (curr.right!= null){
                    queue.offer(curr.right);
                }
            }
           

        }

    }

    public static TreeNode arrtotTreeNode(int [] nums){
        if (nums.length ==0 || nums[0]==-1){
            return null;
        }

        Queue <TreeNode> queue= new LinkedList<>();
        TreeNode head = new TreeNode(nums[0]);
        queue.offer(head);

        int i= 1;

        while(i< nums.length && !queue.isEmpty()){

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

    public static TreeNode invertTree(TreeNode head){
        inverse(head);
        return head;
    }
    public static void inverse(TreeNode head){
        if (head == null){
            return ;
        }

        TreeNode temp = head.left;
        head.left= head.right;
        head.right= temp;

        inverse(head.left);
        inverse(head.right);
    }
}