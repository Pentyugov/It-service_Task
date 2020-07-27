package com.pentyugov.app.tasks;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TaskOne {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public TreeSet calculate() throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        ArrayList<String> tempList = new ArrayList();
        ArrayList<String> substrings = new ArrayList();
        ArrayList<String> strings = new ArrayList();
        TreeSet<String> result = new TreeSet();

        while (scanner.hasNextLine()) {
            tempList.add(scanner.nextLine().toLowerCase());
        }
        try {
            substrings.addAll(Arrays.asList(tempList.get(1).split(" ")));
            strings.addAll(Arrays.asList(tempList.get(2).split(" ")));

            for (String substring : substrings) {
                for (String string : strings) {
                    if (string.contains(substring)) {
                        result.add(substring);
                    }
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Вы ввели некорректное условие либо выбрали не тот тип задачи", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }
}
