package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        for(int i=0; i<post.length;i++){
            map.put(post[i], i);
        }


        return constructTree(pre, 0, pre.length-1, 0, post.length-1);
    }

    public TreeNode constructTree(int[] preorder,int ps, int pe, int pos, int poe){

        if(ps>pe|| pos>poe)
            return null;

        TreeNode node = new TreeNode(preorder[ps]);

        if(ps+1<=pe){
            ps++;
            int i = map.get(preorder[ps]);
            int len = i-pos+1;

            node.left = constructTree(preorder, ps,ps+len-1 , pos, i);
            node.right = constructTree(preorder,ps+len,pe, i+1,pe-1);

        }

        return node;
    }

    public TreeNode constructFromPrePostSlow(int[] pre, int[] post) {

        int N = pre.length;
        if (N == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        if (N == 1) {
            return root;
        }

        int L = 0;
        for (int i = 0; i < N; i++) {

            if (pre[1] == post[i]) {
                L = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1),
                Arrays.copyOfRange(post, 0, L));

        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N),
                Arrays.copyOfRange(post, L, N - 1));

        return root;
    }
}
