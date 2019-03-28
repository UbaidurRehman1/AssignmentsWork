package com.ubaid.calculatorDataStructure;

import java.util.LinkedList; 
public class MQueue<E>  { 
    private LinkedList<E> q = new LinkedList<>();
    
    public void enqueue(E e)
    {
    	q.addLast(e);
    }
    
    public E dequeue()
    {
    	return q.removeFirst();
    }
    
    public E peek()
    {
    	return q.getFirst();
    }
    
    public int size()
    {
    	return q.size();
    }
    
    public boolean isEmpty()
    {
    	return q.isEmpty();
    }
    
} 