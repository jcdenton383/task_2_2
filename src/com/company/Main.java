package com.company;

public class Main {

    public static void main(String[] args) throws TestLinkedList.TestLinkedListException {
	// write your code here
        /*TestLinkedList list = new TestLinkedList();
        list.addLast(10.0);
        list.addLast(15.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(10.0);
        list.addLast(77.0); //6
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(-10.0);
        list.addLast(33.0);
        list.addLast(10.0);
        list.TaskSolution(list);
        double[] arr = list.toArrayDouble();
        for(int i = 0; i < list.size(); i++) System.out.print(arr[i] + " ");*/


        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });

    }
}
