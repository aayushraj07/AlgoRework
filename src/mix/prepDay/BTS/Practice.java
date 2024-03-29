package prepDay.BTS;

import java.util.Stack;

public class Practice {

    public static class Node{
        int data;
        Node right;
        Node left;

        Node (int data, Node right, Node left){
            this.data = data;
            this.right = right;
            this.left = left;
        }

    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node){
        if(node ==null){
            return;
        }

        String str = "";
        str += node.left == null? "." : node.left.data+"";
        str += " <- " + node.data + " -> ";
        str += node.right == null? "." : node.right.data+"";
        System.out.println(str);

        display(node.left);
        display(node.right);

    }


    public static void main(String[] args) {
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root = new Node(arr[0], null,null);
        Pair rtp = new Pair(root , 1);
        Stack<Pair> stack = new Stack();
        stack.push(rtp);

//        1 is for make a left node
//        2 is for make a right node
//        3 is for pop

        int idx = 0;
        while(stack.size() >0){
            Pair top = stack.peek();
            if(top.state == 1){
                idx++;
                if(arr[idx] != null){
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    stack.push(lp);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    stack.push(rp);
                }else{
                    top.node.right = null;
                }
                top.state++;
            } else{
                stack.pop();
            }
        }
        display(root);
    }
}
