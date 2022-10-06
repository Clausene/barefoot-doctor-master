package com.calusene.outpatient.algorithm;

import java.util.Arrays;

/**
 * @author: Clausene
 * @Title: BubbleSort
 * @ProjectName: barefoot-doctor-master
 * @Description: 算法排序
 * @date: 2022/10/5 9:50
 */
public class SortingAlgorithm {

    private final static int[] array = {3, 4, 2, 1, 5};

    private static int[] arraycopy(int[] source){
        int[] tag = new int[source.length];
        System.arraycopy(source,0,tag,0,source.length);
        return tag;
    }
    /**
     * @author Clausene
     * @date 2022/10/5 10:05
     * @Description: 冒泡排序   时间复杂度O（n²） 空间复杂度: O(1) 稳定性：稳定
     * 1.算法思想：
     * 类似于水中冒泡，较大的数沉下去，较小的数慢慢冒起来，假设从小到大，即为较大的数慢慢往后排，较小的数慢慢往前排。实现步骤：
     * （1）两两比较（第一个数跟第二个数比较，第二个数跟第三个数比较，知道倒数第二个数跟倒数第一个数比较完），如果前者比后者大则交换位置。
     * （2）因此循环n-1次才能将顺序排好。
     * @param: source
     * @return int[]
    */
    private static int[] calculateBubbleSort(int[] source){
        int[] tag = arraycopy(source);
        for (int i = 0; i< tag.length-1; i++) { // 对数组进行轮询，每一遍都从头开始比较 仅此作用
            for (int j = 0; j < tag.length-1-i ; j++) { // 每次轮询从头开始一直往下获取相邻的两个数进行比较对换下标位置
                int current = tag[j];
                int next = tag[j +1];
                // 如果当前数不大于 下一个数则进入一下获取
                if (current <= next){
                    continue;
                }
                tag[j] = next;
                tag[j+1] = current;
            }
        }
        return tag;
    }

    /**
     * @author Clausene
     * @date 2022/10/5 10:21
     * @Description: 选择排序 轮询数组，每一遍都要将这边的最小值与这边开始下标的数组对换
     * 算法思想
     * （1）找到所有数中最小值下标
     * （2）第一趟循环将最小值的下标与第一个位置的数值交换位置，这样每次找到的最小值则固定到第一个
     * （3）第二趟循环从第二个开始继续上边的步骤，因为上一趟已经将最小的找到并放到了第一个的位置，因此第二趟只需从第二个数值开始比较。
     * @param: source
     * @return int[]
    */
    private static int[] calculateSelectSort(int[] source){
        int[] tag = arraycopy(source);
        for (int i = 0; i < tag.length-1; i++) { // 每一遍轮询
            for (int j = i + 1; j < tag.length; j++) { //  取数对比
                int currrent = tag[i];
                int next = tag[j];
                // 第j 个数 比 开始下标的数小则对换位置
                if (currrent > next){
                    tag[i] = next;
                    tag[j] = currrent;
                }
            }
        }
        return tag;
    }


    public static void main(String[] args) {
        System.err.println("排序之前："+Arrays.toString(array));
        System.err.println("排序之前："+Arrays.toString(calculateBubbleSort(array)));
        System.err.println("排序之前："+Arrays.toString(calculateSelectSort(array)));
    }
}
