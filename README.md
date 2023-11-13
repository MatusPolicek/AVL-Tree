# AVL Tree Implementation

## Overview

This Java code implements an AVL (Adelson-Velsky and Landis) tree, a self-balancing binary search tree. AVL trees maintain balance by ensuring that the height difference between the left and right subtrees of any node is at most 1. This balance property helps to ensure efficient operations on the tree, such as search, insertion, and deletion.

## Usage

To use the AVL tree, follow these steps:

1. **Create an AVL Tree Object:**
    ```java
    AVL avlTree = new AVL();
    ```

2. **Insertion:**
    ```java
    avlTree.insert(data);
    ```
   This method inserts a new node with the specified data into the AVL tree while maintaining its balance.

3. **Deletion:**
    ```java
    avlTree.delete(data);
    ```
   Delete a node with the specified data from the AVL tree while preserving its balance.

4. **Search:**
    ```java
    boolean found = avlTree.search(data);
    ```
   Search for a node with the specified data in the AVL tree. Returns `true` if found, `false` otherwise.

## AVL Tree Methods

### `insert(int data)`

Inserts a new node with the given data into the AVL tree.

### `delete(int data)`

Deletes a node with the specified data from the AVL tree.

### `search(int data)`

Searches for a node with the specified data in the AVL tree.

### `getRoot()`

Returns the root node of the AVL tree.

## Internal Methods

### `getHeight(Node node)`

Returns the height of the given node. If the node is null, the height is considered -1.

### `updateHeight(Node node)`

Updates the height of the given node based on the heights of its left and right children.

### `getBalanceFactor(Node node)`

Calculates the balance factor of the given node, which is the difference between the height of its left and right children.

### `leftRotation(Node x)`

Performs a left rotation on the specified node `x` in the AVL tree.

### `rightRotation(Node x)`

Performs a right rotation on the specified node `x` in the AVL tree.

### `balance(Node node, int data)`

Balances the AVL tree after insertion or deletion of a node.

### `minimum(Node right)`

Finds the minimum node in the subtree rooted at the specified node `right`.
