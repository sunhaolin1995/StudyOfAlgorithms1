package com.example.hello.leetcode;



import java.util.*;

/**
 * @author 孙浩林
 * @date: 9/11/23 16:41
 */
public class RandomizedSet {

    private List<Integer> list;

    private Map<Integer,Integer> map;

    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        int index =list.size();
        list.add(val);
        map.put(val,index);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        //将要删除的元素和最后一个元素交换位置，然后删除最后一个元素
        int indexToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(indexToRemove,lastElement);
        map.put(lastElement,indexToRemove);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}