package binarytree;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);

        System.out.println(binaryTree.size());
        System.out.println(binaryTree.height());
        System.out.println(binaryTree.countLeaves());
        System.out.println(binaryTree.min());
        System.out.println(binaryTree.max());
        System.out.println(binaryTree.isBinarySearchTree());
        System.out.println(binaryTree.contains(9));
        System.out.println(binaryTree.areSibling(8, 10));
        System.out.println(binaryTree.getNodesAtDistance(2));
        System.out.println(binaryTree.getAncestors(8));

        binaryTree.traverseLevelOrder();
    }
}
