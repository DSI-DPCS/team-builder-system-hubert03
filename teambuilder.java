package com.drh.lesson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class teambuilder {
    static int num;
    static ArrayList<String> Name = new ArrayList<>();
    static ArrayList<String> Surname = new ArrayList<>();
    static ArrayList<String> Sex = new ArrayList<>();
    static ArrayList<String> Date = new ArrayList<>();
    static ArrayList<Long> Dataint = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        // Welcome
        System.out.println("Welcome to the Team Builder System");
        System.out.println("==================================");

        // Ask for the number of teamates
        System.out.println("How many members are there in the team?");
        Scanner scan = new Scanner(System.in);

        if(scan.hasNextInt()){
            num  = scan.nextInt();
        }
        //scan.close();

        SimpleDateFormat converter = new SimpleDateFormat("dd/MM/yyyy");

        // Ask for their age
        System.out.println("Input the team members (Name:Surname:DD/MM/YYYY):");
        for (int i = 0; i < num; i++) {
            String temp = scan.next();
            String[] templist = temp.split(":");

            // Append
            Name.add(templist[0]);
            Surname.add(templist[1]);
            Sex.add(templist[2]);
            Date.add(templist[3]);

            Dataint.add(converter.parse(templist[3]).getTime());
        }

        System.out.println("Team Builder Menu:");
        System.out.println("==================================");
        System.out.println("1.List the team members");
        System.out.println("2.Find the oldest member");
        System.out.println("3.Find the youngest member");

        // Switch
        while (scan.hasNextInt()){
            switch (scan.nextInt()){
                case 1:
                    Listteam();
                    break;

                case 2:
                    YO(true);
                    break;

                case 3:
                    YO(false);
                    break;
            }
        }



    }

    // List all team members
    public static void Listteam(){
        System.out.println("List all members:");
        System.out.println("==================================");

        for (int i = 0; i < num; i++) {
            System.out.println(Name.get(i) + " " + Surname.get(i) + ", " + Sex.get(i) + "born in " + Date.get(i));
        }
    }

    public static void YO(boolean ttb){

        long temp = Dataint.get(0);

        if(ttb){
            System.out.println("The oldest one:");

            // 找最小
            for (long n :
                    Dataint) {
                if(n < temp){
                    temp = n;
                }
            }
        }else {
            System.out.println("The youngest one:");

            // 找最大
            for (long n :
                    Dataint) {
                if(n > temp){
                    temp = n;
                }
            }
        }

        System.out.println("==================================");


        int boy = Dataint.indexOf(temp);

        System.out.println(Name.get(boy) + " " + Surname.get(boy) + ", " + Sex.get(boy) + "born in " + Date.get(boy));

    }
}
