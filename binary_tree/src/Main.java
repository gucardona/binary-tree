import java.util.*;

/** Gustavo Parcianello Cardona binary tree implementation. */

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        DotFile dotFile = new DotFile();
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        try(Scanner sc = new Scanner(System.in)) {
            System.out.println();
            System.out.println("We have two options for you!");
            System.out.println("1 to generate the tree with 7 random numbers, 2 to generate the tree with 7 selected numbers.");
            System.out.println("The selected numbers will generate a pretty tree!");
            System.out.print("Select 1 or 2: ");
            int selectedType = sc.nextInt();

            while (selectedType < 1 || selectedType > 2) {
                System.out.println("Select a valid number...");
                selectedType = sc.nextInt();
            }

            List<Integer> numbers = new ArrayList<>();
            switch (selectedType) {
                case 1: numbers.addAll(generateRandomNumbers());
                case 2: numbers.addAll(Arrays.asList(10, 5, 20, 3, 7, 31, 12));
            }

            for (Integer num : numbers) {
                binaryTree.insert(num, binaryTree.root);
            }

            binaryTree.preOrder(binaryTree.root, preOrderList);
            binaryTree.inOrder(binaryTree.root, inOrderList);
            binaryTree.postOrder(binaryTree.root, postOrderList);

            int minValue = binaryTree.searchMin(binaryTree.root);
            int maxValue = binaryTree.searchMax(binaryTree.root);

            System.out.println();

            System.out.println("numbers: " + numbers);
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

            System.out.println();
            dotFile.generatePreOrderDotFile("pre-order-binary-tree.dot", binaryTree);
        } catch (Exception e) {
            System.out.println("An error occurred while running the program. Error: " + e.getMessage());
        }
    }

    private static List<Integer> generateRandomNumbers() {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 7) {
            Integer randomNumber = random.nextInt(7);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
