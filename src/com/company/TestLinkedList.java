package com.company;

import java.util.Iterator;

public class TestLinkedList<T> implements Iterable<T> {


    public static class TestLinkedListException extends Exception {
        public TestLinkedListException(String message) {
            super(message);
        }
    }

    private class TestLinkedListNode {
        public T value;
        public TestLinkedListNode next;

        public TestLinkedListNode(T value, TestLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public TestLinkedListNode(T value) {
            this(value, null);
        }
    }

    private TestLinkedListNode head = null;  // first, top
    private TestLinkedListNode tail = null;  // last
    private int size = 0;

    // O(1)
    public void addFirst(T value) {
        head = new TestLinkedListNode(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // O(1)
    public void addLast(T value) {
        if (size == 0) {
            head = tail = new TestLinkedListNode(value);
        } else {
            tail.next = new TestLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws TestLinkedListException {
        if (size == 0) {
            throw new TestLinkedListException("Empty list");
        }
    }

    // O(n)
    private TestLinkedListNode getNode(int index) {
        TestLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    // O(1)
    public void removeFirst() throws TestLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    // O(n)
    public void removeLast() throws TestLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    // O(n)
    public void remove(int index) throws TestLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new TestLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            TestLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public T getValueByNode(TestLinkedListNode node) {
        return node.value;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(n)
    public T get(int index) throws TestLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    // O(1)
    public T getFirst() throws TestLinkedListException {
        checkEmptyError();
        return head.value;
    }

    // O(1)
    public T getLast() throws TestLinkedListException {
        checkEmptyError();
        return tail.value;
    }

   //---------
    public  double[] toArrayDouble() throws TestLinkedListException {
        double[] arr = new double[size];
for(int i = 0; i < size; i++){
    arr[i] = (double)getNode(i).value;
}
return arr;
    }

    //----------------------
//backwards
   /* public TestLinkedListNode TaskSolution(TestLinkedList<Double> list) throws TestLinkedListException {  //obviously only works with <double> list
        //kinda obvious question: can we even discern what type of list we have to check whether we passing string or double?
        //
        int chainLength = 0, previousChainLength = 0;
        int index = 0;

        for (int i = 0; i < list.size()-1; i++){
            if ((list.get(i) >= 0) && (list.get(i+1) < 0)) {
                i++;
                while(list.get(i) < 0){
                    chainLength++;
                    i++;
                }
                if (chainLength >= previousChainLength) {previousChainLength = chainLength; index = i;}
                chainLength = 0;

            }
        }
        //System.out.println("SOL " + getNode(index).value);
        return getNode(index);
    }*/
//-------------------------
public TestLinkedListNode TaskSolution(TestLinkedList<Double> list) throws TestLinkedListException { //obv works only with double, since we are SUPPOSED to work on numbers as per task
    int chainLength = 0, previousChainLength = 0;
    int index = 0;
//done without iterator
    for (int i = list.size()-1; i > 1; i--){
        if ((list.get(i) >= 0) && (list.get(i-1) < 0)) {
            i--;
            while(list.get(i) < 0){
                chainLength++;
                i--;
            }
            if (chainLength >= previousChainLength) {previousChainLength = chainLength; index = i;}
            chainLength = 0;

        }
    }
    return getNode(index);
}

//----------------------------

    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            TestLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }


}
