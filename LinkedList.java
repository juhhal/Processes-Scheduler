class LinkedList{

Node head;
Node tail;

LinkedList(){
head = tail = null;
}

void add(Node n){
if(head==null)
head=tail=n;
else{
tail.setNext(n);
tail = n;}

}

Node getHead(){
Node tmp = head;
head = head.getNext();
return tmp;
}

boolean isSame(PCB p){
if(head==null)return false;
return tail.getData()==p;
}

boolean empty(){
return head==null;
}

}
