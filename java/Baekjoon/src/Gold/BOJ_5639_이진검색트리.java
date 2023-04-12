package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진검색트리 {
    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String str = br.readLine();
            if (str == null || str == "") {
                break;
            }
            node.insert(Integer.parseInt(str));
        }
        postOrder(node);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
