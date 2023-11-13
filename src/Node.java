package AVLTree;

public class Node {
    private int data, height;
    private String key;
    private Node left, right;
    public Node (int data) {
        this.data = data;
        this.height = 0;
        this.left = this.right = null;
        this.key = String.valueOf(data);
    }
    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getLeftChild() {
        return this.left;
    }
    public void setLeftChild(Node left) {
        this.left = left;
    }
    public Node getRightChild() {
        return this.right;
    }
    public void setRightChild(Node right) {
        this.right = right;
    }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
