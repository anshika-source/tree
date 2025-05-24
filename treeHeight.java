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
public class treeHeight {
       //recursive
       //TC: O(N)
       //SC: O(N) --->height of binary tree(in worst case:skew tree)
       public static int findHeight(node root) {
            if(root == null) return 0;
            int LH = findHeight(root.lft);
            int RH = findHeight(root.ryt);
            return Math.max(LH, RH)+1;
       }

       //iterative: using level order
       //TC: O(N)
       //SC: O(N)---> using queue (N--> no. of nodes)
       public static int maxDepth(node root) {
            if(root == null) return 0;

            Queue<node> q = new LinkedList<>();
            int level = 0;
            q.add(root);

            while(!q.isEmpty()) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    node front = q.poll();
                    //insert lft child
                    if(front.lft != null) q.add(front.lft);
                    //insert ryt child
                    if(front.ryt != null) q.add(front.ryt);
                }
                level++;
            }
            return level;
       }
       public static void main(String[] args) {
        node root = new node(1);
        root.lft = new node(2);
        root.ryt = new node(3);
        root.lft.lft = new node(4);
        root.lft.ryt = new node(5);
        root.ryt.lft = new node(6);
        root.ryt.ryt = new node(7);
        //root.ryt.ryt.ryt = new node(7);

        int ans = findHeight(root);
        System.out.println(ans);

        int ans2 = findHeight(root);
        System.out.println(ans2);
    }
}
