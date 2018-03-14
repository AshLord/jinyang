package org.java.practice.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 14/03/2018
 * desc:
 */
public class 平面列表 {

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        helper(nestedList,res);
        return res;
    }

    public void helper(List<NestedInteger> nestedList,List<Integer> res) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                res.add(nested.getInteger());
                continue;
            }
            helper(nested.getList(),res);
        }
    }

    static interface NestedInteger{
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
