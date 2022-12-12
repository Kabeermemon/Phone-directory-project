//Umair Ahmed
//Abdul Kabeer
//Irfan Anwar

//Stack using Linked List
//ArrayList

import java.util.*;
import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Projects {
    ArrayList<String> list = new ArrayList();
    Node Recent = null;

    // 1:- Push method
    public Node Push(String data, Node node) {
        Node newnode = new Node(data);

        if (node == null) {
            node = newnode;
            node.next = null;
        } else {
            newnode.next = node;
            node = newnode;
        }
        return node;
    }

    // 2:- Search:
    // For Serching the contact Number/Name:-
    void search(String data, Node head) {

        Node mover = head;
        boolean check = false;
        int counter = 1;

        System.out.println("Suggestions: ");
        while (mover != null) {

            if ((mover.data).contains(data)) {
                System.out.println(counter + ": " + mover.data);
                check = true;
                counter++;
                list.add(mover.data);

            }
            mover = mover.next;
        }

        if (check == false) {
            System.out.println("NO Results: ");
        } else {
            System.out.println("if you want to call press Number");

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num <= counter) {
                Call(num - 1);
            } else {
                System.out.println("Wrong Number: ");
            }
        }
    }

    // 3:- call Method:
    void Call(int num) {
        System.out.println("Called: " + list.get(num));
        Recent = Push(list.get(num), this.Recent);
        list.clear();
        System.out.println("\n");
    }

    // 4:- For watching Recent call:
    void Recent_Calls() {
        Node mover = this.Recent;

        if (mover != null) {
            int counter = 1;
            while (mover != null) {
                System.out.println(counter + ": " + mover.data);
                mover = mover.next;
                counter++;
            }
            System.out.println("\n");
        } else {
            System.out.println("No Calls Yet:\n");
        }
    }

    // 5: -Adding contact in the list:
    Node Add(String str, Node node) {
        node = Push(str, node);
        System.out.println("Contact: " + str + " Saved\n");
        return node;
    }

    void Triverse(Node node) {
        Node mover = node;
        System.out.println("Showing list of Contact: ");
        while (mover != null) {
            System.out.println(mover.data);
            mover = mover.next;
        }
        System.out.println("\n");
    }

    public static void main(String args[]) {
        Node head = null;
        Projects obj = new Projects();

        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        int num;

        head = obj.Push("Ali Ahmed", head);
        head = obj.Push("Ahmed Ali", head);
        head = obj.Push("Ali khan", head);
        head = obj.Push("Ali haider", head);
        head = obj.Push("Ali jee", head);
        head = obj.Push("Ali usman", head);
        head = obj.Push("Ali", head);

        // obj.Triverse(head);

        do {
            System.out.println(
                    "\n1: Search: \n2: Recent Calls: \n3: Add to Contacts: \n4: All Contacts:\nEnter Number: ");
            num = in.nextInt();

            if (num == 1) {
                System.out.println("Search Text: ");
                String str = sc.next();
                obj.search(str, head);

            }

            else if (num == 2) {
                obj.Recent_Calls();
            }

            else if (num == 3) {
                System.out.println("Write name of Contact: ");
                String str = sc.nextLine();
                head = obj.Add(str, head);
            }

            else if (num == 4) {
                obj.Triverse(head);
            }

        } while (num != 0);
    }
}