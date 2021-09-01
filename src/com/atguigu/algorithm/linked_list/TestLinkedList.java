package com.atguigu.algorithm.linked_list;

public class TestLinkedList {
    public static void main(String[] args) {
        //构建一个链表,把所有节点创建出来，然后链接起来
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(66);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        printList(listNode1);
    }

    public static void printList(ListNode head){
        ListNode curNode = head;
        while (curNode!=null){
            System.out.print(curNode.val+"-->");
            curNode = curNode.next;
        }
        System.out.println("null");
    }
}
