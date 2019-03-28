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
		return getTotal() * operand;
	}

}
