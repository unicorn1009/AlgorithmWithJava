package com.unicorn.Leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 341. 扁平化嵌套列表迭代器
 * </p>
 * Created on 2021/03/23 09:04
 *
 * @author Unicorn
 */
public class Solution0341 {
    public static void main(String[] args) {
        System.out.println("aaa");
    }

}

class NestedIterator implements Iterator<Integer> {
    int size;
    int curIndex;
    List<NestedInteger> nestedList;
    NestedIterator childList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.size = nestedList.size();
        this.curIndex = 0;
    }

    @Override
    public Integer next() {
        if (this.nestedList.get(curIndex).isInteger()) {
            Integer ans = this.nestedList.get(curIndex).getInteger();
            curIndex++;
            return ans;
        } else {
            if (this.childList == null) {
                List<NestedInteger> child = this.nestedList.get(curIndex).getList();
                NestedIterator childIterator = new NestedIterator(child);
                this.childList = childIterator;
            }
            if (this.childList.hasNext()){
                Integer next = this.childList.next();
                if (!this.childList.hasNext()){
                    curIndex++;
                }
                return next;
            }
            else {
                this.childList = null;
                curIndex++;
                if (this.hasNext())
                    return this.next();
                return null;
            }
        }

    }

    @Override
    public boolean hasNext() {
        if (curIndex < size) {
            if (this.nestedList.get(curIndex).isInteger())
                return true;
            else {
                List<NestedInteger> list = this.nestedList.get(curIndex).getList();
                if (new NestedIterator(list).hasNext())
                    return true;
                else {
                    curIndex++;
                    return hasNext();
                }
            }
        }else
            return false;

    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

