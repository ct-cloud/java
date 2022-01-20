package algorithm.leetcode;

public class Leetcode_45 {
    public static void main(String [] args){
       int [] nums = new int [] {2,3,1,1,4};
       jump(nums);
    }
    public static int jump(int[] nums) {
        int length = nums.length;
        int pos = 0;
        int totalHop = 0;
        while(pos < length){
            int distance = 0;
            int nextPos = 0;
            for(int i=1; i<=nums[pos]; i++){
                if(pos+i >= length-1 ){
                    nextPos = pos + i;
                    break;
                }
                if(pos+i+nums[pos+i] >= distance){
                    distance = pos + i + nums[pos+i];
                    nextPos = pos + i;
                    System.out.printf("pos: %d, index: %d, distance: %d, nextPos: %d\n", pos, i, distance, nextPos);
                }
            }
            System.out.printf("totalHop : %d, pos: %d\n", totalHop, pos);
            totalHop++;
            pos = nextPos;
            if(distance >= length-1){
                break;
            }
        }
        return totalHop;
    }
}
