package com.ubaid.calculatorDataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.Size2DSyntax;

public class Main
{

	
	Scanner input = new Scanner(System.in);

	MQueue<String> inputs = new MQueue<>();
	String option = null;

	
	
	public static void main(String[] args)
	{
		Main main = new Main();
		System.out.println("Enter tokens. Legal tokens are integers, +, -, *, /, U[ndo], R[edo], E[valuate] and [e]X[it]");
		main.getInputs();
	}

	private void getInputs()
	{
		do
		{
			option = input.nextLine();
			inputs.enqueue(option);
			
		}while(!option.equals("E") && !option.equals("X"));

		start();
	}
	
	private void start()
	{
		Operation operation;
		MQueue<Operation> queue = new MQueue<>();
		MStack<Operation> undo = new MStack<>();
		MStack<Operation> redo = new MStack<>();
		
		
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
							if(undo.isEmpty())
								throw new IllegalArgumentException("ERROR --> Undo is empty - Can't Undo ");								
							Operation undoOperation = (Operation) undo.pop().clone();
							undoOperation.undo();
							queue.enqueue(undoOperation);
							redo.push(undoOperation);
							break;
						case "R":
							if(redo.isEmpty())
								throw new IllegalArgumentException("ERROR --> Redo is empty - Can't Redo ");
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
							throw new IllegalArgumentException("ERROR --> Invalid Token - line ignored");
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
								throw new IllegalArgumentException("ERROR --> Invalid Token - line ignored");
					
						}
						
						queue.enqueue(operation);
						undo.push(operation);
					}
					else
					{
						throw new IllegalArgumentException("ERROR --> Invalid Token - line ignored");
						
					}
				}
				
			}
			catch(NumberFormatException exp)
			{
				queue.enqueue(new CalclException(exp.getMessage()));
			}
			catch(IllegalArgumentException exp)
			{
				queue.enqueue(new CalclException(exp.getMessage()));
			}
			catch(Exception exp)
			{
				queue.enqueue(new CalclException(exp.getMessage()));
			}
			
			
		}
		
		input.close();

	}
}
