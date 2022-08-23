package com.exmaple.practice;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
	
	public static void main(String[] args) {
		Node root=insert(1);
		root=insert(root,2);
		root=insert(root,3);
		root=insert(root,4);
		root=insert(root,5);
		root=insert(root,6);		
		root=insert(root,7);
		root=insert(root,8);
		root=insert(root,9);
		root=insert(root,10);
		root=insert(root,11);
		List<Integer> vals=new ArrayList<Integer>();
		traverseTree(root, vals);
		
		
	}
	
	private static void traverseTree(final Node root, final List<Integer> datas) {
		// left
		if (root.left != null) {
			traverseTree(root.left, datas);
		}
		// root
		datas.add(root.val);
		System.out.print(root.val);

		// right
		if (root.right != null) {
			traverseTree(root.right, datas);
		}

	}

	public static Node insert(int val) {
		return insert(null,val);
	}
	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node();
			root.val = val;
			root.height = setHeight(root);
			return root;
		}
		if (val <= root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		}
		int balance = height(root.left) - height(root.right);

		if (balance > 1) {
			if (height(root.left.left) >= height(root.left.right)) {
				root = rightRotation(root);
			} else {
				root.left = leftRotation(root.left);
				root = rightRotation(root);
			}
		} else if (balance < -1) {
			if (height(root.right.right) >= height(root.right.left)) {
				root = leftRotation(root);
			} else {
				root.right = rightRotation(root.right);
				root = leftRotation(root);
			}
		} else {
			root.height = setHeight(root);
		}
		return root;
	}

	private static Node rightRotation(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private static Node leftRotation(Node root) {
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.height = setHeight(root);
		newRoot.height = setHeight(newRoot);
		return newRoot;
	}

	private static int height(Node root) {
		if (root == null) {
			return -1;
		}
		else {
			return root.height;
		}
	}

	private static int setHeight(Node root) {
		if (root == null) {
			return -1;
		} else {
			return 1 + Math.max(height(root.left), height(root.right));
		}

	}
}

class Node {
	int val;
	Node right;
	Node left;
	int height;
}
