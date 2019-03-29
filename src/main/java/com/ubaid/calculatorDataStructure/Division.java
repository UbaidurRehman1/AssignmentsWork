package com.ubaid.calculatorDataStructure;

public class Division extends Operation
{

	public Division(double operand)
	{
		super(operand, '/');
	}

	@Override
	public double doMath()
	{
		try
		{
			setTotal(getTotal() / operand);
			_total = getTotal();
			return getTotal();
		}
		catch(Exception exp)
		{
			return getTotal();
		}
	}
	
	@Override
	public void undo() {
		super.undo();
		setTotal(getTotal() * operand);
		_total = getTotal();
	}


}
