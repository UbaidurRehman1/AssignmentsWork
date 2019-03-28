package com.ubaid.calculatorDataStructure;

public class Subtract extends Operation
{

	public Subtract(double operand)
	{
		super(operand, '-');
	}

	@Override
	public double doMath()
	{
		return getTotal() - operand;
	}
	
	

}
