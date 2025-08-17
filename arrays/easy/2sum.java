import java.util.*;

class main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums= new int[n];

        for (int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }
        int m = sc.nextInt(); // this will be the target
        int [] result = twoSum(nums, m);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> mymap = new HashMap<>();

        for (int i =0;i< nums.length ;i++){
            int compliment = target- nums[i];
            if (mymap.containsKey(compliment)){
                return new int[ ]{mymap.get(compliment),i};
            } else {
                mymap.put(nums[i],i);
            }
        }
        return new int [] {-1,-1};
    }
}