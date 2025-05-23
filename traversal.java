import java.sql.Time;

class node {
    int data;
    node lft;
    node ryt;

    public node(int key) {
        data = key;
    }
}
class traversal {
    public static void preOrder (node root) {
        if(root == null) return;
        System.out.print(root.data);
        preOrder(root.lft);
        preOrder(root.ryt);
    }
    public static void postOrder (node root) {
        if(root == null) return;
        
        postOrder(root.lft);
        postOrder(root.ryt);
        System.out.print(root.data);
    }

    public static void inOrder (node root) {
        if(root == null) return;
        
        postOrder(root.lft);
        System.out.print(root.data);
        postOrder(root.ryt);
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);

        //pre --> 1245367
        //T.C: O(N) where N is no. of nodes in tree(each node is visited exactly once).
        //S.C: O(N)
        preOrder(root);

        System.out.println();
        //post --> 4526731
        //T.C: O(N) where N is no. of nodes in tree(each node is visited exactly once).
        //S.C: O(N)
        postOrder(root);

        System.out.println();
        //in -->
        //T.C: O(N) where N is no. of nodes in tree(each node is visited exactly once).
        //S.C: O(N)
        inOrder(root);
    }
}