package service;


import java.util.Scanner;

public class ReadFromConsole {

    private String strNumber;

    public void readOnConsole(String str){
        Scanner scanner = new Scanner(System.in);
        System.out.println(str);
        strNumber = scanner.nextLine();
    }
    public String getStr() {
        return strNumber;
    }
}

