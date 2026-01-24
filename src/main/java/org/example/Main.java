package org.example;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;


public class Main {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыбери свой путь....");
            System.out.println("1. Пасматреть зодачи");
            System.out.println("2. Дабавить зодачу");
            System.out.println("3. Удолить зодачу");
            System.out.println("4. Ридоктиравать зодачу");
            System.out.println("5. Сахранить зодачу");
            System.out.println("6. Как стать богатым");
            System.out.println("7. Выход");

            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    editTasks();
                    break;
                case 5:
                    saveTasks();
                    break;
                case 6:
                    bazar();
                    break;
                case 7:
                    System.out.println("Ну и катись...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Такого пункта нет.");
            }
        }
    }

    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Пока отдыхай...");
            return;
        }
        System.out.println("\nНадо сделать:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи название задачи: ");

        String name = scanner.nextLine();
        System.out.print("Введи описание задачи: ");

        String description = scanner.nextLine();
        tasks.add(new Task(name, description));

        System.out.println("Бегом работать!");
    }

    public static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        System.out.print("Лопух, вводи номер...: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Я это запомню.");
        } else {
            System.out.println("Ха-ха, иди работай.");
        }
    }

    public static void editTasks(){

        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }

        System.out.print("Лопух, вводи номер...: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);

            System.out.print("Введи название задачи: ");
            String name = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Введи описание задачи: ");
            String description = scanner.nextLine();

            tasks.add(new Task(name, description));
            System.out.println("Бегом работать!");
        } else {
            System.out.println("Ха-ха, иди работай.");
        }
    }


    public static void saveTasks()  {
        Gson gson = new Gson();
        String jsonString = gson.toJson(tasks);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
            writer.write(jsonString);
            writer.flush();
            writer.newLine();
            writer.close();
            System.out.println("фывфыв: " + jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void bazar(){
        Desktop desk = Desktop.getDesktop();
        try {
            desk.browse(new URI("https://youtu.be/a3koSnInh1Y?si=P7raqE2n5twp6j5o"));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
