/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearraydemo;

/**
 *
 * @author 174181B
 */
public class QueueArrayDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
         int n = in .nextInt();
        in.close();
        QueueArray x = new QueueArray(n);
        x.Display();
        x.Enqueue(7);
        x.Enqueue(3);
        x.Enqueue(9);
        x.Enqueue(1);
        x.Enqueue(2);
        x.Enqueue(8);
        x.Enqueue(5);
        x.Display();
        try {
            x.Dequeue();
            x.Dequeue();
            x.Dequeue();
            x.Display();
            x.Dequeue();
            x.Display();
            x.Enqueue(5);
            x.Display();
            int peekValue = x.peek();
            System.out.println("peek =" + peekValue);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

class QueueArray {

    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueArray(int s) {
        this.queArray = new int[s];
        this.maxSize = s;
        this.nItems = 0;
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return this.nItems == 0;
    }

    public boolean isFull() {
        return this.maxSize == this.nItems;
    }
//    if(this.maxSize==this.nItems){
//            return true;
//        }
//        else{
//            return false;
//        }

    public int size() {
        return this.nItems;
    }

    public void Enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. It  cannot insert");
            return;
        }

        if (this.rear == this.maxSize - 1) {
            this.rear = 0;
        } else {
            this.rear++;
        }
        this.queArray[rear] = value;
        this.nItems++;
        System.out.println(value + " Inserted");

    }

    public int Dequeue() throws Exception {
        //not allowed to remove middle elements. only frount element.
        // when return typ is void, do not need exception 
        if (isEmpty()) {
            throw new Exception("Queue is empty cannot remove.");
        }
        int temp = this.queArray[front];
        if (this.front == this.maxSize - 1) {
            this.front = 0;
        } else {
            this.front++;
        }
        this.nItems--;
        return temp;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty. cannot get peek.");
        }
        return this.queArray[this.front];
    }

    public void Display() {
        if (isEmpty()) {
            System.out.println("Queue is empty nothing to print.");
            return;
        }
        int i = this.front;
        while (i != this.rear) {
            System.out.print(queArray[i] + " ");
//            if(i==this.rear){
//                break; 
//            }
            if (i == this.maxSize - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        System.out.print(queArray[rear] + " ");
        System.out.println(" ");

    }

}
