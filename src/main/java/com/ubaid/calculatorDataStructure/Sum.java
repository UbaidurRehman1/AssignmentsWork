package com.ubaid.calculatorDataStructure;

public class Sum extends Operation
{

	public Sum(double operand)
	{
		super(operand, '+');
	}

	@Override
	public double doMath()
	{
		setTotal(getTotal() + operand);
		_total = getTotal();
		return getTotal();
	}

	@Override
	public void undo() {
		super.undo();
		setTotal(getTotal() - operand);
		_total = getTotal();
	}

	
}
