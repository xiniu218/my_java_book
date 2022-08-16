package Algo.tree;


public class Node {

        Node left,right;
        int val;
        int add;


     private void pushdown(Node node,int leftNum,int rightNum ){
         if (node.left==null){
             node.left=new Node();
         }
         if (node.right==null){
             node.right=new Node();
         }
         if (node.add==0) return ;
         node.left.val+=node.add*leftNum;
         node.right.val+=node.add*rightNum;
         node.left.add+=node.add;
         node.right.add+=node.add;
         node.add=0;
     }
     private void pushUp(Node node){
         node.val=node.left.val+node.right.val;
     }
     public void update(Node node,int start,int end,int l,int r,int val){
         if (l<start&&end<=r){
             node.val+= (end-start+1)*val;
             node.add=val;
             return;
         }
         int mid=(start+end)>>1;
         pushdown(node,mid-start+1,end-mid);
         if(l<=mid) update(node.left,start,mid,l,r,val);
         if (r>mid) update(node.right,mid+1,end,l,r,val );
         pushUp(node);
     }

}

