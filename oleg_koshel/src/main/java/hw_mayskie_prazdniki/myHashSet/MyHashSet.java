package hw_mayskie_prazdniki.myHashSet;

public class MyHashSet<T> {
	
	Node<T>[] arr;
	
	MyHashSet(){
		
		arr = new Node[10];
		
	}
	
	public void add(T el) {

		Node newEl = new Node();
		newEl.value = el;
		
		boolean isList = false;

		for (int i = arr.length; i > 0; i--) {

			if (arr[i-1]!= null) {

				arr[i-1].next = newEl;
				isList = true;	
				break;
			}
		}
		
		
		if (!isList){
			
			Node list = new Node();
			list.value = newEl;
			
			arr[0]=list;
			
			
		}

	}

	
	public boolean contains(T el){
		
		for (int i=0;i<arr.length;i++){
		
			Node list= arr[i];
			
			if (list!=null){
				
				if (list.value!=null) {
					
					if (list.value==el){return true;}
					
					
				}
				
				
				
				
				while (list.next!=null){
					
					if (list.value==el){
						
						return true;
						
					}
					
					list = list.next;	
				}
				
				
				
				
				
			}
			
			
			
		}
		
		
		
		return false;
	}

	
	
public int size(){
	
	int size=0;
		
		for (int i=0;i<arr.length;i++){
		
			Node list= arr[i];
			
			if (list!=null){
				
				if (list.value!=null){
				
					size = 1;
					
				}
				
				while (list.next!=null){
					
					size++;
					
					list = list.next;	
				}
				
				
				
				
				
			}
			
			
			
		}
		
		
		
		return size;
	}

class Node<T>{
    Node next;
    T value;
   }
	
}



