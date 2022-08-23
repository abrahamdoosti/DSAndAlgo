package com.dsa.practice;
/**
 * Stack implementation using Array
 * @author abrah
 *
 */
public class Stack {
	private static final int MAX_LENGTH=10;
	private String[] stackArray;
	private int top;
	
	public Stack() {
		stackArray=new String[MAX_LENGTH];
		top=-1;
	}

	public static void main(String[] args) {
		Stack st=new Stack();
		st.push("first");
		st.push("second");
		st.pop();
		st.push("third");
		

	}
	
	public boolean isEmpty() {
       return top<0;
	}

	public void push(String value) throws IndexOutOfBoundsException {
		top++;
		if(top>=MAX_LENGTH) {
			throw new IndexOutOfBoundsException("Stack is full!");
		}
		this.stackArray[top]=value;
		System.out.println(value + " pushed into stack");
	}

	public String pop() {
		if (isEmpty()) {
			return null;
		}
		String str = this.stackArray[top--];	
		System.out.println(str+" poped from stack");
		return str;
	}

	public String peek() {
		if (isEmpty()) {
			return null;
		}
		return this.stackArray[top];
		
	}

}
