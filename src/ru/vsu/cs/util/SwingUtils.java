package ru.vsu.cs.util;

import javax.swing.JOptionPane;

/**
 * Набор функций для работы с оконными приложениями с ипользованием Swing
 * @author Дмитрий Соломатин (кафедра ПиИТ ФКН ВГУ)
 */
public class SwingUtils {
    /**
     * Показать диалоговое окно с информационным сообщением
     * @param message Сообщение
     * @param title Заголовок окна
     */
    public static void showInfoMessageBox(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
