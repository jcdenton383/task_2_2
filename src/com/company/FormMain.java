package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;

public class FormMain extends JFrame {
    private JPanel panelMain;
    private JButton loadButton;
    private JButton solveButton;
    private JTable tableInput1;
    private JTextField textField1;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;


    public FormMain() {
        this.setTitle("FormMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        //------------------------------
        tableInput1.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");


        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        TestLinkedList list = ReadFile.readTestLinkedListFromFileDouble(fileChooserOpen.getSelectedFile().getPath());
                        double[] arr = list.toArrayDouble();
                        JTableUtils.writeArrayToJTable(tableInput1, arr);
                        //for(int i = 0; i < list.size(); i++) System.out.print(arr[i] + " ");
                        //JTableUtils.writeArrayToJTable(tableInput1, arr[0]);
                    }
                } catch (Exception ex) {
                    SwingUtils.showErrorMessageBox(ex);
                }


            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    try {
                        double[] arr = JTableUtils.readDoubleArrayFromJTable(tableInput1);
                        TestLinkedList list = new TestLinkedList();
                        for (int i = 0; i < arr.length; i++){
                            list.addLast(arr[i]);
                        }
                        textField1.setText(" " + list.getValueByNode(list.TaskSolution(list)));


                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (TestLinkedList.TestLinkedListException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("working");
                }

            }
        });
    }
}
