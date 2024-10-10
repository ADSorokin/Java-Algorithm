package DZ4;

public class LeftLeanRedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private class Node {
        int key;
        Node left, right, parent;  //поле parent не используем в данной реализации алгоритма
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }


    }


    private Node root;


    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }


    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }


    private void flipColors(Node h) {
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;

    }


    public void add(int key) {
        root = add(root, key);
        root.color = BLACK;
    }

    private Node add(Node h, int key) {
        if (h == null) return new Node(key);

        if (key < h.key) {
            h.left = add(h.left, key);
        } else if (key > h.key) {
            h.right = add(h.right, key);
        } else {

            return h;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String description, boolean last) {
        if (node != null) {
            System.out.print(description);
            if (last) {
                System.out.print("R----");
                description += "          ";
            } else {
                System.out.print("L----");
                description += "|     ";
            }
            System.out.println(node.key + (isRed(node) ? "(color:Red)" :
                    "(color:Blk)"));
            printTree(node.left, description, false);
            printTree(node.right, description, true);
        }
    }

    // Для тестирования
    public static void main(String[] args) {
        LeftLeanRedBlackTree tree = new LeftLeanRedBlackTree();
        int[] keys = {10, 20, 30, 15, 25, 5};
        for (int key : keys) {
            tree.add(key);
        }
        tree.printTree();
    }


}
