class Node{
private PCB data;
private Node next;

Node(PCB p){
data = p;
next = null;
}

PCB getData(){
return data;
}
 Node getNext(){
 return next;
 }
 
 void setNext(Node n){
 next = n;
 }
 
}