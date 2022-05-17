package com.livestudy.week4.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Nested
    @DisplayName("생성자는")
    class constructorTest {

        private int getMaxSizeFromStack(Stack stack) {
            try {
                Field maxSize = stack.getClass().getDeclaredField("maxSize");
                maxSize.setAccessible(true);
                return (int) maxSize.get(stack);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return -1;
        }

        @Nested
        @DisplayName("인자 값이 없다면")
        class Context_with_no_param {

            @Test
            @DisplayName("크기가 10인 스택이 생성된다")
            void it_create_stack_with_default_size() {
                final int DEFAULT_STACK_SIZE = 10;
                Stack stack = new Stack();
                int maxSize = getMaxSizeFromStack(stack);
                assertEquals(DEFAULT_STACK_SIZE, maxSize);
            }
        }

        @Nested
        @DisplayName("인자 값이 있다면")
        class Context_with_param {

            @Test
            @DisplayName("인자 값에 해당하는 스택이 생성된다")
            void it_create_stack_with_param_size() {
                final int STACK_SIZE = 5;
                Stack stack = new Stack(STACK_SIZE);
                int maxSize = getMaxSizeFromStack(stack);
                assertEquals(STACK_SIZE, maxSize);
            }
        }
    }

    @Nested
    @DisplayName("push 메서드는")
    class pushTest {

        @Nested
        @DisplayName("스택이 차있다면")
        class Context_with_full_stack {
            Stack stack;

            @BeforeEach
            void prepare() {
                final int STACK_SIZE = 5;
                stack = new Stack(STACK_SIZE);
                for (int i = 0; i < STACK_SIZE; i++) {
                    stack.push(i);
                }
            }

            @Test
            @DisplayName("RuntimeException이 발생한다.")
            void it_occurs_runtime_exception() {
                assertThrows(RuntimeException.class, () -> stack.push(10));
            }
        }

        @Nested
        @DisplayName("인자 값이 없이 선언된 스택에 데이터를 담았을 때")
        class Context_stack_with_data {
            final int FIRST_DATA = 1;
            final int SECOND_DATA = 2;
            final int THIRD_DATA = 3;
            Stack stack;

            @BeforeEach
            void prepare() {
                stack = new Stack();
                stack.push(FIRST_DATA);
                stack.push(SECOND_DATA);
                stack.push(THIRD_DATA);
            }

            @Test
            @DisplayName("최상위 데이터는 세번째 데이터와 같다")
            void it_top_data_same_third_data() {
                try {
                    Field store = stack.getClass().getDeclaredField("store");
                    store.setAccessible(true);
                    Field size = stack.getClass().getDeclaredField("size");
                    size.setAccessible(true);
                    int topData = ((int[]) store.get(stack))[(int) size.get(stack) - 1];
                    assertEquals(topData, THIRD_DATA);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Nested
    @DisplayName("pop 메서드는")
    class popTest {

        @Nested
        @DisplayName("스택이 비어있다면")
        class Context_with_empty_stack {
            Stack stack = new Stack();

            @Test
            @DisplayName("RuntimeException이 발생한다.")
            void it_occurs_runtime_exception() {
                assertThrows(RuntimeException.class, () -> stack.pop());
            }
        }

        @Nested
        @DisplayName("스택에 3개의 데이터가 들어있다면")
        class Context_stack_with_data {
            final int FIRST_DATA = 1;
            final int SECOND_DATA = 2;
            final int THIRD_DATA = 3;
            Stack stack;

            @BeforeEach
            void prepare() {
                stack = new Stack();
                stack.push(FIRST_DATA);
                stack.push(SECOND_DATA);
                stack.push(THIRD_DATA);
            }

            @Test
            @DisplayName("가장 먼저 리턴되는 데이터는 마지막에 담은 데이터이다")
            void first_return_last_data() {
                int popData = stack.pop();
                assertEquals(THIRD_DATA,popData);
            }

            @Test
            @DisplayName("최상위 데이터는 두번째 데이터와 같다.")
            void top_data_is_second_data() {
                stack.pop();
                try {
                    Field store = stack.getClass().getDeclaredField("store");
                    store.setAccessible(true);
                    Field size = stack.getClass().getDeclaredField("size");
                    size.setAccessible(true);
                    int topData = ((int[])store.get(stack))[(int)size.get(stack)-1];
                    assertEquals(topData,SECOND_DATA);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
       }
    }
}
