package Algo;

public class oneEditAwayoneEditAway {
    public boolean oneEditAwayoneEditAway(String first, String second) {
        int n=first.length();
        int m=second.length();
        if (Math.abs(n-m)>1) return false;
        if (n>m) return oneEditAwayoneEditAway(second,first);
        int i=0,j=0,cnt=0;
        while (i<n&&j<m&&cnt<=1){
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1==c2){
                i++;
                j++;
            }
            else {
                if (n==m){
                    i++;
                    j++;
                    cnt++;
                }else {
                    j++;
                    cnt++;
                }
            }
        }return cnt<=1;
    }

}
