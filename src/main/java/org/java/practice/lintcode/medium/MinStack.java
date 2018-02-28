package org.java.practice.lintcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.jin
 * date: 28/02/2018
 * desc:
 */
public class MinStack {

    List<Integer> list = new ArrayList<>();
    List<Integer> desc = new ArrayList<>();

    public static void main(String[] args) {
        MinStack s = new MinStack();
        /*s.push(1);
        s.pop();
        s.push(2);
        s.push(3);
        s.min();
        s.push(1);
        s.min();*/
        /*s.push(-1);
        s.push(-2);
        s.min();
        s.pop();
        s.push(-3);
        s.push(3);
        s.push(2);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.push(400);
        s.push(3);
        s.push(200);
        s.push(1);
        s.min();
        s.pop();
        s.min();*/
        s.push(1);
        s.push(1);
        s.push(1);
        s.min();
        s.pop();
        s.min();
        s.pop();
    }

    /**
     实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
     你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
     */
    public MinStack() {
        // do intialization if necessary

    }

    /**
     如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 1，2，1
     */
    public void push(int number) {
        // write your code here
        list.add(number);
        if (desc.size() > 0) {
            if (desc.get(desc.size() - 1) >= number) {
                desc.add(number);
            }
        } else {
            desc.add(number);
        }
    }

    public int pop() {
        // write your code here
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (desc.size() > 0 && desc.get(desc.size() - 1) == temp) {
            desc.remove(desc.size() - 1);
        }
        System.out.println(temp);
        return temp;
    }

    public int min() {
        // write your code here
        int min = desc.get(desc.size() - 1);
        System.out.println(min);
        return min;
    }
}
