package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Struct;
import java.util.*;

class Client {
    Client(String firstName,
           String secondName,
           String fatherName,
           Integer age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;
        this.age = age;
    }

    public String firstName;
    public String secondName;
    public String fatherName;
    public Integer age;
}

public class Main {
    public static void printClients(ArrayList<Client> DB){
        for(Client c : DB){
            System.out.println(c.secondName);
            System.out.println(c.firstName);
            System.out.println(c.fatherName);
            System.out.println(c.age);
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Client> DB = new ArrayList<>();
        Path path = Paths.get("/Users/geges/Documents/TinkoffTest2/src/input.txt");
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String sName = scanner.nextLine();
            String fName = scanner.nextLine();
            String faName = scanner.nextLine();
            Integer age = Integer.parseInt(scanner.nextLine());
            Client client = new Client(faName, sName, faName, age);
            DB.add(client);
        }
       printClients(DB);

        Collections.sort(DB, new Comparator<Client>(){
            @Override
            public int compare(Client o1, Client o2) {
                if(o1.age == o2.age)
                    return 0;
                return o1.age < o2.age ? -1 : 1;
            }
        });

        System.out.println();
        //sorted
        printClients(DB);
    }

}
