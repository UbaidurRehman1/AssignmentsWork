package com.ubaid.calculatorDataStructure;

public abstract class Operation implements Cloneable
{
	final double operand;
	private static double total;
	protected double _total;
	final protected char operator; 
	private boolean isNormalOperation = true;
	private char undo_rodo;
	private boolean isException = false;
	private String exceptionMessage;
	
	public Operation(double operand, char operator)
	{
		this.operand = operand;
		this.operator = operator;
		_total = doMath();
		setNormalOperation(true);
	}

	public Operation(String message)
	{
		operand = -1;
		operator = 'E';
		setException(true);
		setExceptionMessage(message);
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
		if(isNormalOperation && !isException)
			str = String.format("\n%c %.2f\nTotal = %.1f", operator, operand, _total);
		else if(!isNormalOperation)
			str = String.format("\n%c\nTotal = %.1f", undo_rodo, _total);
		else
			str = String.format("\n%s", getExceptionMessage());
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

	public boolean isException() {
		return isException;
	}

	public void setException(boolean isException) {
		this.isException = isException;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
}
