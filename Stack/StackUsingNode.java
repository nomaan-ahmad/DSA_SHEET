import java.util.Arrays;

public class StackUsingNode {
    private static class Node<T> {
        T val;
        Node<T> next;

        Node(T _val) {
            val = _val;
            next = null;
        }
    }
    public static class Stack<T> {
        private Node<T> top;
        private int size;
        Stack(){
            top = null;
            size = 0;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public T peek() {
            if (top == null) throw new NullPointerException();

            return top.val;
        }

        public void push(T val) {
            Node<T> temp = new Node<>(val);
            size++;
            if (!isEmpty()) temp.next = top;
            top = temp;
        }

        public T pop() {
            if (top == null) throw new NullPointerException();

            size--;
            T temp = peek();
            top = top.next;
            return temp;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            Object[] res = new Object[size];
            Node<T> temp = top;

            int i = 0;
            while (i < size) {
                res[i] = temp.val;
                temp = temp.next;
            }

            return Arrays.toString(res);
        }
    }
}
