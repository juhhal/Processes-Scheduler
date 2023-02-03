import java.io.*;
public class Schedule {
    
   private int avgTurnAround;
   private int avgWaitingTime;
   private int avgResponseTime;
   static int Time;
   LinkedPQ ready;
   LinkedList account;
//////////////////////////
   Schedule(PCB[] pArr){
      Time=0;
      account = new LinkedList();
      ready = new LinkedPQ();
      PQNode node ;
   
      for(int i=0; i<pArr.length;i++){
         node= new PQNode(pArr[i], pArr[i].getPriority());
         ready.enqueue(node);
      
      }
      
      
    //  Execute();
     // print(pArr);
    
   }
   
   /////////////////////////
   public void Execute(){
      PCB current = null;
      PCB tmp = null;
      int cpuBurst = 0;
   
   
   
      while(!ready.empty()){
      
         if(current!= null && cpuBurst-1 != 0){
         
            tmp = ready.check(current, Time);
         
            if(tmp != null){
            
               current.setRemainder(cpuBurst);
               PQNode node = new PQNode(current,current.getPriority());
               ready.enqueueAgain(node);
               current=tmp;
               cpuBurst = current.getRemainder();
               Time++;//CS
            }
         }
      
         if(current==null){
         
            current = ready.nextP(Time);
            if(current==null){
               Time++;
               continue;
            }
            else
               cpuBurst = current.getRemainder();
         }
      
         if(current.getStartTime() ==-1){
         
            current.setStartTime(Time);
         }
         if(!account.isSame(current)){
         
            Node n = new Node(current);
            account.add(n);}
         
         cpuBurst--;
         Time++;
         if(cpuBurst==0){
         
            current.setTerminateTime(Time);
            Time++;//CS
            current = null;
         }
      }
   
      while(current!=null && current.getRemainder()!=0){
         
         cpuBurst--;
         Time++;
         if(cpuBurst==0){
            current.setTerminateTime(Time);
         
            current = null;
            Time--;
         }
      }
      
   }
    
   public void print(PCB[] p){
   
      try{ 
      
      
         File f = new File("processes");
         FileOutputStream fos = new FileOutputStream( f );
         PrintWriter pw = new PrintWriter ( fos );
      
         for(int i=0;i<p.length;i++){
            avgTurnAround += p[i].getTurnAroundTime();
            avgWaitingTime += p[i].getWaitingTime();
            avgResponseTime += p[i].getResponseTime();
            pw.println( p[i].display());
         }
         pw.println("Average turn around time: "+avgTurnAround/p.length+"\nAverage waiting time: "+avgWaitingTime/p.length+"\nAverage response time: "+avgResponseTime/p.length+"\n\n*******************************\n");
     
      
         pw.print("[ ");
         pw.print(account.getHead().getData().getID());
         while(!account.empty()){
            pw.print(" | CS | ");
            pw.print(account.getHead().getData().getID());}
       
         pw.println(" ]\n\n**********************************************\n");
       
      
         pw.close();
      } catch(FileNotFoundException e)
      {
         System.out.println("An error occured while handling the file.");
      }
   
   
    
   }

}
