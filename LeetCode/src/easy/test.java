package easy;

import org.junit.Test;

public class test {
    public static void main(String[] args) {

    }
    @Test
    public void test_1480(){
        int[] nums = new int[]{1,2,3,4};
        int[] ints = q_1480.runningSum_02(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
class q_1480 {
    //时间复杂度太高了
    public static int[] runningSum_01(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        for(int i = 0;i<length;i++){
            for(int j = 0;j<=i;j++){
                temp[i]+=nums[j];
            }
        }
        return temp;
    }
    //官方题解
    public static int[] runningSum_02(int[] nums) {
        int length = nums.length;
        for(int i = 1;i<length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}
class q_383{

}
