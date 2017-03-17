package application;

public class Calculate implements Calculator{
	public int num1;
	public int num2;
	public double answer;
	public char symbol;
	
	public Calculate(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}

	/**
	 *  Add the addends to find the sum
	 */
	public void add(){
		answer = num1 + num2;
		symbol = '+';
	}
	
	/**
	 * Subtract the subtrahend and minuend to find the difference
	 */
	public void subtract(){
		answer = num1 - num2;
		symbol = '-';
	}
	
	/**
	 *  Multiply the factors to get the product
	 */
	public void multiply(){
		answer = num1 * num2;
		symbol = 'x';
	}
	
	/**
	 *  Divide the dividend with the divisor to get the quotient
	 */
	public void divide(){
		answer = ((double) num1) / num2;		
		symbol = '/';
	}
	
	/**
	 * Convert calculation into string
	 */
	@Override
	public String toString(){
		if (symbol == '/'){
			return String.format("%d %c %d = %.4f", num1, symbol, num2, answer);
		}
		else{
			return String.format("%d %c %d = %.0f", num1, symbol, num2, answer);
		}
	}
		
}
