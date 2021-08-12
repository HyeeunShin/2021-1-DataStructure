import java.util.*;

// Name :신혜은 
// Student ID :20191618

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {

	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;// the reference to the root node

	BST() { 
		// BST constructor. 
		root = null;
	}

    void Show() {

		System.out.print( "Pre  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("In   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("Post Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Count      : ");
		System.out.print( Count(root));
		System.out.println("");
		System.out.print("Height      : ");
		System.out.println( Height(root));
		System.out.println("");
	}


	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode(item);
			return true;
		}
		
		TreeNode<T> ptr, parent;
		parent = root;	
		ptr = new TreeNode(item);
		
		int itemKey = item.GetKey();	
		while(true) {
		int parentKey = parent.data.GetKey();
		if(itemKey > parentKey ) {
			if (parent.rightChild == null) {
				parent.rightChild = ptr;
				break;
			}
			parent = parent.rightChild;
			}
		else if(itemKey < parentKey) {
			if (parent.leftChild == null) {
				parent.leftChild = ptr;
				break;
			}
			parent = parent.leftChild;
			}
		else {
			ptr = new TreeNode(item);
			return false;
			}
		}
		
		return true;
	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;
		int Key = item.GetKey();
		while ( Key != ptr.data.GetKey()) {
			if(Key > ptr.data.GetKey()) {
				ptr = ptr.rightChild;
			}
			else if (Key < ptr.data.GetKey()){
				ptr = ptr.leftChild;
			}
			else {break;}
		}
			if (ptr == null) {
				return null;
			}
		
		return ptr.data;
	} 


	boolean Delete(T item)  {
		if(root == null)
			return false;	// non existing key
		TreeNode<T> ptr, parent;
		ptr = root;
		parent = root;
		int Key = item.GetKey();
		while (true) {
			if(Key > ptr.data.GetKey()) {
				parent = ptr;
				ptr = ptr.rightChild;
			}
			else if (Key < ptr.data.GetKey()) {
				parent = ptr;
				ptr = ptr.leftChild;
			}
			else if(Key == ptr.data.GetKey()){
				if (ptr.leftChild == null && ptr.rightChild == null) ptr = null;
				else if(ptr.leftChild == null) {
					parent = ptr;
					parent.rightChild = ptr.rightChild;
					ptr = null;
					ptr.rightChild = null;
					break;
				}
				else if(ptr.rightChild == null) {
					parent = ptr;
					parent.leftChild = ptr.leftChild;
					ptr = null;
					ptr.leftChild = null;
					break;

				}
				else {
					parent = ptr;
					parent.leftChild = ptr.leftChild;
					parent.rightChild = ptr.rightChild;
					ptr = null;
					ptr.leftChild = null;
					ptr.rightChild= null;
					break;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}

	void  PreOrder(TreeNode<T> t)  {
	if (t!=null) {
		System.out.print(t.data.GetKey() + "(" +t.data.GetValue() + ") ");
		PreOrder(t.leftChild);
		PreOrder(t.rightChild);
		}
	}

	void  InOrder(TreeNode<T> t)  {
		if (t!=null) {
			InOrder(t.leftChild);
			System.out.print(t.data.GetKey() + "(" +t.data.GetValue() + ") ");
			InOrder(t.rightChild);
		}
	}

	void  PostOrder(TreeNode<T> t)  {
		if (t!=null) {
			PostOrder(t.leftChild);
			PostOrder(t.rightChild);
			System.out.print(t.data.GetKey() + "(" +t.data.GetValue() + ") ");
		}
	}
	
	int leaves(TreeNode<T> t, int cnt) {
		if(t != null) {
			if(t.leftChild == null && t.rightChild == null) cnt ++;
			
			else {
				cnt = leaves(t.leftChild,cnt) + leaves(t.rightChild, cnt);
			}
		}
		else cnt = 0;
	
		return cnt;
	}
	int nleaves(TreeNode<T> t, int cnt) {
		if(t != null) {
			if(t.leftChild == null && t.rightChild == null) cnt=0;
			else {
				cnt = nleaves(t.leftChild,cnt) + nleaves(t.rightChild, cnt) + 1;
			}
		}
		else cnt = 0;
		return cnt;
	}
	int  Count(TreeNode<T> t)  {
		int cnt = 0;
		int num = leaves(t, cnt);
		int nnum = nleaves(t, cnt);
	return num + nnum; 
	}

	int  Height(TreeNode<T> t)  {
		int level;
		if(t == null) level = 0;
		else  level = 1;

		if(t.leftChild !=null && t.rightChild != null) {
			if(Height(t.leftChild) == 1 || Height(t.rightChild)==1) level++;
		}
		
		else if(t.leftChild ==null && t.rightChild != null) {
			level++;
			Height(t.rightChild);
			}
		else if(t.leftChild !=null && t.rightChild == null) {
			level++;
			Height(t.leftChild);
			}
		
		
		return level;
	}
}


