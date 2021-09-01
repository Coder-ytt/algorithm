import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        List<Integer> one=new ArrayList<Integer>();
        List<Integer> two=new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if(nums[i]%3==1){
                System.out.println(nums[i]+"余数为1");
                one.add(nums[i]);
            }else if (nums[i]%3==2){
                System.out.println(nums[i]+"余数为2");
                two.add(nums[i]);
            }else {
                System.out.println(nums[i]+"整除3");
            }
        }
        System.out.println("余数1的总数："+one.size());
        System.out.println("余数2的总数："+two.size());
        int m = sum%3;
        System.out.println("sum="+sum);
        System.out.println("m="+m);
        if(m==1){
           if(two.size()>=2){
               if(two.get(0)+two.get(1)>one.get(0)){
                   //删除当前这个余数为1的数
                   System.out.println("删除了1个余数为1的");
                   sum = sum - one.get(0);
               }else{
                   //否则删除两个余数为2的数
                   System.out.println("删除了2个余数为2的");
                   sum = sum - two.get(0)-two.get(1);
               }
           }else{
               System.out.println("删除了1个余数为1的");
               sum = sum - one.get(0);
           }
        }else if(m==2){
            if(one.size()>=2){
                if(one.get(0)+one.get(1)>two.get(0)){
                    //删除当前这个余数为2的数
                    System.out.println("删除了1个余数为2的");
                    sum = sum - two.get(0);
                }else{
                    //否则删除两个余数为1的数
                    System.out.println("删除了2个余数为1的");
                    sum = sum - one.get(0)-one.get(1);
                }
            }else{
                System.out.println("删除了1个余数为2的");
                System.out.println(sum);
                sum = sum - two.get(0);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        maxSumDivThree maxSumDivThree = new maxSumDivThree();
        int i = maxSumDivThree.maxSumDivThree(nums);
        System.out.println(i);
    }
}
