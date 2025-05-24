import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

class node {
    int data;
    node lft;
    node ryt;

    public node(int key) {
        data = key;
    }
}
public class printPath {

    public static List<Integer> print(node root, int search) {
        if(root == null) {
            return new ArrayList<>();
        }
        // If the current node is the target 
        if(root.data == search) {
            List<Integer> path = new ArrayList<>();
            path.add(root.data);
            return path;
        }
        //left subtree
        List<Integer> leftPath = print(root.lft, search);
        if (!leftPath.isEmpty()) {
            leftPath.add(0, root.data); // Add current node to the front
            return leftPath;
        }

        // Search in right subtree
        List<Integer> rightPath = print(root.ryt, search);
        if (!rightPath.isEmpty()) {
            rightPath.add(0, root.data);
            return rightPath;
        }
         return new ArrayList<>(); // Target not found in either subtree
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);

        int search = 5;
        List<Integer> path = print(root, search);
        for(Integer i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
    }
}
