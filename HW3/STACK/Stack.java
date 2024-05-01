package STACK;

public class Stack<Item> {

    private Node<Item> top;

    private static class Node<Item> {
        Item data;
        Node<Item> nextNode;

        public Node(Item data) {
            this.data = data;
            this.nextNode = null;
        }

    }

    public void push(Item data) {
        Node<Item> newNode = new Node<Item>(data);
        newNode.nextNode = top;
        top = newNode;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item data = top.data;
        top = top.nextNode;
        return data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public Item peek() {
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello world");
        String s = stack.pop();
        System.out.println(stack.isEmpty());
    }
}
