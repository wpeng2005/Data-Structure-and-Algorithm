package HashMapImp;

import java.util.ArrayList;
import java.util.List;

//链式地址哈希表
public class HashMapChaining {
    int size;//键值对数量
    int capacity;//哈希表容量
    double loadThres; //触发扩容的负载因子阈值
    int extendRatio;//扩容倍数
    List<List<Pair>> buckets;//桶数组

    /* 构造方法 */
    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    //哈希函数
    int hashFunc(int key){
        return key % capacity;
    }

    //负载因子
    double loadFactor(){
        return (double)size/capacity;
    }
    //查询操作
    String get(int key){
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if(pair.key ==key){
                return pair.val;
            }
        }
        return null;
    }
    //扩容哈希表
    void extent(){
        List<List<Pair>> bucketsTemp = buckets;
        capacity *= extendRatio;
       buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        size=0;
        //将键值对从原哈希表搬运至扩容后的哈希表
        for (List<Pair> bucket : bucketsTemp) {
            for (Pair pair : bucket) {
                put(pair.key,pair.val);
            }
        }
    }
    //添加操作
    void put(int key,String val){
        //当负载因子超过阈值时，进行扩容
        if (loadFactor()>loadThres){
            extent();
        }
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        //遍历桶，如果遇到指定key，则更新对应val并返回
        for (Pair pair : bucket) {
            if(pair.key == key){
                pair.val=val;
                return;
            }
        }
        //若没有该key，则将键值对添加至尾部
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }
    //删除操作
    void remove(int key){
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        //遍历桶，如果存在则删除相应的键值对
        for (Pair pair : bucket) {
            if(pair.key == key){
                bucket.remove(pair);
                size--;
                return;
            }
        }
    }
}
