//Credit to: https://www.baeldung.com/java-binary-tree

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BinaryTree {

    Node root;

    // ...
}

private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }

    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }

    return current;
}

public void add(int value) {
    root = addRecursive(root, value);
}

private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
        return false;
    }
    if (value == current.value) {
        return true;
    }
    return value < current.value
      ? containsNodeRecursive(current.left, value)
      : containsNodeRecursive(current.right, value);
}

public boolean containsNode(int value) {
    return containsNodeRecursive(root, value);
}

private Node deleteRecursive(Node current, int value) {
    if (current == null) {
        return null;
    }

    if (value == current.value) {
      if (current.left == null && current.right == null) {
        return null;
      }
      if (current.right == null) {
        return current.left;
      }

      if (current.left == null) {
        return current.right;
      }
      int smallestValue = findSmallestValue(current.right);
      current.value = smallestValue;
      current.right = deleteRecursive(current.right, smallestValue);
      return current;

    }
    if (value < current.value) {
        current.left = deleteRecursive(current.left, value);
        return current;
    }
    current.right = deleteRecursive(current.right, value);
    return current;
}

private int findSmallestValue(Node root) {
    return root.left == null ? root.value : findSmallestValue(root.left);
}

public void delete(int value) {
    root = deleteRecursive(root, value);
}

public void traverseInOrder(Node node) {
    if (node != null) {
        traverseInOrder(node.left);
        System.out.print(" " + node.value);
        traverseInOrder(node.right);
    }
}

public void traversePreOrder(Node node) {
    if (node != null) {
        System.out.print(" " + node.value);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }
}

public void traversePostOrder(Node node) {
    if (node != null) {
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.print(" " + node.value);
    }
}

public void traverseLevelOrder() {
    if (root == null) {
        return;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while (!nodes.isEmpty()) {

        Node node = nodes.remove();

        System.out.print(" " + node.value);

        if (node.left != null) {
            nodes.add(node.left);
        }

        if (node.right!= null) {
            nodes.add(node.right);
        }
    }
}
