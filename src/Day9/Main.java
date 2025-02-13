package Day9;

public class Main {
    public static void main(String[] args) {
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);

        System.out.println(myTree.head.value);
        System.out.println(myTree.head.left.value);
        System.out.println(myTree.head.left.left.value);
        System.out.println(myTree.head.left.right.value);

        System.out.println("===================");
        System.out.println(myTree.head.right.value);
        System.out.println(myTree.head.right.left.value);
        System.out.println(myTree.head.right.left.right.value);

        System.out.println("========================");
        System.out.println(myTree.head.right.right.left.value);
        System.out.println(myTree.head.right.right.right.value);

    }
}