package AVLTree;

public class AVL {
    private Node root;
    public AVL() {
        this.root = null;
    }
    public Node getRoot() {
        return this.root;
    }
    private int getHeight(Node node) {
        //Getting node's height
        //If node is null than his height is -1 else we get his height
        return (node == null) ? -1 : node.getHeight();
    }
    private int updateHeight(Node node) {
        //Updating height with Math.max formula + 1
        //We get the highest height of both children and add 1 (if both are null than highest is -1 +1 than node height is 0)
        return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1;
    }
    private int getBalanceFactor(Node node) {
        //Getting balance factor of node
        //If node is null than balance factor is -1 else we get height of his left child - height of his right child
        return (node == null) ? -1 : (getHeight(node.getLeftChild()) - getHeight(node.getRightChild()));
    }
    private Node minimum(Node right) {
        //Getting minimal node from right child (minimum is right's left children)
        //If right's left child is null we return right else we recursively return minim(his left child)
        return (right.getLeftChild() == null) ? right : minimum(right.getLeftChild());
    }
    private Node leftRotation(Node x) {
        if (x == null || x.getRightChild() == null)
            return x;
        //Left rotation of node x
        Node y = x.getRightChild(); //y is x's right child
        Node z = y.getLeftChild();
        y.setLeftChild(x); //Assigning y's left child as x
        x.setRightChild(z); //Assigning x's right child as y's left child
        x.setHeight(updateHeight(x)); //Updating x's height
        y.setHeight(updateHeight(y)); //Updating y's height
        return y; //Returning y as new x in tree because we rotated x left so x's right child (y) became on x place
    }
    private Node rightRotation(Node x) {
        if (x == null || x.getLeftChild() == null)
            return x;
        //Right rotation of node x
        Node y = x.getLeftChild(); //y is x's left child
        Node z = y.getRightChild();
        y.setRightChild(x); //Assigning y's right child as x
        x.setLeftChild(z); //Assigning x's left child as y's right child
        x.setHeight(updateHeight(x)); //Updating x's height
        y.setHeight(updateHeight(y)); //Updating y's height
        return y; //Returning y as new x in tree because we rotated x right so x's left child (y) became on x place
    }

    //Insert methods for AVL tree
    public void insert(int data) {
        this.root = insert(this.root, data);
    }
    private Node insert(Node node, int data) {
        //Inserting new node
        if (node == null) //If node is null (we return new Node with new data)
            return new Node(data);
        else if (data > node.getData()) //If new data are smaller than node's data (we assign node's right child to insert(node's right child, new data)) recursively
            node.setRightChild(insert(node.getRightChild(), data));
        else if (data < node.getData()) //If new data are higher than node's data (we assign node's left child to insert(node's left child, new data)) recursively
            node.setLeftChild(insert(node.getLeftChild(), data));
        else //Else if new data are equals to node's data (we return untouched node)
            return node;
        //Recursively of updating height and balancing
        return balance(node, data);
    }
    //Deletion methods for AVL tree
    public void delete(int data) {
        this.root = delete(this.root, data);
    }
    private Node delete(Node node, int data) {
        //Searching for node to be deleted
        if (node == null) //If we end up at the end of tree (null node) we return untouched node
            return null;
        if (data > node.getData()) //If data to delete are higher than node's data we call recursively delete with node's right child
            node.setRightChild(delete(node.getRightChild(), data));
        else if (data < node.getData()) //If data are smaller than node's data we call recursively delete with node's left child
            node.setLeftChild(delete(node.getLeftChild(), data));
        else { //Else we found data to deleted
            if (node.getRightChild() == null) //If node's left child is null we return that node as his right child
                return node.getLeftChild();
            else if (node.getLeftChild() == null) //If node's right child is null we return that node as his left child
                return node.getRightChild();
                //That was case where node has 1 or both children null nodes
            else { //Else node has 2 children
                Node x = minimum(node.getRightChild()); //We find minimum of node's right child and assign it to x node
                node.setData(x.getData()); //We copy x (minimum node) data to node's data
                node.setRightChild(delete(node.getRightChild(), x.getData())); //We call delete method for deleting x (minimum node)
            }
        }
        //Recursively of updating height and balancing (same as inserting)
        return balance(node, data);
    }

    private Node balance(Node node, int data) {
        node.setHeight(updateHeight(node)); //Updating node's height
        int balanceFactor = getBalanceFactor(node); //Getting balance factor of node
        if (balanceFactor > 1) { //If balance factor is higher than 1 (2 or more) left heavy
            if (data > node.getLeftChild().getData()) //Checking for left-right rotation
                node.setLeftChild(leftRotation(node.getLeftChild())); //If node's left child data are smaller than new data we perform left rotate of node's left child
            return rightRotation(node); //We perform right rotation of node
        }
        if (balanceFactor < -1) { //If balance factor is smaller than -1 (-2 or less) right heavy
            if (data < node.getRightChild().getData()) //Checking for right-left rotation
                node.setRightChild(rightRotation(node.getRightChild())); //If node's right child data are higher than new data we perform right rotate of node's right child
            return leftRotation(node); //We perform left rotation of node
        }
        return node; //If balance factor is 0 1 or -1 we don't have to rotate (we return untouched node)
    }

    //Searching method for AVL tree
    public void search(int data) {
        search(this.root, data);
    }
    private boolean search(Node node, int data) {
        if (node == null)
            return false;
        if (data < node.getData())
            return search(node.getLeftChild(), data);
        else if (data > node.getData())
            return search(node.getRightChild(), data);
        else
            return data == node.getData();
    }
}