package com.pentyugov.app.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.pentyugov.app.tasks.TaskOne;
import com.pentyugov.app.tasks.TaskTwo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class MainFrame extends JFrame {
    private JPanel rootPanel;
    private JComboBox comboBox;
    private JButton taskButton;
    private JButton saveButton;
    private JButton calculateButton;
    private JButton loadButton;
    private JTextArea textArea;
    private JTextField strTextField;
    private JTextField subTextField;
    private JLabel subLabel;
    private JLabel strLabel;
    private JLabel chooseLabel;
    private File file;


    public MainFrame() {
        $$$setupUI$$$();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();
        this.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 300);
        this.setMinimumSize(new Dimension(500, 300));
        add(rootPanel);
        comboBox.addItem("Задача № 1");
        comboBox.addItem("Задача № 2");
        textArea.setLineWrap(true);

        taskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox.getSelectedIndex()) {
                    case 0: {
                        String msg = "В поле \"Строка\" через пробел вводятся слова в которых происходит поиск подстрок\n";
                        msg += "В поле \"Подстрока\" через пробел вводятся подстроки, которые необходимо найти.";
                        JOptionPane.showMessageDialog(null, msg, "Условие", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    case 1: {
                        String msg = "В поле \"Число\" вводится положительное целое число, которое необходимо\n";
                        msg += "представить в расширенной форме.";
                        JOptionPane.showMessageDialog(null, msg, "Условие", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ret = fileChooser.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
                int ret = fileChooser.showSaveDialog(null);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile() + ".txt", true);

                        switch (comboBox.getSelectedIndex()) {
                            case 0:
                                fileWriter.write("#TaskOne\n");
                                fileWriter.write(subTextField.getText() + "\n");
                                fileWriter.write(strTextField.getText());
                                fileWriter.close();
                                break;
                            case 1:
                                fileWriter.write("#TaskTwo\n");
                                fileWriter.write(strTextField.getText());
                                fileWriter.close();
                                break;
                        }


                    } catch (IOException ioException) {
                        System.out.println("ERROR");
                    }
                }
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    switch (comboBox.getSelectedIndex()) {
                        case 0:
                            TaskOne taskOne = new TaskOne();
                            taskOne.setFile(file);
                            TreeSet<String> result = taskOne.calculate();
                            textArea.setText("");
                            for (String s : result) {
                                textArea.append(s + " ");
                            }
                            break;

                        case 1:
                            TaskTwo taskTwo = new TaskTwo();
                            taskTwo.setFile(file);
                            String res = taskTwo.calculate();
                            textArea.setText(res);
                            break;

                    }
                } catch (FileNotFoundException exception) {
                    JOptionPane.showMessageDialog(null, "Файл не найден", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBox.getSelectedIndex()) {
                    case 0: {
                        strLabel.setText("Строка");
                        subTextField.setEnabled(true);
                        subTextField.setVisible(true);
                        subLabel.setVisible(true);
                        break;
                    }
                    case 1: {
                        strLabel.setText("Число");
                        subTextField.setVisible(false);
                        subLabel.setVisible(false);
                        break;
                    }
                }
            }
        });

    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(9, 3, new Insets(20, 20, 20, 20), -1, -1));
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        rootPanel.add(spacer2, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        rootPanel.add(spacer3, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        comboBox = new JComboBox();
        rootPanel.add(comboBox, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        taskButton = new JButton();
        taskButton.setText("Условие");
        rootPanel.add(taskButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        chooseLabel = new JLabel();
        chooseLabel.setText("Выберите задачу");
        rootPanel.add(chooseLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        strTextField = new JTextField();
        rootPanel.add(strTextField, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        strLabel = new JLabel();
        strLabel.setText("Строка");
        rootPanel.add(strLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        subTextField = new JTextField();
        rootPanel.add(subTextField, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        subLabel = new JLabel();
        subLabel.setText("Подстрока");
        rootPanel.add(subLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        saveButton = new JButton();
        saveButton.setText("Сохранить");
        rootPanel.add(saveButton, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calculateButton = new JButton();
        calculateButton.setText("Посчитать");
        rootPanel.add(calculateButton, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loadButton = new JButton();
        loadButton.setText("Загрузить");
        rootPanel.add(loadButton, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Вывод");
        rootPanel.add(label1, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        rootPanel.add(scrollPane1, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textArea = new JTextArea();
        scrollPane1.setViewportView(textArea);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
