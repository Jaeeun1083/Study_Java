package com.livestudy.week4.structure;

import javax.validation.constraints.NotNull;

public class LinkedList {

    public ListNode add(@NotNull ListNode head, ListNode nodeToAdd, int position){
        checkPositionIndex(position); // 넘겨받은 position이 음수값인지 확인.
        ListNode nextNode = head;     // head를 기준으로 순회하기 위해 저장

        for (int loop = 0; loop < position-1; loop++) { // position 전 node 찾기
            nextNode = nextNode.next;
        }
        if (nextNode.next == null) {
            nodeToAdd.next = nextNode;
            head.next = nodeToAdd;
            return nodeToAdd;
        }
        ListNode tmp = nextNode.next; // position에 해당하는 노드를 tmp에 담음
        nextNode.next = nodeToAdd;    // position 전 node의 next에 add할 node 담음
        nodeToAdd.next = tmp;         // 원래 position에 있던 노드를 add할 node 뒤로 옮김

        return nodeToAdd;
    }

    public ListNode remove(@NotNull ListNode head, int positionToRemove){
        checkPositionIndex(positionToRemove);
        ListNode nextNode = head;

        for (int loop = 0; loop < positionToRemove-1; loop++) {
            nextNode = nextNode.next;
        }
        // nextNode = 지울 노드의 전 노드, tmp = 지울 노드
        if (nextNode.next == null) throw new IndexOutOfBoundsException();
        ListNode tmp = nextNode.next;
        nextNode.next = tmp.next; // 전 노드의 next에 지울 노드의 next를 담음.
        tmp = null;               // 지울 노드를 null로 수정

        return nextNode;
    }

    public boolean contains(@NotNull ListNode head, ListNode nodeToCheck) {
        ListNode nextNode = head;
        if(head.next == nodeToCheck) return true;
        while (nextNode != null) {
            if (head.data == nodeToCheck.data){
                return true;
            }
            nextNode = nextNode.next;
        }
        return false;
    }

    private void checkPositionIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException(index);
    }

    public static class ListNode { // LinkedList 호출 시
        private int data;
        private ListNode next; //다음 데이터의 주소값

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode getNext() {
            return next;
        }
    }
}
