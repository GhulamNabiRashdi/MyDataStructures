
    public interface List {

        public boolean isEmpty();
        
        public int size();
        
        public void add(Object item);
       
        public void add(int index, Object item);
       
      
        public void remove(int index);
       
        public void remove(Object item);

        public List duplicate();

        public List duplicateReversed();

    }
    class LLInterfaceImplementation implements List {

        private class Node{
            Object data;
            Node next;

            public Node (Object data){
                this.data = data;
                this.next = null;
            }
        }

        private Node head;
        private int size;

       
        public boolean isEmpty() {
            return head == null;
        }

     
        public int size() {
           return size;
        }

  
        public void add(Object item) {
            Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }
        

        public void add(int index, Object item) {

            Node newNode = new Node(item);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
    
            }
        }


        public void remove(int index) {
            
        }

 
        public void remove(Object item) {
        head = head.next;
        size--;
        
        }

       
        public List duplicate() {
        
        }

        
        public List duplicateReversed() {
          
        }

    }
