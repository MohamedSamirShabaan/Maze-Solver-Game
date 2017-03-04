package eg.edu.alexu.csd.ds.maze.cs57;

import javax.management.RuntimeErrorException;

public class Doubly implements MyLinkedList {

	nodeDouble header  ;
	nodeDouble tailer  ;
	int size=0 ; 
	
	public Doubly() {
		// TODO Auto-generated constructor stub
		size=0;
		header = new nodeDouble(null,null,null);
		tailer = new nodeDouble(null,header,null);
		header.next=tailer;
	}
	
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		nodeDouble newNode = new nodeDouble(element);
		nodeDouble i = header.next ;
		try{
			if(index<=size){
				if(index==0){
					if(header.next!=tailer){
						newNode.next=i;
						newNode.prev=header;
						i.prev=newNode;
						header.next=newNode;
					}else{
						newNode.next=tailer;
						newNode.prev=header;
						header.next=newNode;
						tailer.prev=newNode;
					}
				}else{
					for(int c = 0 ; c < index-1 ; c++){i=i.next ;}
					nodeDouble j = i.next ; 
					newNode.next = j ;
					j.prev = newNode ;
					i.next = newNode ;
					newNode.prev = i ;
				}
				size++;
			}else{throw new RuntimeException() ;}
		}catch(Exception e){
			throw new RuntimeErrorException(null, "Exception");
		}		
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		nodeDouble newNode = new nodeDouble(element);
		try {
			if(size==0){
				newNode.next=tailer;
				newNode.prev=header;
				header.next=newNode;
				tailer.prev=newNode;
			}else{
				nodeDouble i =tailer.prev ;
				newNode.next = tailer ;
				tailer.prev = newNode ;
				i.next = newNode ;
				newNode.prev = i ;
			}
			size++;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeErrorException(null, "Exception");
		}
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		nodeDouble i = header.next ;
		try {
			if(index>=0&&index<size){
				for(int c = 0 ; c < index ; c++){i=i.next ;}
			}else{throw new RuntimeException() ;}	
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeErrorException(null, "Exception");
		}
		return i.value;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		nodeDouble i = header.next ;
		try{
			if(index==0){
				i.value=element ;
			}else{
				for(int c = 0 ; c < index ; c++){i=i.next ;}
				i.value=element ;
			}
		}catch(Exception e){
			throw new RuntimeErrorException(null, "Exception");
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		header.next = tailer ;
		tailer.prev=header;
		size = 0 ;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean empty = false ;
		if(size==0){empty = true ;}
		return empty ;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		nodeDouble i = header.next , j = null , n = null ;
		try {
			if(size>0){
				if(index==0){
					j=i.next;
					j.prev=header;
					header.next=j;
					i.next=null;
					i.prev=null;
				}else{
					for(int c = 0 ; c < index ; c++){i=i.next ;}
					n = i;
					j=i.prev;
					i=i.next;
					j.next=i;
					i.prev=j;
					n.next=null;
					n.prev=null;
				}
				size-- ;
			}else{throw new RuntimeException() ;}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeErrorException(null, "Exception");
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size ;
	}

	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		Doubly sublist = new Doubly() ;
		nodeDouble i = header.next , s = null , e = null ;
		try {
			if(fromIndex<=toIndex){
				for(int c = 0 ; c <= toIndex ; c++){
					s=new nodeDouble(i.value);
					if(c>fromIndex&&c<=toIndex){e.next=s; s.prev=e;}		
					if(c==fromIndex){sublist.header.next=s ; s.prev=sublist.header;}
					if(c==toIndex){s.next=sublist.tailer ; sublist.tailer.prev=s;}
					e=s;
					i=i.next ;
				}
				sublist.size=toIndex-fromIndex+1;
			}else{throw new RuntimeException() ;}
		}catch (Exception t) {
			// TODO: handle exception
			throw new RuntimeErrorException(null, "Exception");
		}
		return sublist ;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		nodeDouble i =header.next ;
		try {
			if(o==null){throw new RuntimeException() ;}
			if(i==tailer){return false ;}
			else{
				while(i.value!=o){
					i=i.next ;
					if(i==tailer){
						return false ;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeErrorException(null, "Exception");
		}
		return true ;
	}

	public int search(Object v){
		nodeDouble i = header.next ;
		int index = 0 ;
		if(i==tailer){return -1 ;}
		else{
			while(i.value!=v){
				i=i.next;
				index++;
				if(i==tailer){return -1 ;}
			}
		}
		return index ;
	}	
	
	public void Print(){
		nodeDouble i = header.next ;
		while(i!=tailer){
			System.out.print(i.value);
			i=i.next;
		}
		System.out.println();
	}
	
}
