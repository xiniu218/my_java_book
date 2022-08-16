package Algo;

public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
            int n=nums.length;
            int ret=0;
            int prod=1;
            int i=0;
        for (int j = 0; j < n; j++) {
            prod*=nums[j];
            while (i<=j&&prod>=k){
                prod/=nums[i];
                i++;
            }
            ret+=j-i+1;
        }return ret;

    }

}
