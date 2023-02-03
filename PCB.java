
public class PCB {
   private int ID;
   private int priority;
   private int arrivalTime;
   private int CPUBurst;
   private int startTime=-1;
   private int terminateTime;
   private int remainder;


   PCB(int id, int priority, int arrivalTime, int CPUBurst){
      ID = id;
      this.priority = priority;
      this.arrivalTime = arrivalTime;
      this.CPUBurst = CPUBurst;
      remainder = CPUBurst;
   }
   
   //setters

   public void setStartTime(int startTime){this.startTime = startTime;}
   public void setTerminateTime(int terminateTime){this.terminateTime = terminateTime;}

   
   //getters
   public int getID(){
      return ID;}

   public int getPriority(){
      return priority;}
      
   public int getArrivalTime(){
      return arrivalTime;}
      
   public int getCPUBurst(){
      return CPUBurst;}
      
   public int getStartTime(){
      return startTime;}
      
   public int getTerminateTime(){
      return terminateTime;}
      
   public int getTurnAroundTime(){
      return terminateTime-arrivalTime;}
      
   public int getWaitingTime(){
      return terminateTime-arrivalTime-CPUBurst;}
      
   public int getResponseTime(){
      return startTime-arrivalTime;}
      
   public int getRemainder(){
      return remainder;}
      
   public void setRemainder(int t){
      remainder=t;}

   /*
   public int getAvgTurnAround(){return avgTurnAround;}
   public int getAvgWaitingTime(){return avgWaitingTime;}
   public int getAvgResponseTime(){return avgResponseTime;}
   */   //should be calculated in Schedule class
   
   public String display(){
      String str = "id: "+ID+"\npriority: "+priority+"\narrival: "+arrivalTime+"\nCPU Burst: "+CPUBurst+"\nStart time: "+startTime+"\nterminate time: "+terminateTime+"\nwait time: "+getWaitingTime()+"\nturn around time: "+getTurnAroundTime()+"\nresponse time: "+getResponseTime()+
      "\n\n***********************************\n";
   return str;
   }
 
}
