import java.io.FileWriter;
import java.io.PrintWriter;

public class DotFile {
    public void generatePreOrderDotFile(String fileName, BinaryTree binaryTree) {
        try (PrintWriter output = new PrintWriter(new FileWriter(fileName))) {
            output.println("digraph PreOrderBinaryTree {");
            output.println("node [shape=circle, style=filled, color=black, fillcolor=\"#FFFFFD\"];");
            output.println("edge [color=black];");
            writePreOrderDotFile(binaryTree.root, output);
            output.println("}");

            System.out.println("File saved.");
        } catch (Exception e) {
            System.out.println("An error occurred while opening the file: " + e.getMessage());
        }
    }

    private void writePreOrderDotFile(Node root, PrintWriter output) {
        if (root != null) {
            if (root.left != null) {
                output.println(root.info + " -> " + root.left.info + ";");
            }

            if (root.right != null) {
                output.println(root.info + " -> " + root.right.info + ";");
            }

            writePreOrderDotFile(root.left, output);
            writePreOrderDotFile(root.right, output);
        }
    }
}
