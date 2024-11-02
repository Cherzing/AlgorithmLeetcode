package cn.cherzing.test;

import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/10/30 0030 21:07
 * @description LinkedList
 */
public class TestLinkedList {
    @Test
    public void testLinkedList(){
        LinkedList list = new LinkedList();

        // 插入元素
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        // 打印链表
        list.printList(); // 输出: 1 2 3 4

        // 查找元素
        ListNode node = list.find(3);
        if (node != null) {
            System.out.println("找到元素: " + node.val); // 输出: 找到元素: 3
        } else {
            System.out.println("未找到元素");
        }

        // 删除元素
        list.delete(3);
        list.printList(); // 输出: 1 2 4

//        // 更新元素
//        list.update(2, 5);
//        list.printList(); // 输出: 1 5 4
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class LinkedList {
    ListNode head;

    public LinkedList() {
        head = null;
    }

    // 查找
    public ListNode find(int value) {
        ListNode current = head;
        while (current != null) {
            if (current.val == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // 插入
    public void insert(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // 删除
    public void delete(int value) {
        if (head == null) {
            return;
        }
        if (head.val == value) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // 更新
    public void update(int oldValue, int newValue) {
        ListNode node = find(oldValue);
        if (node != null) {
            node.val = newValue;
        }
    }

    // 打印链表
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

