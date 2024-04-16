import java.util.*;

/**
 * Gustavo Parcianello Cardona binary tree implementation.
 */

public class Main {
    public static void main( String[] args ) {
        BinaryTree binaryTree = new BinaryTree();
        DotFile dotFile = new DotFile();

        String generatedName = generateRandomName();

        Scanner scanner = new Scanner( System.in );

        while ( true ) {
            System.out.println();
            System.out.println( "Which operation do you want to perform?" );
            System.out.println( "1 - Insert a new node" );
            System.out.println( "2 - Remove a node" );
            System.out.println( "else - Exit" );

            int operation = scanner.nextInt();
            int value;

            if ( operation == 1 ) {
                System.out.println( "Enter the value of the node you want to insert:" );
                value = scanner.nextInt();
                binaryTree.insert( value, binaryTree.root );
            } else if ( operation == 2 ) {
                System.out.println( "Enter the value of the node you want to remove:" );
                value = scanner.nextInt();
                binaryTree.remove( value, binaryTree.root );
            } else {
                System.out.println( "Exiting..." );
                break;
            }
        }

        dotFile.generateDotFile( String.format( "%s.dot", generatedName ), binaryTree );
        printInfo( binaryTree, generatedName );
        System.out.println();
        System.out.println( "The dot file was generated.");
        System.out.println( "You can use the following command to generate the image:" );
        System.out.println( "dot -Tsvg generated/dot-files/" + generatedName + ".dot -o generated/svg-files/" + generatedName + ".svg" );
    }

    private static String generateRandomName() {
        Random random = new Random();
        String name = "binary-tree-";
        return name + random.nextInt( 10000 );
    }

    private static void printInfo( BinaryTree binaryTree, String treeName ) {
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        binaryTree.preOrder( binaryTree.root, preOrderList );
        binaryTree.inOrder( binaryTree.root, inOrderList );
        binaryTree.postOrder( binaryTree.root, postOrderList );

        int minValue = binaryTree.searchMin( binaryTree.root );
        int maxValue = binaryTree.searchMax( binaryTree.root );

        System.out.println();

        System.out.println( "+-----------------------------------------------------+" );

        System.out.println( treeName );

        System.out.println();

        System.out.print( "minimum value: " );
        System.out.println( minValue );

        System.out.print( "maximum value: " );
        System.out.println( maxValue );

        System.out.println();

        System.out.print( "pre order list:  " );
        System.out.println( preOrderList );

        System.out.print( "in order list:   " );
        System.out.println( inOrderList );

        System.out.print( "post order list: " );
        System.out.println( postOrderList );

        System.out.println( "+-----------------------------------------------------+" );
    }
}
