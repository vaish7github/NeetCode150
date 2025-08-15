import java.util.*;

class main{
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        String t= sc.nextLine();
        boolean result = isAnagram(s, t);
        System.out.println(result);
        sc.close();
    }
    public static boolean isAnagram(String s, String t){
        if (s.length()!= t.length()){
            return false;
        }

        int [] count = new int[26];
        for (int i =0;i< s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        
        for (int i =0;i<26;i++){
            if (count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
