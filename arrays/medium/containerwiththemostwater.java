import java.util.*;


class main{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();

        int result = maxArea(nums);
        System.out.println(result);
    }
    public static int maxArea(int[] nums){
        int start= 0;
        int end = nums.length -1;
        int result =0;
        while (start< end){
            int length = end - start;
            int area= length *Math.min(nums[start], nums[end]);
            result =Math.max(result,area);

            if (nums[start]< nums[end]){
                start++;
            } else {
                end--;
            }
        }
        return result;


    }
}