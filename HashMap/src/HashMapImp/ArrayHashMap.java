package HashMapImp;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

//基于数组实现的哈希表
public class ArrayHashMap {
    private List<Pair> buckets;
    public ArrayHashMap(){
        //初始化数组，包含100个桶
        buckets=new ArrayList<>();
        for(int i=0;i<100;i++){
            buckets.add(null);
        }
    }
    //哈希函数
    private int hashFunc(int key){
        int index=key%100;
        return index;
    }
    //查询操作
    public String get(int key){
        int index = hashFunc(key);
        Pair pair = buckets.get(index);
        if(pair == null){
            return null;
        }
        return pair.val;
    }
    //添加操作
    public void add(int key,String value){
        Pair pair=new Pair(key,value);
        int index = hashFunc(key);
        buckets.set(index,pair);
    }
    //删除操作
    public void remove(int key){
        int index = hashFunc(key);
        //设置为null，代表删除
        buckets.set(index,null);
    }
    //获取所有键值对
    public List<Pair> pairSet(){
       List<Pair> pairSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if(pair != null){
                pairSet.add(pair);
            }
        }
        return pairSet;
    }
    //获取所有键
    public List<Integer> keySet(){
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if( pair != null){
                keySet.add(pair.key);
            }
        }
        return keySet;
    }

    //获取所有值
    public List<String> valueSet(){
        List<String> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if(pair != null){
                valueSet.add(pair.val);
            }
        }
        return valueSet;
    }
    //打印哈希表
    public void print(){
        for (Pair pair : buckets) {
            System.out.println(pair.key+"---->"+pair.val);
        }
    }


}
//定义一个简单键值对
class  Pair{
    public int key;
    public String val;

    public Pair(int key,String val){
        this.key=key;
        this.val=val;
    }
}
