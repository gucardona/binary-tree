import java.io.FileWriter;
import java.io.PrintWriter;

public class BinaryTree {
    public Node root = null;

    public void insert(Integer info, Node currentNode) {
        if (currentNode == null) {
            root = new Node(info);
        } else if (info < currentNode.info) {
            if (currentNode.left == null) {
                currentNode.left = new Node(info);
            } else {
                insert(info, currentNode.left);
            }
        } else if (info > currentNode.info) {
            if (currentNode.right == null) {
                currentNode.right = new Node(info);
            } else {
                insert(info, currentNode.right);
            }
        }
    }

    public void preOrder(Node currentNode) {
        System.out.print(" " + currentNode.info);

        if (currentNode.left != null) {
            preOrder(currentNode.left);
        }

        if (currentNode.right != null) {
            preOrder(currentNode.right);
        }
    }

    public void inOrder(Node currentNode) {

        if (currentNode.left != null) {
            inOrder(currentNode.left);
        }

        System.out.print(" " + currentNode.info);

        if (currentNode.right != null) {
            inOrder(currentNode.right);
        }
    }

    public void postOrder(Node currentNode) {
        if (currentNode.left != null) {
            postOrder(currentNode.left);
        }

        if (currentNode.right != null) {
            postOrder(currentNode.right);
        }

        System.out.print(" " + currentNode.info);
    }
}

