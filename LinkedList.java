package LinkedList;
public class LinkedList {

	
	public class Node{
		int info;
		Node link;
		public Node(int val )
		{
			info = val;
			link = null;
		}
		
	}
	
	public class Node2{
		int info;
		Node link;
		public Node2(int val,Node tempNode2 )
		{
			info = val;
			link = null;
		}
		
	}
	static Node head;
	
	public void addFirst(int val)
	{
		Node nw = new Node(val);
		if(head==null)
			head = nw;
		else
		{
			nw.link= head;
			head = nw;
		}
	}
	
	public void addLast(int val)
	{
		Node nw = new Node(val);
		Node temp = head;
		while(temp.link!= null)
		{
			temp = temp.link;
			
		}
			temp.link = nw;
		
	}
	
	public void addAtposition(int val, int pos)
	{
		Node nw = new Node(val);
		Node temp = head;
		for(int i =1; i<pos-1; i++)
			 temp = temp.link;
		
		nw.link= temp.link;
		temp.link = nw;
	}
	
	public void SortedInsert(int val)
	{
		Node nw = new Node(val);
		Node curr = head;
		Node prev = null;
		while( curr.info < val && curr!= null  )
		{
			prev = curr;
			curr = curr.link;
		}
		nw.link = curr;
		prev.link = nw;
	}
	public void RemoveFirst()
	{
		int info = head.info;
		head = head.link;
		System.out.println(info+"removed");
	}
	
	public void RemoveLast()
	{
		Node prev = null, curr = head;
		while(curr.link!=null)
		{
			prev = curr;
			curr = curr.link;
		}
		prev.link = null;
	}
	public void display() 
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.info +" | ");
			temp = temp.link;
		}
	}
	
//	public LinkedList copyListReversed() {
//		Node tempNode = null;
//		Node tempNode2 = null;
//		Node curr = head;
//		while (curr != null) {
//		tempNode2 = new Node(curr.info, tempNode);
//		curr = curr.link;
//		tempNode = tempNode2;
//		}
//		LinkedList ll2 = new LinkedList();
//		ll2.head = tempNode;
//		return ll2;
//		}
////	

	public void ReverseUsingThreePointer()
	{
		Node prev =null, curr = head, next = null;
		while(curr != null)
		{
			next = curr.link;
			curr.link = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	
	public void ReverseUsingRecursion(Node prev)
	{
		
		if(prev.link==null)
		{
			head = prev;
			return ;
			
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		else
			
			ReverseUsingRecursion(prev.link);
		
		Node curr=prev.link;
		curr.link = prev;
		prev.link = null;
		//System.out.println(curr.info);
	}
	public int size()
	{	
		Node curr = head;
		int count = 0;
		while(curr != null)
		{
			count++;
			curr = curr.link;
		}
		return count;
	}
	
	public int nthNodeFromBegining(int index) {
		if (index > size() || index < 1)return Integer.MAX_VALUE;
		int count = 0;
		Node curr = head;
		while (curr != null && count < index - 1) {
		count++;
		curr = curr.link;
		}
		return curr.info;
		}
	
	public int nthNodeFromEnd(int index) {
		int size = size();
		int startIndex;
		if (size != 0 && size < index) {
		return Integer.MAX_VALUE;
		}
		startIndex = size - index + 1;
		return nthNodeFromBegining(startIndex);
		}
	
	public int nthNodeFromEnd2(int index) {
		int count = 1;
		Node forward = head;
		Node curr = head;
		while (forward != null && count <= index ) {
		count++;
		forward = forward.link;
		}
		if (forward == null)
		return Integer.MAX_VALUE;
		while (forward != null) {
		forward = forward.link;
		curr = curr.link;
		}
		return curr.info;
		}
	
	public boolean Contains(int val)
	{
		Node curr = head;
		while(curr != null)
		{
			if(curr.info == val)
				return true;
			
				curr = curr.link;
				
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		LinkedList ll = new LinkedList();
		ll.addFirst(20);
		ll.display();
		System.out.println();
		ll.addFirst(10);
		ll.display();
		System.out.println();
		ll.addLast(50);
		ll.display();
		System.out.println();
		ll.addAtposition(40, 3);
		ll.display();
		System.out.println();
		ll.addAtposition(30, 3);
		ll.display();
//		System.out.println();
//		ll.SortedInsert(30);
//		ll.display();
		System.out.println();
		ll.SortedInsert(25);
		ll.display();
//		System.out.println();
//		ll.SortedInsert(20);
//		ll.display();
//		System.out.println();
//		ll.SortedInsert(40);
//		ll.display();
		System.out.println();
		ll.SortedInsert(32);
		ll.display();
		System.out.println();
		ll.SortedInsert(17);
		ll.display();
		System.out.println();
		ll.RemoveFirst();
		ll.display();
		System.out.println("removelast");
		ll.RemoveLast();
		ll.display();
		System.out.println(ll.Contains(25));
		System.out.println(ll.Contains(35));
		//LinkedList ll2 = ll.ReverseUsingAnotherLinkedList();
		//System.out.println();
		//System.out.println(ll.nthNodeFromBegining(4));
		
		
		//System.out.println(ll.nthNodeFromEnd(4));
		//System.out.println(ll.nthNodeFromEnd2(4));
		
//		System.out.println();
//		ll.ReverseUsingThreePointer();
//		ll.display();
//		
		System.out.println();
		ll.ReverseUsingRecursion(ll.head);
		ll.display();
	
		
	
	}

}