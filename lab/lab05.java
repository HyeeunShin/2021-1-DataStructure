import java.util.*;

/**
 */

class SimpleTree  {
	int[] tree; // tree

	int largestNum;	// the largest node number in the binary tree
	int capacity;	// size of the tree tree
	int height = (int)(Math.log(2) / Math.log(largestNum));


	SimpleTree(int theCapacity) { // SimpleTree constructor. 
		capacity = theCapacity;
		tree = new int[capacity];	// tree[0] is not used
		largestNum = 0;
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
		str = "T[] : - ";

		// print all the nodes in the tree
		for(int i = 1; i <= largestNum; i++)
			str += tree[i] + "  ";
		return str;
	}

	void  Init(int[] es, int n) {	
		// initialize the tree by using the input
		largestNum = n;
		for(int i = 1; i <= n; i++)
			tree[i] = es[i];
	}
	
	void  PreOrder(int node) {
		if(node > largestNum)
			{return;}
		if(tree[node]==0) return;
		System.out.print(tree[node]+ " ");
		PreOrder(node*2);
		PreOrder(node*2+1);
	}

	void  InOrder(int node) {
		if(node > largestNum)
			return;
		if(tree[node]==0) return;
		InOrder(node*2);
		System.out.print(tree[node]+ " ");
		InOrder(node*2+1);
	}

	void  PostOrder(int node) {
		if(node > largestNum)
			return;
		if(tree[node]==0) return;
		PostOrder(node*2);
		PostOrder(node*2+1);
		System.out.print(tree[node]+ " ");

	}
}


