package com.pentyugov.app.tasks;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskTwo {
    private File file;

    public void setFile(File file) {
        this.file = file;
    }

    public String calculate() throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        String num = scanner.nextLine();
        if ("#TaskTwo".equals(num)) {
            num = scanner.nextLine();
        }
        String result = "";
        try {
            // Проверка является ли строка числом, если ловим эксепшн то показываем окно с ошибкой
            int check = Integer.parseInt(num);
            String[] tmp = num.split("");
            ArrayList<String> nums = new ArrayList<String>();
            for (String s : tmp) {
                nums.add(s);
            }
            for (int i = 0; i < nums.size(); i++) {
                String s = nums.get(i);
                if (!"0".equals(nums.get(i))) {
                    for (int j = 0; j < nums.size() - (i + 1); j++) {
                        s += "0";
                    }
                    nums.set(i, s);
                }
            }
            for (int i = 0; i < nums.size(); i++) {
                if ("0".equals(nums.get(i))) {
                    continue;
                } else if (i == nums.size() - 1) {
                    result += nums.get(i);
                } else result += nums.get(i) + " + ";
            }


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Вы ввели некорректное условие либо выбрали не тот тип задачи", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }


}
