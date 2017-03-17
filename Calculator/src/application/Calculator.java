package application;

public interface Calculator {
	
	/**
	 *  Add the addends to find the sum
	 */
	public void add();
	
	/**
	 * Subtract the subtrahend and minuend to find the difference
	 */
	public void subtract();
	
	/**
	 *  Multiply the factors to get the product
	 */
	public void multiply();
	
	/**
	 *  Divide the dividend with the divisor to get the quotient
	 */
	public void divide();
	
	/**
	 * Convert calculation into string
	 */
	public String toString();
}
