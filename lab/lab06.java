// Lab 006	:  Bellman Ford
// Name : 신혜
// Student ID : 20191618

import java.util.*;


class Graph {
	int numofnodes;  // the number of nodes in the graph
	private int[][] CostAdj; // Adjacency matrix
	private int[] dist; // dist array
	private int[] p; // p array
	final int LargeCost = 999999;

	Graph() { 
		// Graph constructor. 
		numofnodes = 0;
	}


	void Init(int n) { 
		numofnodes = n;
		// now create 2 dimensional array of numofnodes * numofnodes
		CostAdj = new int[numofnodes][numofnodes];
		dist = new int[numofnodes];
		for(int i = 0; i < numofnodes; i++) {
			dist[i] = -1;
		}
		p = new int[numofnodes];
		for(int i = 0; i < numofnodes; i++) {
			// initialize all entries to 0
			for(int j = 0; j < numofnodes; j++)
				CostAdj[i][j] = LargeCost;  // initialize the adjacency matrix
			CostAdj[i][i] = 0;
		}
	}
	public String toString() { 
		String str;
		int i = 0;
		str = "Dist : ";
		for(i = 0; i < numofnodes; i++)
			str +=  dist[i] + " ";
		str += "\n";
	
		str += "P    : ";
		for( i = 0; i < numofnodes; i++)
			str += p[i] + " ";
		str += "\n";
	
		// show the paths to all the destinations
		for( i = 0; i < numofnodes; i++) {
			str += "Path to " + i + " : ";
			str += OutPath(i);	
			str += "\n";
		}
		return str;
	}



	void Edge(int v1, int v2, int cost) { 
		// NEED TO IMPLEMENT
		CostAdj[v1][v2] = cost;
		
	}


	String OutPath(int i) { 
		String str = "";
		if (p[i] == -1) str = String.valueOf(i);
		else str =  OutPath(p[i]) + " "+ String.valueOf(i);
		return str;
		
	}

	int[] before(int n) {		 //@번노드 전 노드 번호들을 담은 리스트를 담은 배
		ArrayList<Integer> beforelist = new ArrayList<Integer>();
		for (int i = 0; i < numofnodes; i++) {
			for (int j = 0; j< numofnodes; j++) {
				if (j == n) {
					if(CostAdj[i][j] !=  LargeCost && CostAdj[i][j] != 0)
						beforelist.add(i);
				}
			}	
		}
		if(beforelist.size()>0) {
			int[] bfarr= new int[beforelist.size()];
			int size =0;
			for(int b: beforelist) {
				bfarr[size++] = b;
				}
			return bfarr;}
		else return null;
	}
	
	void BellmanFord(int v) { 
		int min;
		dist[v]= 0;
		p[v] = -1;
		int[] bfarray;
		
		for(int k = 0; k < numofnodes; k++) {
			for(int v1 = 0; v1 <= numofnodes; v1++ ) {
				min = LargeCost;
				bfarray = before(v1);
				if( bfarray==null) continue;
				for(int bf: bfarray) {
					if(dist[bf] == -1) continue;
					if( min > dist[bf] + CostAdj[bf][v1]) {
						min = dist[bf] + CostAdj[bf][v1];
						p[v1] = bf;
					}
					dist[v1] = min;
				}
		}
		}
//		System.out.println("pppppp: " );
//		System.out.println(p.length);
//
//		for(int i=0; i < p.length; i++) {
//			System.out.print( p[i] + " ");
//
//		}
	}
}






