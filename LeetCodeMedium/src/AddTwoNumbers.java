
public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		ListNode result = addTwoNumbers(list1, list2);
		System.out.println(result.toString());
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int[] resultArray = new int[100];

		ListNode currentL1 = l1;
		ListNode currentL2 = l2;
		int i = 0;
		int remainder = 0;
		while (currentL1 != null || currentL2 != null) {
			int l1Val = 0;
			int l2Val = 0;

			if (currentL1 != null) {
				l1Val = currentL1.val;
			}
			if (currentL2 != null) {
				l2Val = currentL2.val;
			}
			int sum = l1Val + l2Val + remainder;
			if (sum > 9) {
				remainder = 1;
			} else {
				remainder = 0;
			}
			resultArray[i] = sum % 10;
			i++;
			if (currentL1 != null) {
				currentL1 = currentL1.next;
			}
			if (currentL2 != null) {
				currentL2 = currentL2.next;
			}
		}
		if (remainder > 0) {
			resultArray[i] = remainder;
			i++;
			remainder = 0;
		}
		ListNode node = new ListNode(resultArray[0]);
		ListNode head = node;
		for (int j = 1; j < i; j++) {
			ListNode newnode = new ListNode(resultArray[j]);
			head.next = newnode;
			head = head.next;
		}
		return node;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		public String toString() {
			StringBuilder strBuilder = new StringBuilder();
			ListNode current = this;
			strBuilder.append("{ ");
			while (current != null) {
				strBuilder.append(current.val);
				if (current.next != null) {
					strBuilder.append("->");
				}
				current = current.next;

			}
			strBuilder.append(" }");

			return strBuilder.toString();
		}
	}

}
