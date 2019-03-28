package com.ubaid.calculatorDataStructure;

public abstract class Operation
{
	final double operand;
	private double total = 0;
	final protected char operator; 
	
	public Operation(double operand, char operator)
	{
		this.operand = operand;
		this.operator = operator;
	}
	
	public abstract double doMath();

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString()
	{
		String str = String.format("%c %f\nTotal = %.1f", operator, operand, total);
		return str;
	}
	
	
}
