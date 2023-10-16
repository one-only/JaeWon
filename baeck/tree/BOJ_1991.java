package baeck.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트리 순회
public class BOJ_1991 {
    //static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node head = new Node('A', null, null);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }


    private static class Node {
        private char key;
        private Node left;
        private Node right;
        public Node(char key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
    public static void insertNode(Node tmp, char root, char left, char right) {
        if(tmp.key == root) {
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if(tmp.left != null) insertNode(tmp.left, root, left, right);
            if(tmp.right != null) insertNode(tmp.right, root, left, right);
        }
    }
    public static void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.key);
        inOrder(node.right);
    }
    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.key);
    }
}
