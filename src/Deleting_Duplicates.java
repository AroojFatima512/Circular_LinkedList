package Circular_LinkedList;

public class Deleting_Duplicates{

        static Node head;
        static Node tail;

        public void InsertAtEnd(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=newNode;
                tail=newNode;
                tail.next=head;
                return;
            }
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }

        public static void DelValue(int value){
            if(head==null){
                System.out.println("no list exists");
                return;
            }

            while (head.data == value){
                head = head.next;
                tail.next = head;
            }

            Node prevNode=head;
            Node currentNode=head.next;

            while(currentNode != head){
                if(currentNode.data == value){
                    prevNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
                else {
                    prevNode = prevNode.next;
                    currentNode = currentNode.next;
                }
            }
        }

        public static void Display(){
            Node currentNode=head;
            if(head==null){
                System.out.println("List is empty");
                return;
            }

            do{
                System.out.println(currentNode.data+" ");
                currentNode=currentNode.next;
            }while(currentNode!=head);

        }

        public static void main(String[] args) {
            Deleting_Duplicates linked = new Deleting_Duplicates();
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(12);
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(23);
            linked.InsertAtEnd(3);
            linked.InsertAtEnd(3);
            DelValue(3);
            Display();
        }

    }

