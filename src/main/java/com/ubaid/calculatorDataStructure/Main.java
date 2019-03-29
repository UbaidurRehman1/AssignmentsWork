package com.ubaid.calculatorDataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class Main
{

	
	Scanner input = null;
	MQueue<String> inputs = new MQueue<>();
	String option = null;

	
	
	public static void main(String[] args)
	{
	}

	public void getInputs()
	{
		do
		{
			option = input.nextLine();
			inputs.enqueue(option);
			
		}while(!option.equals("E") || !option.equals("X"));

	}
	
	public void start()
	{
		input = new Scanner(System.in);
		Operation operation;
		MQueue<Operation> queue = new MQueue<>();
		MStack<Operation> undo = new MStack<>();
		MStack<Operation> redo = new MStack<>();
		
		
		System.out.println("Enter tokens. Legal tokens are integers, +, -, *, /, U[ndo], R[edo], E[valuate] and [e]X[it]");
		String line = null;
		
		
		
				
		while(!inputs.isEmpty())
		{
			line = inputs.dequeue();
			try
			{
				String[] arr = line.split(" ");
				
				if(arr.length == 1)
				{
					switch(arr[0])
					{
						case "E":
							int size = queue.size();
							for(int i = 0; i < size; i++)
							{
								Operation operation2 = queue.dequeue();
								System.out.println(operation2);
							}
							getInputs();
							break;
						case "U":
							Operation undoOperation = (Operation) undo.pop().clone();
							undoOperation.undo();
							queue.enqueue(undoOperation);
							redo.push(undoOperation);
							break;
						case "R":
							if(redo.isEmpty())
								throw new IllegalArgumentException("Redo stack is empty");
							Operation op = (Operation) redo.pop().clone();	
							op.redo();
							queue.enqueue(op);
							undo.push(op);
							break;
						case "X":
							size = queue.size();
							for(int i = 0; i < size; i++)
							{
								Operation operation2 = queue.dequeue();
								System.out.println(operation2);
							}
							System.exit(0);
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
						undo.push(operation);
					}
					else
					{
						throw new IllegalArgumentException("Incorrent Token, Skipping Line");
						
					}
				}
				
			}
			catch(NumberFormatException exp)
			{
				System.out.println(exp.getMessage());
			}
			catch(IllegalArgumentException exp)
			{
				System.out.println(exp.getMessage());
			}
			catch(Exception exp)
			{
				System.out.println(exp.getMessage());				
			}
			
			
		}
		
		input.close();

	}
}
