package Circular_LinkedList;

public class Circular_LinkedList {
    Node head;
    Node tail;
    int size=0;
    void add(int data){
        Node node = new Node(data);
        if(head == null && tail == null){
            head = tail = node;
            size++;
            return;
        }
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    void addAtSpecificPosition(int data, int loc){
        Node node = new Node(data);
        if(head == null && tail == null){
            head = tail = node;
            return;
        }
        if (loc == 1){
            node.next = head;
            head = node;
            tail.next = head;
            size++;
            return;
        }
        Node cur = head;
        for(int i=1; i<loc-1; i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
//        Node prev = null;
//        Node cur = head;
//        int count = 0;
//        while (cur.next != head){
//            count++;
//            if(count == loc){
//                prev.next = node;
//                node.next = cur;
//                size++;
//            }
//            prev = cur;
//            cur = cur.next;
//        }
//        if(count < loc){
//            System.out.println("Location out of bound. Cannot add as the size is: " + size);
//        }
    }

    void delete(){
        if(head == null && tail == null){
            return;
        }
        head = head.next;
        tail.next = head;
        size--;
    }

    void deleteAtSpecificPosition(int loc){
        int count = 0;
        Node prev = null;
        Node cur = head;

        if (loc == 1){
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        for(int i=0; i<loc-1; i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        size--;


//        do{
//            count++;
//            if(count == loc){
//              prev.next = cur.next;
//            size--;
//            }
//                prev = cur;
//                cur = cur.next;
//        } while (cur != head);

//        if(count < loc){
//            System.out.println("Location out of bound. Cannot delete as the size is: " + size);
//        }
    }

    void deleteByData(int data){
        if (head.data == data){
            head = head.next;
            size--;
            return;
        }
        Node prev = null;
        Node cur = head;
        while (cur.next != head){
            if (cur.data == data){
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    void search(int val){
        Node cur = head;
        int index = 0;

        do {
            index++;
            if(cur.data == val){
                System.out.println("Value " +cur.data +" found at: " +index);
                return;
            }
            cur = cur.next;
        }while (cur != head);

            System.out.println("Value not Found");

    }

    public void DeletingDuplicates(int value){
        if(head == null){
            System.out.println("no list exists");
            return;
        }

        while (head.data == value){
            head = head.next;
            tail.next = head;
        }

        Node prev = head;
        Node cur = head.next;

        while(cur != head){
            if(cur.data == value){
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = prev.next;
                cur = cur.next;
            }
        }
    }

    void display(){
        if(head == null && tail == null){
            System.out.println("List is empty");
            return;
        }
        Node cur = head;
        do {
            System.out.print(cur.data+ " -> ");
            cur = cur.next;
        } while (cur != head);
        System.out.println();
    }

    public static void main(String[] args) {
         Circular_LinkedList circular = new Circular_LinkedList();
         circular.add(1);
         circular.add(2);
         circular.add(3);
         circular.add(4);
         circular.display();

         circular.addAtSpecificPosition(7, 3);
         circular.display();

//         circular.delete();
//         circular.display();
//
//         System.out.println(circular.size);
         circular.deleteAtSpecificPosition(1);
         circular.display();
//
         circular.search(4);
    }
}
