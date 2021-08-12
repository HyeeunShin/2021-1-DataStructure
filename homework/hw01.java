import java.util.*;

class Expression {
	 public static Vector<String> prtArr;
	 public static Vector<String> Earray;
	 
	static int CharToInt(String buffer) {
	    if (buffer.equals("+"))
	        return 1;
	    else if (buffer.equals("-"))
	        return 2;
	    else if (buffer.equals("*"))
	        return 3;
	    else if (buffer.equals("/"))
	        return 4;
	    else
	        return 0;
	}
	
	static double Eval(Vector<String> str) throws Exception {
	    Stack<String>stack = new Stack<>();
		Stack<String>nstack = new Stack<>();
		int i = 0;
	    double op1, op2;String x;	   
	    String pop = "";
	    Vector<String> Earray = new Vector<String>(10);
//////////////////Infix Expression 출//////////////////////    
	    System.out.print("\nInfix Expression : [");
		for (i = 0; i < str.size(); i++) {
			if (i == str.size()-1) {
				System.out.print(str.get(i));
				break;}
			System.out.print( str.get(i) + "  ");	
			}
		System.out.print("]");
		////////////////////////////////////////////////////
		
		/////postfix 변환하기///////////////////////
	    for (int num = 0 ; num < str.size(); num++) { 
	    	x = str.get(num);
	    	if (x.equals("(")) {
	            stack.push(x);
	        }
	        else if (x.equals("+") || x.equals("-")){
	            while (!stack.isEmpty()&& !stack.peek().equals("(")) {
	            	pop = stack.pop();
	                Earray.add(pop);
	            	}
	            stack.push(x);
	        	}
	        else if (x.equals("*") || x.equals("/")){
	            while (!stack.isEmpty()  && !stack.peek().equals("(") && !stack.peek().equals("-")&& !stack.peek().equals("+")) {
	            	pop = stack.pop();
	            	Earray.add(pop);
       		}
	            stack.push(x);
	        	}
	        else if (x.equals(")")) {
	            while (!stack.peek().equals("(")) {
	            	pop = stack.pop();
	                Earray.add(pop);
	            	}
            	pop = stack.pop();
	        	}
	        else {Earray.add(x);}	      

		System.out.print("\nCurrent Token : " + x);
		System.out.print("\nStack : " + stack.toString().replace("[","").replace("]", "").replace(",",""));
	    }
	    	
	    while (!stack.isEmpty()) {
        	pop = stack.pop();
            Earray.add(pop);
	    	}
////////////////////postfix expression 출력////////////////////////
	    
		System.out.print("\nPostfix Expression : [");
		for( i = 0; i < Earray.size(); i++) {
			if (i == Earray.size()-1) {
				System.out.print(Earray.get(i)); 
				break;}
			System.out.print(Earray.get(i) + "  ");
		}
		System.out.print("]\n");
	 //////////////////////////////////////////////////////////////
		
		/////////////////////계산/////////////////////////////////
		i = 0;
	    while (i < Earray.size()) {
	        switch (CharToInt(Earray.get(i))) {
	        case 1:
	        case 2:
	        case 3:
	        case 4:
	            op2 = Double.parseDouble(nstack.pop())  ;
	            op1 = Double.parseDouble(nstack.pop())  ;
	            double value;
	            switch (CharToInt(Earray.get(i))) {
	            case 1:
	                value = op1 + op2;
	                nstack.push(String.valueOf(value));
	                break;
	            case 2:
	                value = op1 - op2;
	                nstack.push(String.valueOf(value));
	                break;
	            case 3:
	                value = op1 * op2;
	                nstack.push(String.valueOf(value));
	                break;
	            case 4:
	                value = op1 / op2;
	                nstack.push(String.valueOf(value));
	                break;
	            }
	            break;
	        case 0:
	            nstack.push(Earray.get(i));
	            break;
	        default:
	            break;
	        }
	        i++; 
	    }
	    return  Double.parseDouble(nstack.pop());}
	}	
