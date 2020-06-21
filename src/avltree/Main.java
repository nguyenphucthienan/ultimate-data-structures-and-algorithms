package avltree;

public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(12);
        avlTree.insert(3);
        avlTree.insert(9);
        avlTree.insert(4);
        avlTree.insert(6);
        avlTree.insert(2);

        avlTree.traversePreOrder();
    }
}
