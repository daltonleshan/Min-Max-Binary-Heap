public class minHeap {

	private int size;
	private int [] myArray;
	private int position;
  
	public minHeap(int s){
		size = s;
		myArray = new int [size+1];
		position = 0;
	}
	public void buildHeap(int [] array){
		if(array.length > 0){
			for(int i=0;i < myArray.length; i++){
				insert(myArray[i]);
			}
		}		
	}
	public void content(){
		for(int i = 1; i < myArray.length; i++){
			System.out.print(" " + myArray[i]);			
		}
		System.out.println("");
	}
	public void insert(int x){
		if(position==0){
			myArray[position+1] = x;
			position = 2;
		}else{
			myArray[position++] = x;
			heapUp();
		}
	}
	public void heapUp(){
		int pos = position-1;
		while(pos > 0 && myArray[pos/2] > myArray[pos]){
			int temp = myArray[pos];
			myArray[pos]=myArray[pos/2];
			myArray[pos/2] = temp;
			pos /= 2;
		}
	}
	public int findMin(){
		int min = myArray[1];
		myArray[1]=myArray[position-1];
		myArray[position-1]=0;
		position--;		
		heapDown(1);
		return min;
	}
	
	public void heapDown(int k){int a = myArray[k];
		int least =k;
		if(2*k<position && myArray[least]>myArray[2*k]){
			least = 2*k;
		}
		if(2*k+1<position && myArray[least]>myArray[2*k+1]){
			least = 2*k+1;
		}
		if(least!=k){
			swap(k,least);
			heapDown(least);
		}
				
	}
	public void swap(int a, int b){
		int temp = myArray[a];
		myArray[a] = myArray[b];
		myArray[b] = temp;
	}
	
	public static void main(String args[]){
		int array [] = {3,4,5,1,6,43,7,9,0};
		minHeap m = new minHeap(array.length);
		System.out.print("\nMin-Heap : ");
		m.createHeap(array);		
		m.content();
		System.out.print("\nExtract Min :");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + m.extractMin());
		}
		
	}
	
		
}
