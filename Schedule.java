import java.io.*;
public class Schedule {
   private double avgTurnAround;
   private double avgWaitingTime;
   private double avgResponseTime;
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

      Execute();
      print(pArr);    
   }
   
   /////////////////////////
   public void Execute(){
      PCB current = null;
      PCB tmp = null;
      int cpuBurst = 0;

      while(!ready.empty()){
      
         if(current!= null){
         
            tmp = ready.check(current, Time);
         
            if(tmp != null){
               Time++;//CS
               current.setArrivalTime(Time);
               current.Remainder=cpuBurst;
               PQNode node = new PQNode(current,current.getPriority());
               ready.enqueue(node);
               current=tmp;
               cpuBurst = current.Remainder;
               
            }
         }
      
         if(current==null){
         
            current = ready.nextP(Time);
            if(current==null){
               Time++;
               continue;
            }
            else
               cpuBurst = current.Remainder;
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
         
            current.setTerminationTime(Time);
            Time++;//CS
            current = null;
         }
      }
   
      while(current!=null && current.Remainder!=0){
         
         cpuBurst--;
         Time++;
         if(cpuBurst==0){
            current.setTerminationTime(Time);
         
            current = null;
            Time--;
         }
      }
      
   }
    
   public void print(PCB[] p){ 
      double countAT=0;//avgTurnAround
      double countAW=0;//avgWaitingTime
      double countAR=0;//avgResponseTime       
      try {
         File FF = new File ("Reprot.txt");
         FileOutputStream OSF = new FileOutputStream(FF);
         PrintStream write = new PrintStream(OSF);
         System.out.println("Report of detailed information about each process in the system:");
         write.print("Report of detailed information about each process in the system:\n");         
            
         for (int i = 0; i < p.length; i++) {
            //Display processes along with all details
            System.out.printf("Processes " + " Priority " + " Arrival time" + " CPU burst " + " Start time " + " Termination time " + " TurnAround time" + " Waiting time " + " Response time\n");
            write.print("Processes " + " Priority " + " Arrival time" + " CPU burst " + " Start time " + " Termination time " + " TurnAround time"+ "Waiting time " + " Response time\n");
            System.out.print("-----------------------------------------------------------------------------------------------------------------------" +"\n");
            write.print("-----------------------------------------------------------------------------------------------------------------------" +"\n");
         
            if(p.length > 0) {
               if(p[i]!=null) {
                  System.out.printf("    %s ", p[i].getProcessID());
                  write.printf("    %s ",p[i].getProcessID() );
                  System.out.printf("        %d ", p[i].getPriority());
                  write.printf("        %d ", p[i].getPriority());
                  System.out.printf("           %d", p[i].getRealArrival());
                  write.printf("           %d", p[i].getRealArrival());
                  System.out.printf("       %d", p[i].getCPUburst());
                  write.printf("       %d", p[i].getCPUburst());
                  System.out.printf("              %d", p[i].getStartTime());
                  write.printf("              %d", p[i].getStartTime());
                  System.out.printf("              %d", p[i].getTerminationTime());
                  write.printf("              %d", p[i].getTerminationTime());
                  System.out.printf("              %d", p[i].getTurnAroundTime());
                  write.printf("              %d", p[i].getTurnAroundTime());
                  System.out.printf("              %d", p[i].getWaitingTime());
                  write.printf("              %d", p[i].getWaitingTime());
                  System.out.printf("              %d", p[i].getResponsetime());
                  write.printf("              %d", p[i].getResponsetime());
                  System.out.print("\n" + "-----------------------------------------------------------------------------------------------------------------------" + "\n");
                  write.print("\n" + "-----------------------------------------------------------------------------------------------------------------------" + "\n");
               }//end inner if
            }//end outter if
            else {
               System.out.print("The Queues are EMPTY" +"\n");
               write.print ("The Queues are EMPTY" +"\n");   
            }//end else         
         }//end for

         for (int m = 0; m < p.length; m++){
            countAT += p[m].getTurnAroundTime();
            countAW += p[m].getWaitingTime();
            countAR += p[m].getResponsetime();
         }

         avgTurnAround = countAT / p.length ;
         avgWaitingTime = countAW / p.length ;
         avgResponseTime = countAR / p.length ;
         System.out.println("The Average of Ture Around Time = " + avgTurnAround);
         write.printf("The Average of Ture Around Time = %.2f \n", avgTurnAround);
         System.out.println("The Average of Waiting Time = " + avgWaitingTime);
         write.printf("The Average of Waiting Time = %.2f\n", avgWaitingTime);
         System.out.println("The Average of Response Time = " + avgResponseTime);
         write.printf("The Average of Response Time = %.2f", avgResponseTime);
         
         System.out.println("\n\n\nThe scheduling order of the processes:");
         write.print("\n\n\nThe scheduling order of the processes:");
         String str="\n\n\n[ "+account.getHead().getData().getProcessID();
    
         while(!account.empty()){
            str+=(" | CS | "+account.getHead().getData().getProcessID());
      
         }
         str+=" ]\n";
         System.out.print(str);
         write.println(str);
         write.close();
      }catch(IOException e) {
         System.out.println("An error occurred");
         e.printStackTrace();
      }
   }//end try
}//end Print()
