import java.util.*;

/** Gustavo Parcianello Cardona binary tree implementation. */

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        DotFile dotFile = new DotFile();

        // original numbers: 10, 5, 20, 3, 7, 31, 12
        List<Integer> originalNumbers = (Arrays.asList(10, 5, 20, 3, 7, 31, 12));

        for (Integer number : originalNumbers) {
            binaryTree.insert(number, binaryTree.root);
        }

        /** TODO: LET ONLY THE TREE THAT YOU WANT TO GENERATE WITHOUT COMMENT
         *  TODO: AND COMMENT THE OTHERS.
         *
         *  TODO: EXAMPLE: IF YOU WANT TO GENERATE THE ORIGINAL BINARY TREE,
         *  TODO: LET ONLY THE FIRST DOTFILE.GENERATEDOTFILE(...) AND THE PRINTINFO(...),
         *  TODO: AND COMMENT THE OTHERS.
         */

        /** original binary tree means that there was no new insertions or deletions after the tree was created */
//        dotFile.generateDotFile("original-binary-tree.dot", binaryTree);
//        printInfo(binaryTree, "Original Binary Tree");

        /** binary tree with five new insertion */
//        binaryTree.insert( 1, binaryTree.root);
//        binaryTree.insert(50, binaryTree.root);
//        binaryTree.insert(32, binaryTree.root);
//        binaryTree.insert(75, binaryTree.root);
//        binaryTree.insert(4, binaryTree.root);
//        dotFile.generateDotFile("binary-tree-with-five-new-insertions.dot", binaryTree);
//        printInfo(binaryTree, "Binary Tree with Five New Insertions");

        /** binary tree with one deletion */
//        binaryTree.remove(20, binaryTree.root);
//        dotFile.generateDotFile("binary-tree-with-one-deletion.svg", binaryTree);
//        printInfo(binaryTree, "Binary Tree with One Deletion");

        /** binary tree with two new insertions and one deletion */
//        binaryTree.insert(50, binaryTree.root);
//        binaryTree.insert(45, binaryTree.root);
//        binaryTree.remove(20, binaryTree.root);
//        dotFile.generateDotFile("binary-tree-with-two-new-insertions-and-one-deletion.dot", binaryTree);
//        printInfo(binaryTree, "Binary Tree with Two New Insertions and One Deletion");

        /** binary tree with five new insertion and one deletion */
        binaryTree.insert( 1, binaryTree.root);
        binaryTree.insert(50, binaryTree.root);
        binaryTree.insert(32, binaryTree.root);
        binaryTree.insert(75, binaryTree.root);
        binaryTree.insert(4, binaryTree.root);
        binaryTree.remove(5, binaryTree.root);
        dotFile.generateDotFile("binary-tree-with-five-new-insertions-and-one-deletion.dot", binaryTree);
        printInfo(binaryTree, "Binary Tree with Five New Insertions And One Deletion");
    }

    private static void printInfo( BinaryTree binaryTree, String treeName ) {
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        binaryTree.preOrder(binaryTree.root, preOrderList);
        binaryTree.inOrder(binaryTree.root, inOrderList);
        binaryTree.postOrder(binaryTree.root, postOrderList);

        int minValue = binaryTree.searchMin(binaryTree.root);
        int maxValue = binaryTree.searchMax(binaryTree.root);

        System.out.println();

        System.out.println("+-----------------------------------------------------+");

        System.out.println(treeName);

        System.out.println();

        System.out.print("minimum value: ");
        System.out.println(minValue);

        System.out.print("maximum value: ");
        System.out.println(maxValue);

        System.out.println();

        System.out.print("pre order list:  ");
        System.out.println(preOrderList);

        System.out.print("in order list:   ");
        System.out.println(inOrderList);

        System.out.print("post order list: ");
        System.out.println(postOrderList);

        System.out.println("+-----------------------------------------------------+");
    }
}
