class LinkedPQ{

   private int size;
   private PQNode head;


   public LinkedPQ(){
      head = null;
      size = 0;
   }


   public int length(){
      return size;
   }


   public boolean full(){
      return false;
   }


   public void enqueue(PQNode tmp){//---------------------------\\\\\\\\\\\\
      if((size==0)||(tmp.getData().getPriority()<head.priority)){
         tmp.next = head;
         head = tmp;
      }
      else {
         PQNode p = head;
         PQNode q = null;
         while((p != null)&&(tmp.getData().getPriority()>p.priority)){
            q=p;
            p=p.next;}
         
         while(p!= null && tmp.getData().getPriority()==p.priority && p.getData().getArrivalTime()<=tmp.getData().getArrivalTime()){
            q=p;
            p=p.next;
         }
         tmp.next = p;
         if(q!=null)
            q.setNext(tmp);
         else
            head = tmp;
      
      }
      size++;

   
   
   }
   public void enqueueAgain(PQNode tmp){//---------------------------\\\\\\\\\\\\
      if((size==0)||(tmp.getData().getPriority()<head.priority)){
         tmp.next = head;
         head = tmp;
      }
      else {
         PQNode p = head;
         PQNode q = null;
         while((p != null)&&(tmp.getData().getPriority()>p.priority)){
            q=p;
            p=p.next;}
         
         while(p!= null && tmp.getData().getPriority()==p.priority && p.getData().getArrivalTime()<tmp.getData().getArrivalTime()){
            q=p;
            p=p.next;}
         tmp.next = p;
         if(q!=null)
            q.setNext(tmp);
         else
            head = tmp;
      
      }
      size++;

   
   
   }

   public PCB check(PCB p, int t){//---------------------------

      PQNode higherP = head;
      while(higherP!=null && p.getPriority() > higherP.getData().getPriority()){

         if(t>= higherP.getData().getArrivalTime()){

            return serve(higherP);
         }
         higherP = higherP.getNext();

      }
      return null;
   
   }
   

   
   public PCB nextP(int t){//---------------------------\\\\\\\\\\\\\\\
      PQNode nxt = head;
      while(nxt!=null){
         if(t>= nxt.getData().getArrivalTime()){
            
            return serve(nxt);
         }
         nxt =  nxt.getNext();
      }
      return null;
   }
   
   
   
   public PCB serve(PQNode N){
      if(N==head){
         head = head.getNext();
      }
      else{
         PQNode tmp = head;
         while(tmp.getNext()!= N)
            tmp = tmp.getNext();
         tmp.setNext(N.getNext());
      
      }
      size--;
  
      return N.getData();
   
   }


   public boolean empty(){
      return head==null;
   
   }

   public void display(){
      PQNode tmp = head;
      for(int i=0; i<size;i++){
      
         System.out.println(size);
         System.out.println(tmp.getData().getID());
         tmp = tmp.getNext();
      }
   }

}

