package com.mzy.algorithm.heap;

/**
 * @author ：mizhaoya
 * @date ：2020/9/18 15:57
 * @description：
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {
    public LeftistHeap() {
        this.root = null;
    }
    private Node<AnyType> root;
    private static class Node<AnyType> {
        Node(AnyType theElement) {
            this(theElement, null, null);
        }
        Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt) {
            this.element = theElement;
            this.left = lt;
            this.right = rt;
            this.npl = 0;
        }
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;
    }

    public void merge(LeftistHeap<AnyType> rhs) {
        merge(root, rhs.root);
    }
    public void insert(AnyType x) {
        merge(root, new Node<>(x));
    }
    public AnyType findMin() {
        return root.element;
    }
    public AnyType deleteMin() {
        AnyType res = root.element;
        root = merge(root.left, root.right);
        return res;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public void makeEmpty() {
        root = null;
    }
    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        if (h1.element.compareTo(h2.element)<0) {
            return merge1(h1, h2);
        } else {
            return merge1(h2, h1);
        }
    }
    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null) {
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if(h1.left.npl < h1.right.npl) {
                swapChildren(h1);
            }
            h1.npl = h1.right.npl + 1;
        }

        return h1;
    }
    private void swapChildren(Node<AnyType> t) {
        Node<AnyType> tmp = t.left;
        t.right = t.left;
        t.left = tmp;
    }
}
