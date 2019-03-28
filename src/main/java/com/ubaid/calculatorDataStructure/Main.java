package com.ubaid.calculatorDataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Operation operation;
		MQueue<Operation> queue = new MQueue<>();
		
		String line = null;
		do
		{
			line = input.nextLine();
			try
			{
				String[] arr = line.split(" ");
				
				if(arr.length == 1)
				{
					switch(arr[0])
					{
						case "E":
							for(int i = 0; i < queue.size(); i++)
							{
								System.out.println(queue.dequeue());
							}
							break;
						default:
							throw new IllegalArgumentException("Incorrent Token, Skiping Line");
					}
				}
				else if(arr.length == 2)
				{
					char[] charArray = arr[0].toCharArray();
					
					if(charArray.length == 1)
					{
						char operator = charArray[0];
						double operand = Double.parseDouble(arr[1]);
						
						switch(operator)
						{
							case '+':
								operation = new Sum(operand);
								break;
							case '-':
								operation = new Subtract(operand);
								break;
							case '*':
								operation = new Multiply(operand);
								break;
							case '/':
								operation = new Division(operand);
								break;
							default:
								throw new IllegalArgumentException("Incorrect Toake, Skipping LIne");
					
						}
						
						queue.enqueue(operation);
					}
					else
					{
						throw new IllegalArgumentException("Incorrent Token, Skipping Line");
						
					}
				}
				
			}
			catch(NumberFormatException exp)
			{
				
			}
			catch(IllegalArgumentException exp)
			{
				
			}
			catch(Exception exp)
			{
				
			}
			
			
		}while(line != "X");
		
		input.close();
	}

}
