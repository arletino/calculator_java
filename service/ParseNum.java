package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.ComplexNum;
import data.RealNum;

public class ParseNum {
    private static double realPart = 0;
    private static double imaginaryPart = 0;
    private RealNum realNum;
    private ComplexNum complexNum;
    
        
    public void parseStringNumList(String str) throws NumberFormatException{
        String[] temp = str.trim().split("[+-]");
        List<String> nums = new ArrayList<>();
        nums.addAll(Arrays.asList(temp));
        if (temp[0] == ""){
            nums.set(0, str.substring(0, 1));
        } else{
            nums.add(0, "+");
        }
        if (str.substring(1).contains("+")){
            nums.add(2,"+");
        }
        else if (str.substring(1).contains("-")){
            nums.add(2,"-");
        }
        checkListNum(nums);
        parseNums(nums);
    }

    public static void checkListNum(List<String> listNums) throws NumberFormatException{
        if (listNums.size() > 4){
            throw new NumberFormatException();
        }
        for (String string : listNums) {
            if (!(string.equals("+") || string.equals("-"))){
                String temp = string;
                if(string.endsWith("i")){
                    temp = string.replace("i", "");
                }
                Double.parseDouble(temp);
            }
        }
    }

    public static void parseNums(List<String> listStr){
        String realPart = "";
        String imaginaryPart = "";
        String sign = "";
        for (String string : listStr) {
         if (!(string.equals("+") || string.equals("-"))){
            if(string.contains("i")){
                imaginaryPart = sign;
                imaginaryPart += string.replace("i", ""); 
            }else {
                realPart = sign;
                realPart += string;
            }
         }
        sign = string;    
        }
        if (!realPart.equals("")){
            ParseNum.realPart = Double.parseDouble(realPart);
        } else ParseNum.realPart = 0;
        if (!imaginaryPart.equals("")){
            ParseNum.imaginaryPart = Double.parseDouble(imaginaryPart);
        }else ParseNum.imaginaryPart = 0;
        
    }

    public  RealNum getRealNum() {
        realNum = new RealNum(realPart);
        return realNum;
    }

    public ComplexNum getComplexNum() {
        complexNum = new ComplexNum(realPart, imaginaryPart);
        return complexNum;
    }
}
