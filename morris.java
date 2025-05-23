//MORRIS TRAVERSAL
//TC = O(N)
//SC = O(1), no extra space is used as it uses the concept of THREADED BINARY TREE.
class node {
    int data;
    node lft;
    node ryt;

    public node(int key) {
        data = key;
    }
}

public class morris {
    public static void morrisIn(node root) {
        node curr = root;

        while(curr != null) {
            //if curr node's lft child is null
            if(curr.lft == null) {
                System.out.print(curr.data);
                //move to curr node's  ryt child
                curr = curr.ryt;
            }
            //if lft child isn't null find rytmost node in lft subtree (let say it predessor)
            else {
               node prev = curr.lft;
               while(prev.ryt != null && prev.ryt != curr) {
                prev = prev.ryt;
               } 
               //if predecessor's ryt child is null then establish temprory link (thread) b/w predecessor & curr(i.e root node)
               if(prev.ryt == null) {
                prev.ryt = curr;
                //then move to lft child
                curr = curr.lft;
               }
               else {
                //if predecessor's right child is already linked then remove the link 
                prev.ryt = null; 
                //print curr node
                System.out.print(curr.data);
                //move to the ryt child
                curr = curr.ryt;
               }
            }
        }
    }

    public static void morrisPre(node root) {
        node curr = root;

        while(curr != null) {
            //if curr node's lft child is null
            if(curr.lft == null) {
                System.out.print(curr.data);
                //move to curr node's  ryt child
                curr = curr.ryt;
            }
            //if lft child isn't null find rytmost node in lft subtree (let say it predessor)
            else {
               node prev = curr.lft;
               while(prev.ryt != null && prev.ryt != curr) {
                prev = prev.ryt;
               } 
               //if predecessor's ryt child is null then establish temprory link (thread) b/w predecessor & curr(i.e root node)
               if(prev.ryt == null) {
                prev.ryt = curr;
                //during link creating print the node
                System.out.print(curr.data);
                //then move to lft child
                curr = curr.lft;
               }
               else {
                //if predecessor's right child is already linked then remove the link 
                prev.ryt = null;
                //move to the ryt child
                curr = curr.ryt;
               }
            }
        }
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);

        //morris inorder
        morrisIn(root);

        System.out.println();

        //morris preOrder
        morrisPre(root);
    }
}
