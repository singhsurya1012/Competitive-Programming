package codechef.problems;


import java.io.PrintWriter;
import java.util.*;

public class BACREP {

    public static void solve(Scanner sc, PrintWriter writer) {

        int N = sc.nextInt();
        int Q = sc.nextInt();

        TreeNode[] tree = new TreeNode[N + 1];


        TreeNode root = new TreeNode(1);
        tree[1] = root;

        for (int i = 1; i <= N - 1; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            TreeNode xNode = tree[x];
            TreeNode yNode = tree[y];


            if (xNode == null) {
                xNode = new TreeNode(x);
                tree[x] = xNode;
            }

            if (yNode == null) {
                yNode = new TreeNode(y);
                tree[y] = yNode;
            }

            xNode.addChild(yNode);
            yNode.addChild(xNode);
        }


        for (int i = 1; i <= N; i++) {
            tree[i].setBacteria(sc.nextLong());
        }

        Map<Integer, List<TreeNode>> levelMap = new HashMap<>();

        removeRedundantNodes(root, levelMap, 1);

        if (root.getChildNodes().size() > 0)
            processBacteria(root);

        int level = 1;

        for (int i = 0; i <= Q - 1; i++) {

            String s = sc.next();

            if ("+".equals(s)) {

                int index = sc.nextInt();
                long bacteria = sc.nextLong();
                TreeNode node = tree[index];
                node.setBacteria(node.getBacteria() + bacteria);
                level = Integer.min(level, node.getLevel());
            } else {

                int index = sc.nextInt();
                writer.println(tree[index].getBacteria());
                level++;
            }

            if (level <= levelMap.size()) {

                for (TreeNode node : levelMap.get(level)) {
                    processBacteria(node);
                }

            }


        }


    }

    private static void removeRedundantNodes(TreeNode root, Map<Integer, List<TreeNode>> levelMap, int level) {

        root.setLevel(level);

        if (levelMap.containsKey(level))
            levelMap.get(level).add(root);
        else {
            List<TreeNode> treeNodeList = new LinkedList<>();
            treeNodeList.add(root);
            levelMap.put(level, treeNodeList);
        }
        for (TreeNode child : root.getChildNodes()) {

            child.getChildNodes().remove(root);
            removeRedundantNodes(child, levelMap, level + 1);
        }

        if (root.getChildNodes().size() == 0)
            root.setLeaf(true);

    }

    private static void processBacteria(TreeNode root) {

        for (TreeNode child : root.getChildNodes()) {

            long bacteria = root.getBacteria();
            if (!child.isLeaf())
                processBacteria(child);
            child.setBacteria(child.getBacteria() + bacteria);

        }

        root.setBacteria(0);


    }

    static class TreeNode {
        private int nodeNum;
        private List<TreeNode> childNodes = new LinkedList<>();
        private boolean leaf;
        private long bacteria;
        private int level;

        public TreeNode(int nodeNum) {
            this.nodeNum = nodeNum;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public long getBacteria() {
            return bacteria;
        }

        public void setBacteria(long bacteria) {
            this.bacteria = bacteria;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        public List<TreeNode> getChildNodes() {
            return childNodes;
        }

        public void addChild(TreeNode child) {
            this.childNodes.add(child);
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return nodeNum == treeNode.nodeNum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nodeNum);
        }
    }


}



