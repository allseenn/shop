package ru.toys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    private String[] files = {"Конструкторы", "Куклы", "Машинки", "Мягкие игрушки", "Настольные игры", "Роботы"};
    private String directoryName = "Игрушки";
    private Random random = new Random();

    public Store() {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        for (String fileName : files) {
            File file = new File(directoryName + File.separator + fileName);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.err.println("Error creating file: " + fileName);
                }
            }
        }
    }

    public void listFiles() {
        File directory = new File(directoryName);
        File[] fileList = directory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                System.out.println(file.getName());
            }
        }
    }

    public void addToy(String fileName, String toyName) {
        int id = random.nextInt(Short.MAX_VALUE) + 1;
        int weight = random.nextInt(101);

        File file = new File(directoryName + File.separator + fileName);
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(id + ";" + toyName + ";" + weight + System.lineSeparator());
            } catch (IOException e) {
                System.err.println("Error writing to file: " + fileName);
            }
        } else {
            System.err.println("File not found: " + fileName);
        }
    }

    public void listToys() {
        for (String fileName : files) {
            System.out.println(fileName + ":");
            File file = new File(directoryName + File.separator + fileName);
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("  " + line.replace(';', ' '));
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from file: " + fileName);
                }
            } else {
                System.err.println("File not found: " + fileName);
            }
        }
    }

    public String getPrize() { 
        List<String> toys = new ArrayList<>(); 
        List<Integer> weights = new ArrayList<>(); 

        for (String fileName : files) { 
            File file = new File(directoryName + File.separator + fileName); 
            if (file.exists()) { 
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) { 
                    String line; 
                    while ((line = reader.readLine()) != null) { 
                        String[] parts = line.split(";"); 
                        if (parts.length > 2) { 
                            int weight = Integer.parseInt(parts[2]); 
                            toys.add(line); 
                            weights.add(weight); 
                        } 
                    } 
                } catch (IOException e) { 
                    System.err.println("Error reading from file: " + fileName); 
                } 
            } else { 
                System.err.println("File not found: " + fileName); 
            } 
        } 

        int totalWeight = 0; 
        for (int weight : weights) { 
            totalWeight += weight; 
        } 

        int randomWeight = random.nextInt(totalWeight); 
        int currentWeight = 0; 
        for (int i = 0; i < toys.size(); i++) { 
            currentWeight += weights.get(i); 
            if (currentWeight >= randomWeight) { 
                String toyLine = toys.get(i); 
                String[] parts = toyLine.split(";"); 
                if (parts.length > 2) {  
                    return parts[0];  
                } 
            } 
        } 

        return null;  
    }

    public String stringToy(String id) {  
        for (String fileName : files) {  
            File file = new File(directoryName + File.separator + fileName);  
            if (file.exists()) {  
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {  
                    String line;  
                    while ((line = reader.readLine()) != null) {  
                        String[] parts = line.split(";");  
                        if (parts.length > 2 && parts[0].equals(id)) {  
                            return parts[1];  
                        }  
                    }  
                } catch (IOException e) {  
                    System.err.println("Error reading from file: " + fileName);  
                }  
            } else {  
                System.err.println("File not found: " + fileName);  
            }  
        } 
        return null; 
    }

    public void chWeight(String id, String weight) {
        for (String fileName : files) {
            List<String> lines = new ArrayList<>();
            boolean found = false;
    
            File file = new File(directoryName + File.separator + fileName);
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(";");
                        if (parts.length > 2 && parts[0].equals(id)) {
                            found = true;
                            lines.add(parts[0] + ";" + parts[1] + ";" + weight);
                        } else {
                            lines.add(line);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from file: " + fileName);
                }
    
                if (found) {
                    try (FileWriter writer = new FileWriter(file, false)) {
                        for (String line : lines) {
                            writer.write(line + System.lineSeparator());
                        }
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + fileName);
                    }
                    break;
                }
            } else {
                System.err.println("File not found: " + fileName);
            }
        }
    }
    
    public void renToy(String id, String toyName) {
        for (String fileName : files) {
            List<String> lines = new ArrayList<>();
            boolean found = false;
    
            File file = new File(directoryName + File.separator + fileName);
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(";");
                        if (parts.length > 2 && parts[0].equals(id)) {
                            found = true;
                            lines.add(parts[0] + ";" + toyName + ";" + parts[2]);
                        } else {
                            lines.add(line);
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from file: " + fileName);
                }
    
                if (found) {
                    try (FileWriter writer = new FileWriter(file, false)) {
                        for (String line : lines) {
                            writer.write(line + System.lineSeparator());
                        }
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + fileName);
                    }
                    break;
                }
            } else {
                System.err.println("File not found: " + fileName);
            }
        }
    }
    


    public void delToy(String id) { 
        for (String fileName : files) { 
            List<String> lines = new ArrayList<>(); 
            boolean found = false; 

            File file = new File(directoryName + File.separator + fileName); 
            if (file.exists()) { 
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) { 
                    String line; 
                    while ((line = reader.readLine()) != null) { 
                        String[] parts = line.split(";"); 
                        if (parts.length > 0 && parts[0].equals(id)) { 
                            found = true; 
                        } else { 
                            lines.add(line); 
                        } 
                    } 
                } catch (IOException e) { 
                    System.err.println("Error reading from file: " + fileName); 
                } 

                if (found) { 
                    try (FileWriter writer = new FileWriter(file, false)) { 
                        for (String line : lines) { 
                            writer.write(line + System.lineSeparator()); 
                        } 
                    } catch (IOException e) { 
                        System.err.println("Error writing to file: " + fileName); 
                    } 
                    break; 
                } 
            } else { 
                System.err.println("File not found: " + fileName); 
            } 
        } 
    }
}
