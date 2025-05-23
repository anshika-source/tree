import java.util.ArrayList;
import java.util.Collections;

class node {
    int data;
    node lft, ryt;

    public node(int key) {
        data = key;
    }
}


public class boundary {

    //this fun() will check whether a node is leaf or not
    public static boolean isLeaf(node root) {
        return root.lft == null && root.ryt == null;
    }
    //left boundary
    public static void addLeftBoundary(node root, ArrayList<Integer> res) {
        node curr = root.lft;
        while(curr != null) {
            //not a leaf node
            if(!isLeaf(curr)) res.add(curr.data);
            if(curr.lft != null) curr = curr.lft;
            //if not have left node 
            else curr = curr.ryt;
        }
    }
    
    //adding leaves
    public static void addLeaves(node root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.lft != null) addLeaves(root.lft, res);
        if (root.ryt != null) addLeaves(root.ryt, res);
    }

    public static void addRightBoundary(node root, ArrayList<Integer> res) {
        node curr = root.ryt;
        ArrayList<Integer> tmp = new ArrayList<>();
        while(curr != null) {
            if(!isLeaf(curr)) tmp.add(curr.data);
            if(curr.ryt != null) curr = curr.ryt;
            else curr = curr.lft;
        }
        //reversing tmp
        Collections.reverse(tmp);
        res.addAll(tmp);
    }

    public static ArrayList<Integer> boundaryTraversal(node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null) return res;
        //adding root
        if(!isLeaf(root)) res.add(root.data);
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {
        node root = new node(10);
        root.lft = new node(20);
        root.ryt = new node(30);
        root.lft.lft = new node(40);
        root.lft.ryt = new node(50);
        root.ryt.lft = new node(60);
        root.ryt.ryt = new node(70);
        root.lft.ryt.lft = new node(80);
        root.lft.ryt.ryt = new node(90);

        ArrayList<Integer> boundary = boundaryTraversal(root);
        System.out.println(boundary);
    }
}
