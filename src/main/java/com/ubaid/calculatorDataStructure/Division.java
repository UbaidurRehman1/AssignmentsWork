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
			return getTotal() / operand;
		}
		catch(Exception exp)
		{
			return getTotal();
		}
	}

}
