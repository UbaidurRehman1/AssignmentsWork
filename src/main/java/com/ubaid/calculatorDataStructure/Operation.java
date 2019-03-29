package com.ubaid.calculatorDataStructure;

public abstract class Operation implements Cloneable
{
	final double operand;
	private static double total;
	protected double _total;
	final protected char operator; 
	private boolean isNormalOperation = false;
	private char undo_rodo;
	
	public Operation(double operand, char operator)
	{
		this.operand = operand;
		this.operator = operator;
		_total = doMath();
		setNormalOperation(true);
	}
	
	public abstract double doMath();

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		Operation.total = total;
	}

	public void redo()
	{
		undo_rodo = 'R';
		setNormalOperation(false);
		doMath();
	}
	
	public void undo()
	{
		undo_rodo = 'U';
		setNormalOperation(false);
	}
	
	@Override
	public String toString()
	{
		String str = null;
		if(isNormalOperation)
			str = String.format("\n%c %.2f\nTotal = %.1f", operator, operand, _total);
		else
			str = String.format("\n%c\nTotal = %.1f", undo_rodo, _total);
		return str;
	}

	public boolean isNormalOperation() {
		return isNormalOperation;
	}

	public void setNormalOperation(boolean isNormalOperation) {
		this.isNormalOperation = isNormalOperation;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
