package ru.vsu.cs.novichikhin;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.ListUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable firstTableInput;
    private JTable secondTableInput;
    private JButton buttonLoadFromInputFile;
    private JButton buttonCreateSortedList;
    private JButton buttonSaveToOutputFile;
    private JTable tableOutput;
    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Создание сортированного листа");
        this.setContentPane(panelMain);
        this.setBounds(250, 50, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(firstTableInput, 50, false, true, false, true);
        JTableUtils.initJTableForArray(secondTableInput, 50, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 50, false, true, false, false);
        firstTableInput.setRowHeight(30);
        secondTableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("C:\\Users\\ВЯЧЕСЛАВ\\ВГУ\\АиСД\\Second_task"));
        fileChooserSave.setCurrentDirectory(new File("C:\\Users\\ВЯЧЕСЛАВ\\ВГУ\\АиСД\\Second_task"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        buttonLoadFromInputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {

                    double[][] array = ArrayUtils.readDoubleArray2FromFile(fileChooserOpen.getSelectedFile().getPath());

                    assert (array != null ? array.length : 0) == 2;
                    JTableUtils.writeArrayToJTable(firstTableInput, ArrayUtils.convertToStringArray(array[0]));
                    JTableUtils.writeArrayToJTable(secondTableInput, ArrayUtils.convertToStringArray(array[1]));
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("В файле должно быть две строки с числами", "Ошибка");
            }
        });

        buttonCreateSortedList.addActionListener(actionEvent -> {
            try {
                double[] firstArray = JTableUtils.readDoubleArrayFromJTable(firstTableInput);
                ArrayUtils.sortInAscendingOrder(firstArray);
                assert firstArray != null;
                SimpleLinkedList<Double> firstList = ListUtils.convertToLinkedList(firstArray);


                double[] secondArray = JTableUtils.readDoubleArrayFromJTable(secondTableInput);
                ArrayUtils.sortInAscendingOrder(secondArray);
                assert secondArray != null;
                SimpleLinkedList<Double> secondList = ListUtils.convertToLinkedList(secondArray);

                SimpleLinkedList<Double> list = new SimpleLinkedList<>(firstList, secondList);

                JTableUtils.writeArrayToJTable(tableOutput, ListUtils.convertToStringArray(list));
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Каждая ячейка должна содержать число", "Ошибка");
            }
        });

        buttonSaveToOutputFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    double[] array = JTableUtils.readDoubleArrayFromJTable(tableOutput);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, array);
                }
            } catch (Exception e) {
                SwingUtils.showInfoMessageBox("Не уадётся сохранить в файл", "Ошибка");
            }
        });
    }
}
