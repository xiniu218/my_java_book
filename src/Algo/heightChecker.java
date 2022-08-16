package Algo;

import java.util.Arrays;

public class heightChecker {
    public int heightChecker(int[] heights){
        int n=heights.length;
        int ans=0;
        int [] ep=new int [n];
        System.arraycopy(heights,0,ep,0,n);
        Arrays.sort(ep);
        for (int i=0;i<n;i++){
            if (heights[i]!=ep[i]){
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] ans =new int []{1,2,3,5,10,11,2};
        System.out.println(new heightChecker().heightChecker(ans));

    }
}
