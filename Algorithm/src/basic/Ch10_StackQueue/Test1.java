package basic.Ch10_StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        //Stack
        {
//            Stack<Integer> stack = new Stack<>();
//
//            stack.push(3);
//            System.out.println(stack.peek());
//            System.out.println(stack.size());
//
//            stack.push(1);
//            System.out.println(stack.peek());
//            System.out.println(stack.size());
//
//            stack.push(7);
//            System.out.println(stack.peek());
//            System.out.println(stack.size());
//
//            Integer num = stack.pop();
//            System.out.println(num);
//            System.out.println(stack.peek());
//            System.out.println(stack.size());
//
//            while(!stack.isEmpty()){
//                System.out.print(stack.pop()+" ");
//            }
        }

        //Stack using Deque
        {
            Deque<Integer> stack = new ArrayDeque<>();

            stack.push(3);
            System.out.println(stack.peek());
            System.out.println(stack.size());

            stack.push(1);
            System.out.println(stack.peek());
            System.out.println(stack.size());

            stack.push(7);
            System.out.println(stack.peek());
            System.out.println(stack.size());

            Integer num = stack.pop();
            System.out.println(num);
            System.out.println(stack.peek());
            System.out.println(stack.size());

            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}
