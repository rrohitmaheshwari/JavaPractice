package codingQuestions;

import org.w3c.dom.Node;

import java.util.*;

public class robloxLinkedListBinary {

    public static void main(String[] args) {
        SinglyLinkedListNode input = new SinglyLinkedListNode(1);
        push(1, input);
//        push(0, input);
//        push(0, input);
//        push(1, input);
//        push(1, input);
        System.out.println(getNumber(input));

    }

    public static void push(int new_data, SinglyLinkedListNode input) {

        while (input.next != null) {
            input = input.next;
        }
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(new_data);

        input.next = new_node;

        new_node.next = null;
    }

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int d) {
            data = d;
            next = null;
        }


    }

    public static long getNumber(SinglyLinkedListNode binary) {
        long res = 0;

        while (binary != null) {
            res = (res << 1) + binary.data;
            binary = binary.next;
        }

        return res;
    }


}
