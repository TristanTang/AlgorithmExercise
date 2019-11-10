package tmp;

class Node {
    int value;
    Node leftChild;
    Node rightChild;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node(int value) {
        this.value = value;
    }
}


public class FindTheNodeInBST {
    public static Node findTheNode(Node tree) {
        return null;
    }
}
