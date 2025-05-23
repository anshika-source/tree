// for RIGHT VIEW: using reverse preOrder traversal (i.e  root-right-left)
// for LEFT VIEW: using preOrder traversal (i.e  root-left-right)

import java.sql.Time;
import java.util.ArrayList;

class node {
    int data;
    node lft;
    node ryt;

    public node(int key) {
        data = key;
    }
}

public class view {
    public static ArrayList<Integer> rightView(node root, int level, ArrayList<Integer> lst) {
        if(root == null) return lst;
        if(level == lst.size()) {
            lst.add(root.data);
        }
        rightView(root.ryt, level+1, lst);
        rightView(root.lft, level+1, lst);

        return lst;
    }

     public static ArrayList<Integer> leftView(node root, int level, ArrayList<Integer> lst) {
        if(root == null) return lst;
        if(level == lst.size()) {
            lst.add(root.data);
        }
        leftView(root.lft, level+1, lst);
        leftView(root.ryt, level+1, lst);

        return lst;
    }
   
    public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);

        ArrayList<Integer> lst1 = new ArrayList<>();
        ArrayList<Integer> lst2 = new ArrayList<>();
        int level = 0;
        //RIGHT VIEW: 137
        ArrayList<Integer> res = rightView(root, level, lst1);

         for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();

        //LEFT VIEW: 124
        //Time Complexity: O(log2N) (in worst case: O(n)-->skew tree)
        //Space Complexity : O(log2N) (in worst case: O(n)-->skew tree)
        ArrayList<Integer> res2 = leftView(root, level, lst2);

         for (int num : res2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
