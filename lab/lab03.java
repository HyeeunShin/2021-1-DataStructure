import java.util.*;
import java.lang.*;

class Polynomial {
	private Term[] termArray;
	private int terms;  // number of nonzero terms

	class Term {
		private double coef; //coefficient
		private int exp; //exponent
	};

	// constructor
	Polynomial(int cap) {
		termArray = new Term[cap];
		terms = 0;
	}

	/**
	*  Add a new term to the end of termArray
	*/
	public void NewTerm(double theCoeff, int theExp) {	
		if(terms == termArray.length)
		{// double capacity of termArray
			termArray = Arrays.copyOf(termArray , termArray.length * 2);
		}

		termArray[terms] = new Term();
		termArray[terms].coef = theCoeff;
		termArray[terms++].exp = theExp;
		
	}

	public Polynomial Add(Polynomial b) {
		// Return the sum of the polynomials this and b
		Polynomial c = new Polynomial(128);
		int aPos = 0, bPos = 0;
		while((aPos < terms) && (bPos < b.terms))
			if(termArray[aPos].exp == b.termArray[bPos].exp){
				double t=termArray[aPos].coef+b.termArray[bPos].coef;
				if (t != 0.0) c.NewTerm(t, termArray[aPos].exp);
				aPos++; bPos++;
			}
			else if(termArray[aPos].exp < b.termArray[bPos].exp){
				c.NewTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
				bPos++;
			}
			else {
				c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
				aPos++;
			}

		// add in remaining terms of *this
		for( ; aPos < terms; aPos++)
			c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
		for( ; bPos < b.terms; bPos++)
			c.NewTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
		return c;
	}		


	double Evaluate(double f) {
		double eval = 0.0;
		for (int i = 0; i < terms; i++) {
			double termEval = 1.0;
			if (termArray[i].exp == 0) {
				termEval = 1;
			}
			else {
				for (int j = 0; j < termArray[i].exp; j++) {
				termEval *= f;	
				}
			}
			termEval *= termArray[i].coef;
			eval += termEval;
		}
		return eval;
	}

	// check whether the two polynomials are the same
	boolean Equals(Polynomial p) {
		boolean eqAns = true;
		if (terms != p.terms) {
			eqAns = false;
		}
		else {
			for (int c = 0; c < terms; c++) {
				if (termArray[c].coef == p.termArray[c].coef && termArray[c].exp == p.termArray[c].exp) {
					continue;
				}
				else {
					eqAns = false;
					break;
				}
			}
		}
		return eqAns;
	}
}


