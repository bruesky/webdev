package solution;

import java.util.Iterator;

public class SimpleList
{
	private Link first;
	private Link last;

	public void append(Object item)			
	{
		if (first == null)					
		{
			first = new Link(item);
			last = first;					
		}
		else								
			last = last.append(item);		
	}

	public Iterator iterator() 
	{ 
		return new SimpleListIterator(); 
	}
	
	private class SimpleListIterator implements Iterator
	{
		private Link current = null;
		
		public boolean hasNext()
		{
			if (current == null)
				return first != null;
			else
				return current.getNext() != null;
		}

		public Object next()
		{
			Object item = null;
			
			if (current == null)
				current = first;
			else
				current = current.getNext();
			
			if (current != null)
				item = current.getItem();
		
			return item;
		}
		
		// Remove current item
		public void remove()
		{
			Link last = first;
			while (last!=null){
				if (last==current){
					first = current.getNext();
					current = current.getNext();
					last.setNext(null);
					break;
				}else if (last.getNext()==current){
					current = last.getNext();
					last.getNext().setNext(null);
					break;
				}else {
					last = last.getNext();
				}
			}
		}
	}
	
	// Using its own Iterator
	public int count()
	{
		int count = 0;

		// TODO:
		SimpleListIterator simpleListIterator = (SimpleListIterator) iterator();
		while (simpleListIterator.hasNext()){
			count++;
			simpleListIterator.next();
		}

		return count;
	}
}
