import java.util.*;

// Name : 신혜은 
// Student ID : 20191618 


class HeapSort {
	int [] heap;	// Heap Array
	int heapSize;	// number of elements in the Heap
	int size;

	HeapSort(int cap) {
		heap = new int[cap + 1];
		heapSize = 0;
	}

	public String toString() {
		// Convert heap array into a string
		String str;
		str = "Heap : - ";

		for(int i = 1; i <= heapSize; i++)
			str +=  heap[i] + "  ";

		return str;
	}

	void  Init(int [] es, int n) {
		
		heapSize = n;
		for(int i = 1; i <= n; i++)
			heap[i] = es[i];
	}


	void  Adjust(int root, int n) {
		int fir = heap[root];
		int min = Integer.MIN_VALUE;
		int min2 = Integer.MIN_VALUE;
		if( (root*2) + 1 <= n ) {
			min2 = heap[root*2 + 1];
			}

		if( root*2 <= n ) {
			min = heap[root*2];
			}	
	
		if(fir < min && min >= min2){
			heap[root] = min;
			heap[root*2] = fir;
			Adjust(root*2, n);
		}
		else if(fir < min2 && min2 > min){
			heap[root] = min2;
			heap[root*2 + 1] = fir;
			Adjust(root*2 + 1, n);
		}


	}

	void  Sort() {
		int sz = heapSize;
		while(sz > 0) {
			for(int i = heapSize; i >= 1; i--){
				Adjust(i, sz);
			}
			System.out.println(this);
			int h = heap[sz];
			heap[sz] = heap[1];
			heap[1] = h;
			sz--;

		}

	}

}
