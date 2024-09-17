public class BinarySearch {
    //二分查找(双闭区间)
    int binarySearch(int[] nums,int target){
        //初始化双闭区间[0,nums.length-1]，分别数组首元素和尾元素
        int i=0;
        int j=nums.length-1;
        //循环，当搜索空间为空时跳出循环,(i>j时为空)
        while(i<=j){
            //计算重点索引m
            int m=i+(j-i)/2;
            //此情况说明target在区间[m+1,j]中
            if(nums[m]<target){
                i=m+1;
            }
            //此情况说明target在区间[i,m-1]中
            else if (nums[m]>target) {
                j=m-1;
            }
            //nums[m]=target，则找到target，返回索引m
            else {
                return m;
            }
        }
        //未找到目标元素，返回-1
        return -1;
    }


    int binarySearchLCRO(int[] nums,int target){
        int i=0;
        int j= nums.length;
        // 循环，当搜索区间为空时跳出（当 i = j 时为空）
        while(i<j){
            int m = i + (j - i) / 2; // 计算中点索引 m
            if(nums[m]<target){
                i=m+1;
            }
            else if (nums[m]>target) {
                j=m;
            }
            else{
                return m;
            }
        }
        return -1;
    }
}
