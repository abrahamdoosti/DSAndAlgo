import java.util.ArrayList;
import java.util.List;

public class CheckIFBST {
	public static void main(String[] args) {
		System.out.println(checkBST(createNonBSTTree()));
		MyNode root=insertNode(null, 5);
		insertNode(root, 1);
		insertNode(root, 8);
		insertNode(root, 4);
		insertNode(root, 6);
		insertNode(root, 7);
		insertNode(root, 9);
		insertNode(root, 3);
		insertNode(root, 11);
		System.out.println(checkBST(root));
	}

	private static boolean checkBST(MyNode root) {
		List<Integer> datas = new ArrayList<>();
		traverseTree(root, datas);
		for (int i = 0; i < datas.size() - 1; i++) {
			if (datas.get(i) > datas.get(i + 1)) {
				return false;
			}
		}
		return true;

	}

	private static void traverseTree(final MyNode root, final List<Integer> datas) {
		// left
		if (root.left != null) {
			traverseTree(root.left, datas);
		}
		// root
		datas.add(root.data);
		System.out.print(root.data);

		// right
		if (root.right != null) {
			traverseTree(root.right, datas);
		}

	}
	
	private static MyNode insertNode(MyNode root, int data) {
		if(root==null) {
			root= new MyNode(data);
			
		}
		else {
			MyNode curr;
			if(data<=root.data) {
				curr=insertNode(root.left, data);
				root.left=curr;
			}
			else {
				curr=insertNode(root.right, data);
				root.right=curr;
			}
			
		}
		return root;
		
	}
	
	private static MyNode createNonBSTTree() {
		MyNode root=new MyNode(7);
		
		MyNode l1_Left=new MyNode(6);
		MyNode l1_Right=new MyNode(3);
		root.left=l1_Left;
		root.right=l1_Right;
		
		MyNode l2_Left=new MyNode(9);
		MyNode l2_Right=new MyNode(12);
		l1_Left.left=l2_Left;
		l1_Left.right=l2_Right;
		l2_Right.left=new MyNode(4);
		root.right.right=new MyNode(1);
		root.right.right.right=new MyNode(8);
		
		return root;
	
		
		
		
	}
}

class MyNode {
	int data;
	MyNode left;
	MyNode right;
	
	MyNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
