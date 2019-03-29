package com.ubaid.calculatorDataStructure;

public class Multiply extends Operation
{

	public Multiply(double operand)
	{
		super(operand, '*');
	}

	@Override
	public double doMath()
	{
		setTotal(getTotal() * operand);
		_total = getTotal();
		return getTotal();
	}
	
	@Override
	public void undo() {
		super.undo();
		try
		{
			setTotal(getTotal() / operand);			
		}
		catch(Exception exp)
		{
			
		}
		_total = getTotal();
	}


}
