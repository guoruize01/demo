package everyday;

import java.util.*;

//树的节点
class Node{
    int val;
    Node parent;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class test6{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            if(n==0 || n==1){
                System.out.println(n);
                continue;
            }

            int[][] nums = new int[n-1][2];
            for(int i=0; i<n-1; i++){
                Integer i1 = in.nextInt();
                Integer i2 = in.nextInt();
                nums[i][0] = i1;
                nums[i][1] = i2;
            }
            //=========================建立树的过程=========================
            //将所有的节点保存在 Map 结构里面
            HashMap<Integer, Node> map = new HashMap<Integer, Node>();
            //遍历关系对，建立节点之间的联系
            for(int i=0; i<n-1; i++){
                //如果原来没有该节点，则建立新节点
                if(!map.containsKey(nums[i][0])){
                    Node node = new Node(nums[i][0]);
                    map.put(nums[i][0], node);
                }
                if(!map.containsKey(nums[i][1])){
                    Node node = new Node(nums[i][1]);
                    map.put(nums[i][1], node);
                }
                //建立节点之间的联系
                Node node0 = map.get(nums[i][0]);
                Node node1 = map.get(nums[i][1]);

                node1.parent = node0;   //注意此处要保存父节点
                if(node0.left==null)
                    node0.left = node1;
                else
                    node0.right = node1;
            }
            //找出根节点：没有父节点的，即为根节点，得到建立后的树
            Node head = null;
            for(int i=0; i<n; i++){
                Node tempnode = map.get(i);
                if(tempnode.parent == null){
                    head = tempnode;
                    break;
                }
            }
            //=========================树建立完成=========================

            //根据树，采用递归算法，得到树的高度
            int result = MyFunction(head);
            System.out.println(result);
        }
    }

    //计算树的高度
    public static int MyFunction(Node head){
        if(head==null)
            return 0;

        if(head.left == null)
            return MyFunction(head.right)+1;
        else if(head.right == null)
            return MyFunction(head.left)+1;
        else
            return Math.max(MyFunction(head.left), MyFunction(head.right))+1;
    }


}