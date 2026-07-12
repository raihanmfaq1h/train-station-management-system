package cantikRahmi;

import shared.Passenger;

public class PriorityBoardingQueue {

    private class Node {

        Passenger passenger;
        int priority;
        Node next;

        Node(Passenger passenger, int priority) {
            this.passenger = passenger;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node front;
    private int size;

    public PriorityBoardingQueue() {
        front = null;
        size = 0;
    }

    // Method enqueue
   public void enqueue(Passenger passenger, int priority) {

    Node newNode = new Node(passenger, priority);

    if (front == null || priority < front.priority) {
        newNode.next = front;
        front = newNode;
    } else {

        Node current = front;
       
        while (current.next !=null && current.next.priority <= priority) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    size++;
    }

    // Method dequeueMax()
    public Passenger dequeueMax() {

    if (isEmpty()) {
        System.out.println("Antrian boarding kosong.");
        return null;
    }

    Passenger removedPassenger = front.passenger;
    front = front.next;
    size--;

    return removedPassenger;
    } 

    // Method peek()
    public Passenger peek() {
        if (isEmpty()) {
            System.out.println("Antrian boarding kosong.");
            return null;
        }
        return front.passenger;
    }

    // Method isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // Method Display Queue()
    public void display() {
        if  (isEmpty()) {
            System.out.println("Antrian boarding kosong");
            return;
        }
        Node current = front;
        System.out.println("===== PRORIRY BOARDING QUEUE =====");

        while (current != null) {

            System.out.println(
                "ID Penumpang :  " + current.passenger.getId());
            System.out.println(
                "Nama Penumpang : " + current.passenger.getName());
            System.out.println(
                    "Ticket Class : " + current.passenger.getTicketClass());
            System.out.println(
                "Priority : " + current.priority);
            System.out.println("------------------------------");

            current = current.next;
        }
    }
}
