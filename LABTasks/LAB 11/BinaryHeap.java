public class BinaryHeap{

    private int[]array;
    private int size;
    private int i;

    BinaryHeap(int size){
        this.size = size;
        this.array = new int[size];
        this.i = -1;
    }
    private int leftChild(int i){
        if(2*i + 1 >= size){
            return Integer.MAX_VALUE;
        }
        return array[2*i + 1];
    }
    private int rightChild(int i){
        if(2*i + 2 >= size){
            return Integer.MAX_VALUE;
        }
        return array[2*i + 2];
    }
    private int parent(int i){
        if(i == -1){
            return Integer.MIN_VALUE;
        }
        return array[(i-1)/2];
    }
    private int leftChildIndex(int i){
        if(2*i + 1 >= size){
            return -1;
        }
        return 2*i + 1;
    }
    private int rightChildIndex(int i){
        if(2*i + 2 >= size){
            return -1;
        }
        return 2*i + 2;
    }
    private int parentIndex(int i){
        if(i == -1){
            return -1;
        }
        return (i-1)/2;
    }
    public void add(int data){
        if(i == size - 1){
            System.out.println("Heap is full");
            return;
        }
        array[++i] = data;
        
        heapifyUp(i);

    }
    private void heapifyUp(int i){
        int temp;
        if(i != 0 && array[i] < array[parentIndex(i)]){
            temp = array[i];
            array[i] = array[parentIndex(i)];
            array[parentIndex(i)] = temp;
            heapifyUp(parentIndex(i));
        }
    }
    public int extractMin(){
        if(i == -1){
            System.out.println("Heap is empty");
            return Integer.MIN_VALUE;
        }
        int min = array[0];
        array[0] = array[i--];
        
        heapifyDown(0);
        return min;
    }
    private void heapifyDown(int i){
        int temp;
        if(leftChildIndex(i) != -1 && array[i] > array[leftChildIndex(i)] || rightChildIndex(i) != -1 && array[i] > array[rightChildIndex(i)]){
            if(rightChildIndex(i) == -1 || array[leftChildIndex(i)] < array[rightChildIndex(i)]){
                temp = array[i];
                array[i] = array[leftChildIndex(i)];
                array[leftChildIndex(i)] = temp;
                heapifyDown(2*i + 1);
            }
            else{
                temp = array[i];
                array[i] = array[rightChildIndex(i)];
                array[2*i + 2] = temp;
                heapifyDown(2*i + 2);
            }
        }
    }
    public boolean isEmpty(){
        return i == -1;
    }
    public int getMin(){
        return array[0];
    }
    public void printHeap(){
        for(int j = 0; j <= i; j++){
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }
    public String toString(){
        String s = "";
        for(int j = 0; j <= i; j++){
            s += array[j] + " ";
        }
        return s;
    }

        

    
}