import java.util.*;

class Lab02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.err.println("Enter n m : ");
			int n = in.nextInt();
			int m = in.nextInt();
			if(n == 0) 
				break;

			System.out.println("Combination(" +  
				n + ", " + m + ") : " + 
				Combi(n, m));
		}
	}
	static int Combi(int n, int m) {
		if (m == 0 || n == m)
			return 1;
		return Combi(n - 1, m) + Combi(n - 1, m - 1);
	}
}
