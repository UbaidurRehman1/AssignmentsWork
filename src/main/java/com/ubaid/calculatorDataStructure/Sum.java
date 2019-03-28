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
		return getTotal() + operand;
	}

}
