package Algo.tree;
import java.util.UUID;

import javax.swing.*;

public class SegmentTreeDynamic {
    class Node {
        Node left,right;
        int val;
        int add;
    }
    private int N=(int )1e9;
    private Node root=new Node();
    public void update(Node node ,int start,int end,int l,int r,int val){
        if(l<=start&&end<=r){
            node.val+=(end-start+1)*val;
            node.add=val;
            return;
        }
        int mid=(start+end)<<1;
        pushdown(node,mid-start+1,end-mid);
        if (l<=mid) update(node.left,start,mid,l,r,val);
        if (r>mid ) update(node.right,mid+1,end,l,r,val);
        pushup(node);
    }
    public void pushup(Node node){
        node.val=node.left.val+node.right.val;
    }
    public  void pushdown(Node node,int leftNum,int rigthNum){



    }

    public static void main(String[] args) {
        int num=200;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<num;i++){
           // sb.append("userId==");
            sb.append(UUID.randomUUID().toString());
            if(i<num-1){
                sb.append(",");
            }

        }
        System.out.println(sb);

    }

}
