
public class PQNode {

    public PCB data;
    public PQNode next;
    public int priority;

    public PQNode() {
        next = null;
    }

    public PQNode(PCB val, int p) {
        data = val;
        priority = p;
    }
    
    public void setData(PCB data){this.data = data;}
    public void setNext(PQNode n){next = n;}
    public PCB getData(){return data;}
    public PQNode getNext(){return next;}
}