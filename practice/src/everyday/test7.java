package everyday;

import java.util.Arrays;
import java.util.List;

import javax.swing.JSpinner.ListEditor;

import javafx.scene.shape.PathElement;

// 计算二叉树路径和的最大值
public class test7{
    public static void main(String[] args) {
        int[] parent = new int[]{-1,0,1,2,0};
        int[] values = new int[]{-2,10,10,-3,10};
        int res = 0;
        for(int i=0;i<parent.length;i++){
            int sum =0;
            int p = parent[i];
            while(p!=-1){
                sum+=values[p];
                p = parent[p];
            }
        }
    }
}