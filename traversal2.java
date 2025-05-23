import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class node {
    int data;
    node lft;
    node ryt;

    public node(int key) {
        data = key;
    }
}

public class traversal2 {


    public static void levelOrder(node root, Queue<node> q, ArrayList<ArrayList<Integer>> lst) {
        if(root == null) return;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); //size of current level
            ArrayList<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                node qNode = q.poll();
                level.add(qNode.data);

                //if their exist any child node insert them in a queue
                if(qNode.lft != null) q.add(qNode.lft);
                if(qNode.ryt != null) q.add(qNode.ryt);
            }
            lst.add(level);
        }
        for(ArrayList<Integer> level : lst) {
            System.err.print(level);
        }
        System.err.println();
    }


    public static void zigZag(node root, Queue<node> q, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;

        q.add(root);
        //using flag to traverse a level left-right and from right-left
        boolean leftToRight = true;

        while(!q.isEmpty()) {
            int size = q.size(); //curr lvl size
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 0; i < size; i++) {
                node qNode =  q.poll();
                
                //adding elements based on flag value
                if(leftToRight) {
                    level.addLast(qNode.data);
                }
                else {
                    level.addFirst(qNode.data);
                }

                //add child nodes
                if(qNode.lft != null) q.add(qNode.lft);
                if(qNode.ryt != null) q.add(qNode.ryt);
            }
            //switch the traversal direction
            leftToRight = !leftToRight;
            list.add(new ArrayList<>(level));
        }
        for(ArrayList<Integer> level : list) {
            System.err.print(level);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);

       //VERTICAL ORDER: 
       //verticalOrder(root);

       //LEVEL ORDER:
       //TC: O(N)
       //SC: O(N)
       Queue<node> q = new LinkedList<>();
       ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
       levelOrder(root, q, lst);

       //ZIG-ZAG TRAVERSAL:
       //TC: O(N)
       //SC: O(N)
        Queue<node> q2 = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        zigZag(root, q2, list);
    }
}
