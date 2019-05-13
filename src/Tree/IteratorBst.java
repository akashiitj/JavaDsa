package Tree;

import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

class Bst{
    Node root;
    Stack<Node> stack = new Stack<>();

    void insert(int key){
        if(root==null) {
            root = new Node(key);
            return;
        }
        Node privIt =root, it = root;
        while(it != null){
            privIt = it;
            if(it.val > key)
                it = it.left;
            else
                it= it.right;
        }
        if(privIt.val>key)
            privIt.left = new Node(key);
        else
            privIt.right = new Node(key);
    }

    void printInorder(){
        printInorderRec(root);

        //iteratively
        System.out.println("iteratively");
        Node it = root;

        while (it!=null || !stack.isEmpty()){
            while (it!=null){
                stack.push(it);
                it=it.left;
            }
            it = stack.peek();
            stack.pop();
            System.out.println(it.val);
            it = it.right;
        }
    }

    private void printInorderRec(Node root) {
        if(root==null)
            return;
        printInorderRec(root.left);
        System.out.println(root.val);
        printInorderRec(root.right);
    }


}

class Iterator{
    Node it;
    Stack<Node> stack;

    public Iterator(Bst bst) {
        it = bst.root;
        stack = new Stack<>();
        while (it!=null){
            stack.push(it);
            it = it.left;
        }
    }

    boolean hasNext(){
        return !stack.isEmpty();
    }

    Node next(){
        Node ans = stack.peek();
        stack.pop();
        it = ans.right;
        while (it!=null){
            stack.push(it);
            it = it.left;
        }
        return  ans;
    }

}

public class IteratorBst {
    public static void main(String[] args){
        Bst demo = new Bst();
        demo.insert(5);
        demo.insert(4);
        demo.insert(3);
        demo.insert(2);
        demo.insert(1);
        //demo.printInorder();

        Iterator iterator = new Iterator(demo);
        while (iterator.hasNext()){
            System.out.println(iterator.next().val);
        }
    }
}


