package com.livestudy.week4.structure;


import org.junit.jupiter.api.*;

import static com.livestudy.week4.structure.LinkedList.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Nested
    @DisplayName("add 메서드는")
    class addTesst {

        @Nested
        @DisplayName("잘못된 position이 주어졌다면")
        class Context_with_invalid_position {
            final ListNode head = new ListNode(0);
            final int FIRST_NODE_VALUE = 10;
            final int INVALID_POSITION_INDEX = -1;

            @Test
            @DisplayName("IndexOutOfBoundsException 처리된다.")
            void it_returns_null() {
                LinkedList linkedList = new LinkedList();
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    linkedList.add(head, new ListNode(FIRST_NODE_VALUE), INVALID_POSITION_INDEX);
                });
            }
        }

        @Nested
        @DisplayName("유효한 position이 주어졌다면")
        class Context_with_valid_position {

            @Nested
            @DisplayName("position이 1인 경우")
            class Sub_context_with_front {
                final ListNode head = new ListNode(0);
                final int FIRST_NODE_VALUE = 3;
                final int FIRST_POSITION_INDEX = 1;

                @Test
                @DisplayName("리턴값이 head.next와 같다")
                void it_returns_list_node_same_head() {
                    LinkedList linkedList = new LinkedList();
                    ListNode frontNode = linkedList.add(head, new ListNode(FIRST_NODE_VALUE), FIRST_POSITION_INDEX);
                    ListNode getfirstNode = head.getNext();
                    assertEquals(frontNode, getfirstNode);

                }
            }

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            @DisplayName("첫번째 노드와 두번째 노드 사이에 넣을 경우")
            class Sub_context_with_between_first_second {
                final int FIRST_NODE_VALUE = 3;
                final int SECOND_NODE_VALUE = 1;
                final int BETWEEN_NODE_VALUE = 10;
                final int FIRST_POSITION_INDEX = 1;
                final int SECOND_POSITION_INDEX = 2;

                LinkedList linkedList;
                ListNode first, second, between, head;

                @BeforeAll
                void prepare_add_test() {
                    linkedList = new LinkedList();
                    head = new ListNode(1);
                    first = linkedList.add(head, new ListNode(FIRST_NODE_VALUE), FIRST_POSITION_INDEX);
                    second = linkedList.add(head, new ListNode(SECOND_NODE_VALUE), SECOND_POSITION_INDEX);
                    between = linkedList.add(head, new ListNode(BETWEEN_NODE_VALUE), SECOND_POSITION_INDEX);
                }

                @Test
                @DisplayName("첫번째 노드의 다음 노드에 들어가게 된다.")
                void it_returns_same_head_next() {
                    assertAll(
                            () -> assertEquals(head.getNext(), first),
                            () -> assertNotEquals(head.getNext(), second),
                            () -> assertEquals(first.getNext(), between)
                    );
                }
            }
        }
    }

    @Nested
    @DisplayName("remove 메서드는")
    class removeTest {

        @Nested
        @DisplayName("잘못된 position이 주어졌다면")
        class Context_with_invalid_position {
            final ListNode head = new ListNode(0);
            final int FIRST_NODE_VALUE = 10;
            final int INVALID_POSITION_INDEX = -1;
            final int OUTBOUND_POSITION_INDEX = 3;

            @Test
            @DisplayName("IndexOutOfBoundsException 처리된다.")
            void it_returns_null() {
                LinkedList linkedList = new LinkedList();
                assertThrows(IndexOutOfBoundsException.class, () -> {
                    linkedList.add(head, new ListNode(FIRST_NODE_VALUE), INVALID_POSITION_INDEX);
                });
            }
        }

        @Nested
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @DisplayName("유효한 position이 주여졌다면")
        class Context_with_valid_position {
            final ListNode head = new ListNode(0);
            final int FIRST_NODE_VALUE = 3;
            final int SECOND_NODE_VALUE = 1;
            final int FIRST_POSITION_INDEX = 1;
            final int SECOND_POSITION_INDEX = 2;

            @Nested
            @TestInstance(TestInstance.Lifecycle.PER_CLASS)
            @DisplayName("두개의 노드가 존재하고 첫번째 노드를 삭제했을 경우")
            class Sub_context_with_front_remove {
                ListNode first, second, removed;

                @BeforeAll
                void prepare_remove_front_node() {
                    LinkedList linkedList = new LinkedList();
                    first = linkedList.add(head, new ListNode(FIRST_NODE_VALUE),FIRST_POSITION_INDEX);
                    second = linkedList.add(head, new ListNode(SECOND_NODE_VALUE),SECOND_POSITION_INDEX);
                    removed = linkedList.remove(head,FIRST_POSITION_INDEX);
                }

                @Test
                @DisplayName("리턴 값은 지운 노드의 이전 노드이다.")
                void it_returns_same_first_add_node() {
                    assertEquals(head, removed);
                }

                @Test
                @DisplayName("지운 노드의 다음 노드는 두번째 삽입한 노드이다")
                void it_second_add_node_same_head() {
                    assertEquals(head.getNext(), second);
                }
            }
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("contains 메서드는")
    class containsTest {
        final ListNode head = new ListNode(0);
        final int FIRST_NODE_VALUE = 3;
        final int SECOND_NODE_VALUE = 1;
        final int THIRD_NODE_VALUE = 10;
        final int NOT_CONTAINS_NODE_VALUE = 30;
        final int FIRST_POSITION_INDEX = 1;
        final int SECOND_POSITION_INDEX = 2;
        final int THIRD_POSITION_INDEX = 3;

        LinkedList linkedList;
        ListNode first, second, third, contains, notContains;

        @BeforeAll
        void prepare_contains_test() {
            linkedList = new LinkedList();
            first = linkedList.add(head, new ListNode(FIRST_NODE_VALUE), FIRST_POSITION_INDEX);
            second = linkedList.add(head, new ListNode(SECOND_NODE_VALUE), SECOND_POSITION_INDEX);
            third = linkedList.add(head, new ListNode(THIRD_NODE_VALUE), THIRD_POSITION_INDEX);
            contains = first;
            notContains = new ListNode(NOT_CONTAINS_NODE_VALUE);
        }

        @Nested
        @DisplayName("연결 리스트에 존재하는 노드가 주어질 경우")
        class Context_with_contains {

            @Test
            @DisplayName("참을 리턴한다")
            void it_returns_true() {
                boolean isContains = linkedList.contains(head, contains);
                assertTrue(isContains);
            }
        }

//        @Nested
//        @DisplayName("연결 리스트에 존재하지 않는 노드가 주어질 경우")
//        class Context_with_not_contains {
//
//            @Test
//            @DisplayName("거짓을 리턴한다")
//            void it_returns_false() {
//                boolean isNotContains = linkedList.contains(head, notContains);
//                assertFalse(isNotContains);
//            }
//        }
    }
}