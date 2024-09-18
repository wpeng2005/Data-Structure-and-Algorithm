public class BinarySearchInsertNode {
    //二分查找插入点（无重复元素）
    int binarySearchInsertIntoSimple(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int m=i+(j-i)/2;
            if (nums[m]<target){
                i=m+1;
            }
            else if(nums[m]>target){
                j=m-1;
            }
            else {
                return m;
            }
        }
        //未找到target，返回索引i
        return i;
    }

    /* 二分查找插入点（存在重复元素） */
    int binarySearchInsertion(int[] nums, int target) {
        int i = 0, j = nums.length - 1; // 初始化双闭区间 [0, n-1]
        while (i <= j) {
            int m = i + (j - i) / 2; // 计算中点索引 m
            if (nums[m] < target) {
                i = m + 1; // target 在区间 [m+1, j] 中
            } else if (nums[m] > target) {
                j = m - 1; // target 在区间 [i, m-1] 中
            } else {
                j = m - 1; // 首个小于 target 的元素在区间 [i, m-1] 中
            }
        }
        // 返回插入点 i
        return i;
    }
}
