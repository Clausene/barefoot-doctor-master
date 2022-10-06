package com.clausene.outpatien.common;

import java.util.Arrays;

/**
 * @author: Clausene
 * @Title: AlgorithmTest
 * @ProjectName: barefoot-doctor-master
 * @Description:
 * @date: 2022/10/3 8:43
 */
public class AlgorithmTest {
    private final static int[] arrays = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};

    /***
     * @author Clausene
     * @date 2022/10/3 9:32
     * @Description: 复杂度：
     * 时间复杂度O（n²）
     * 空间复杂度: O(1)
     * 稳定性：稳定
     * @param: source
     * @return int[]
    */
    private static  int[] bubbleSort(int[] source){
        // 声明新的数组
        int[] tag = new int[source.length];
        // 复制数组修改不影响元数组
        System.arraycopy(source,0,tag,0,tag.length);
        for (int i = 0; i < tag.length-1; i++) { // 执行下一轮循环不做任何元素调整
            // 从第一个元素开始提取并对比交换位置
            for (int j = 0; j < tag.length -i-1 ; j++) {
                int cur = tag[j];
                int next = tag[j+1];
                if (cur > next){
                    // 相邻的两个元素交换位置
                    tag[j] = next;
                    tag[j+1] = cur;
                }
            }
        }
        return tag;
    }
    public static void main(String[] args) {
        System.err.println(Arrays.toString(bubbleSort(arrays)));
    }
}
