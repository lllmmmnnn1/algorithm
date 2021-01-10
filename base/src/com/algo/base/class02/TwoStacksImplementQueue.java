package com.algo.base.class02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
 * 1）pop、push、getMin操作的时间复杂度都是 O(1)。
 * 2）设计的栈类型可以使用现成的栈结构。
 *
 *解决思路：同时创建两个栈 然后一个正常存取
 * 另一个也同时有存取数据 但是在存的时候，会和当前栈顶的做比较
 * 小的存进去
 *
 * 4    1
 * 1    1
 * 6    2
 * 2    2
 * 4    3
 * 3    3
 * 3    3
 */
public class TwoStacksImplementQueue {

    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush=new Stack<Integer>();
            stackPop=new Stack<Integer>();
        }

        //push栈向pop栈倒入数据
        private void pushToPop(){
            if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }

}
