import java.util.*;

/** Gustavo Parcianello Cardona binary tree implementation. */

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        DotFile dotFile = new DotFile();
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println();
            System.out.println("We have two options for you!");
            System.out.println("1: Generate the tree with 7 random numbers.");
            System.out.println("2: Generate the tree with 7 selected numbers.");
            System.out.println("The selected numbers will generate a pretty tree :)\nIf you choose the random numbers, the tree might look a little awkward when visualizing it.");
            System.out.print("Select 1 or 2: ");
            int selectedType = sc.nextInt();

            while (selectedType < 1 || selectedType > 2) {
                System.out.println("Select a valid number...");
                selectedType = sc.nextInt();
            }

            List<Integer> numbers = new ArrayList<>();
            switch (selectedType) {
                case 1: numbers.addAll(generateRandomNumbers(7));
                case 2: numbers.addAll(Arrays.asList(10, 5, 20, 3, 7, 31, 12));
            }

            for (Integer num : numbers) {
                binaryTree.insert(num, binaryTree.root);
                System.out.println();
            }

            System.out.println("Numbers: " + numbers);
            System.out.println();

            System.out.println("****** pre order ******");
            binaryTree.preOrder(binaryTree.root);
            System.out.println("\n***********************\n");

            System.out.println("****** in order ******");
            binaryTree.inOrder(binaryTree.root);
            System.out.println("\n**********************\n");

            System.out.println("***** post order *****");
            binaryTree.postOrder(binaryTree.root);
            System.out.println("\n**********************\n");

            dotFile.generatePreOrderDotFile("pre-order-binary-tree.dot", binaryTree);
        } catch (Exception e) {
            System.out.println("An error ocurred while running the program. Error: " + e.getMessage());
        }
    }

    private static List<Integer> generateRandomNumbers(int quantity) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < quantity) {
            Integer randomNumber = random.nextInt(quantity);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
