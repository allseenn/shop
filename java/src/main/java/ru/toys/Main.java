package ru.toys;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            cls();
            System.out.println("1. Добавить Конструктор");
            System.out.println("2. Добавить Куклу");
            System.out.println("3. Добавить Машинку");
            System.out.println("4. Добавить Мягкую игрушку");
            System.out.println("5. Добавить Настольную игру");
            System.out.println("6. Добавить Робота");
            System.out.println("7. Вывести список всех игрушек");
            System.out.println("8. Изменить игрушку");
            System.out.println("9. Запустить розыгрыш");
            System.out.println("0. Выйти из программы");

            System.out.print("Введите цифру для действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cls();
                    System.out.print("Введите название конструктора: ");
                    String constructorName = scanner.nextLine();
                    store.addToy("Конструкторы", constructorName);
                    break;
                case 2:
                    cls();
                    System.out.print("Введите название куклы: ");
                    String dollName = scanner.nextLine();
                    store.addToy("Куклы", dollName);
                    break;
                case 3:
                    cls();
                    System.out.print("Введите название машинки: ");
                    String carName = scanner.nextLine();
                    store.addToy("Машинки", carName);
                    break;
                case 4:
                    cls();
                    System.out.print("Введите название мягкой игрушки: ");
                    String softToyName = scanner.nextLine();
                    store.addToy("Мягкие игрушки", softToyName);
                    break;
                case 5:
                    cls();
                    System.out.print("Введите название настольной игры: ");
                    String boardGameName = scanner.nextLine();
                    store.addToy("Настольные игры", boardGameName);
                    break;
                case 6:
                    cls();
                    System.out.print("Введите название робота: ");
                    String robotName = scanner.nextLine();
                    store.addToy("Роботы", robotName);
                    break;
                case 7:
                    cls();
                    store.listToys();
                    System.out.print("Введите 0, для возврата: ");
                    choice = scanner.nextInt();
                    break;
                case 8:
                    cls();
                    System.out.print("Введите id игрушки для изменения: ");
                    String id = scanner.nextLine();

                    while (true) {
                        System.out.println("1. Поменять вес игрушки");
                        System.out.println("2. Удалить игрушку");
                        System.out.println("3. Изменить имя игрушки");
                        System.out.println("4. Возврат в главное меню");
                        System.out.println("5. Выход из программы");
                        System.out.print("Введите номер действия: ");
                        int subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.print("Введите новый вес игрушки: ");
                                String weight = scanner.nextLine();
                                store.chWeight(id, weight);
                                break;
                            case 2:
                                store.delToy(id);
                                break;
                            case 3:
                                System.out.print("Введите новое имя игрушки: ");
                                String newName = scanner.nextLine();
                                store.renToy(id, newName);
                                break;
                            case 4:
                                break;
                            case 5:
                                scanner.close();
                                return;
                            default:
                                System.err.println("Неверный выбор");
                        }

                        if (subChoice == 4) {
                            break;
                        }
                    }

                    break;
                case 9:
                    String prizeId = store.getPrize();
                    if (prizeId != null) {
                        String prizeName = store.stringToy(prizeId);
                        if (prizeName != null) {
                            System.out.println("Ваш приз: " + prizeName);
                        } else {
                            System.err.println("Ошибка при получении имени приза");
                        }
                    } else {
                        System.err.println("Ошибка при получении приза");
                    }

                    break;
                case 0:
                    scanner.close();
                    return;
                default:

                     System.err.println("Неверный выбор");
            }
        }
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error clearing screen");
        }
    }

}
