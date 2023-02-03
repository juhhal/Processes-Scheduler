import java.util.*;

public class Main{
   static PCB PArr[];

   public static void main(String[] args){
   
      while(true){
         System.out.println("Choose one of the following function by entering its number:\n1- Enter process' information\n2- report for each process\n3- Exit");
         Scanner input = new Scanner(System.in);
         int num =0;
        
         do{
            try{
               num = input.nextInt();
               if(num<1 || num>3)
                  throw new Exception();
            } catch(Exception e){
            
               System.out.println("wrong input please re-enter function number");
            }
            input.nextLine();
         
         }while(num<1 || num>3);
         
      
         switch(num){
            case 1:
               System.out.println("enter number of processes:");
               int noOfProcess=0;
               do{
                  try{
                     noOfProcess = input.nextInt();
                     if(noOfProcess==0)
                        break;
                  }catch(Exception e){
                     System.out.println("wrong input please re-enter the number of processes:");}
                  input.nextLine();
               }while(noOfProcess<=0);
               
               PArr = new PCB[noOfProcess];
               PCB p;
               
               for(int i=0; i<noOfProcess;i++){
                  System.out.printf("enter %d process priority between 1-5:\n", i+1);
                  int pty = 0;
                  do{
                     try{
                        pty = input.nextInt();
                        if(pty<1 || pty>5)
                           throw new Exception();
                     } catch(Exception e){
                     
                        System.out.println("wrong input please re-enter priority number between 1-5:");
                     }
                     input.nextLine();
                  
                  }while(pty<1 || pty>5);
                  
                  
                  System.out.printf("enter %d process Arrival time in ms\n", i+1);
                  int arrival = -1;
                  do{
                     try{
                        arrival = input.nextInt();
                        if(arrival<0)
                           throw new Exception();
                     }catch(Exception e){
                        System.out.println("wrong input please re-enter Arrival time in ms:");}
                     input.nextLine();
                  }while(arrival<0);
                  
                  System.out.printf("enter %d process CPU Burst in ms\n", i+1);
                  int cpuBurst = 0;
                  do{
                     try{
                        cpuBurst = input.nextInt();
                        if(cpuBurst<=0)
                           throw new Exception();
                     }catch(Exception e){
                        System.out.println("wrong input please re-enter Arrival time in ms:");}
                     input.nextLine();
                  }while(cpuBurst<=0);
                    
                  p = new PCB(i+1, pty, arrival, cpuBurst);
                    
                  PArr[i] = p;
                    
                  System.out.println("\n*********************\n");
               
               }
            
               break;
            
            case 2:
            Schedule s;
               if (PArr!=null)
                   s = new Schedule(PArr);
                  else
                  System.out.println("no processes available");
            
               break;
            
            case 3: System.exit(0);
         
         } 
      }
   }
}