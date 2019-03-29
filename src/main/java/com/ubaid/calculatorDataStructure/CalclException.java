package com.ubaid.calculatorDataStructure;

public class CalclException extends Operation {


	public CalclException(String message)
	{
		super(message);
	}

	@Override
	public double doMath()
	{
		return 0;
	}

}
