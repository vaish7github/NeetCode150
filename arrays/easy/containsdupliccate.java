import java.util.*;

class main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int [] nums = new int[n];
        for (int i =0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();
        boolean result = containsDuplicate(nums);
        System.out.println(result);

    }
    public static boolean containsDuplicate(int [] nums){
        Set<Integer> set= new HashSet<>();

        for (int num: nums){
            if( set.contains(num)){
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }
}