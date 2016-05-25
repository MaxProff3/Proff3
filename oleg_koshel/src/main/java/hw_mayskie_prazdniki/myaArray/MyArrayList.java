package hw_mayskie_prazdniki.myaArray;

public class  MyArrayList<Q> implements Comparable<Q> {
	
	Q vector[];
	
	int free;
	
	 MyArrayList(){
		
		vector = (Q[])(new Object[10]);
		free = 10;	
	}
	
	 MyArrayList(int size){
		
		if (size==0); 
		
		
		this.vector = (Q[])(new Object[size]);
		
		free = size;
		
	}
	
	public int getFree(){
		
		return free;
		
	}
	
	public int size(){
		
		return vector.length-free;
		
	}
	
	public void add(Q k){
		
		if (free>=1){ 
			
			vector[vector.length-free] = k;
			
			free=free-1;
			
		} else {
			
			Q[] vectorExt = (Q[])(new Object[vector.length*3/2]);
			int i;
			
			for (i=0;i<vector.length;i++){
				
				vectorExt[i] = vector[i];
				
			}
			
			vectorExt[i]=k;
			
			free = vectorExt.length - vector.length-1;
			
			vector = vectorExt; 
			
		}
		
	
		
	}
	
	public Q get(int k){
		
		return vector[k-1];
		
	}
	
	public void remove(int k){
		
		Q vectorExt[];
		
		vectorExt = (Q[])(new Object[vector.length]);
		
		
		for (int i=0;i<vector.length;i++){
			
			if (i==k-1){continue;}
			
			else if (i>k-1) {
				
				vectorExt[i-1] = vector[i];
				
			}
			
			
			else vectorExt[i] = vector[i]; 
			
		}
		
		vector = vectorExt;
		
		free++;
	}
	
	public void sort(){
		
		for (int i = 0; i < vector.length-free; i++) {

	        Q min = (Q) vector[i];
	        int min_i = i; 

	        for (int j = i+1; j < vector.length-free; j++) {
	           
	            if ((boolean)vector[j].equals(min)) {
	                min = (Q) vector[j];
	                min_i = j;
	            }
	        }

	        if (i != min_i) {
	            Q tmp = (Q) vector[i];
	            vector[i] = vector[min_i];
	            vector[min_i] = tmp;
	        }
	     }
		
		
	}

	public int compareTo(Q o) {
		
		return this.toString().compareTo(o.toString());
		
	}


	public Q[] toArray(){
		
		Q[] arr = (Q[])(new Object[vector.length]);
		
		for (int i=0;i<vector.length;i++){
			
			if (vector[i]!=null){
				
				arr[i] = vector[i];
				
			}
			
		}
		
		return arr;
		
	}
	

}
