import java.util.List;

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

    public void preOrder(Node currentNode, List<Integer> preOrderList) {
        preOrderList.add(currentNode.info);

        if (currentNode.left != null) {
            preOrder(currentNode.left, preOrderList);
        }

        if (currentNode.right != null) {
            preOrder(currentNode.right, preOrderList);
        }
    }

    public void inOrder(Node currentNode, List<Integer> inOrderList) {
        if (currentNode.left != null) {
            inOrder(currentNode.left, inOrderList);
        }

        inOrderList.add(currentNode.info);

        if (currentNode.right != null) {
            inOrder(currentNode.right, inOrderList);
        }
    }

    public void postOrder(Node currentNode, List<Integer> postOrderList) {
        if (currentNode.left != null) {
            postOrder(currentNode.left, postOrderList);
        }

        if (currentNode.right != null) {
            postOrder(currentNode.right, postOrderList);
        }

        postOrderList.add(currentNode.info);
    }

    public Integer searchMin(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.left != null) {
            return searchMin(currentNode.left);
        } else {
            return currentNode.info;
        }
    }

    public Integer searchMax(Node currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.right != null) {
            return searchMax(currentNode.right);
        } else {
            return currentNode.info;
        }
    }
}

