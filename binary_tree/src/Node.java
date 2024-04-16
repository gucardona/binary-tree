public class Node {
    public Integer info;
    public Node left, right;

    public Node(Integer info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
