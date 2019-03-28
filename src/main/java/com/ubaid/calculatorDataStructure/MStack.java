package com.ubaid.calculatorDataStructure;

import java.util.LinkedList; 

public class MStack<E>
{ 
    private LinkedList<E> s = new LinkedList<>();
    
    
    public void push(E e)
    {
    	s.addLast(e);
    } 
    
    public E pop()
    {
    	return s.removeLast();
    } 
    
    public E peek()
    {
    	return s.getLast();
    }
    
    public int size()
    {
    	return s.size();
    }
    
    public boolean isEmpty()
    {
    	return s.isEmpty();
    }

} 

