package service;

import data.ComplexNum;
import data.RealNum;

public class Calculator implements Division, Summary, Multiplication {

    @Override
    public RealNum Multiplication(RealNum num1, RealNum num2) {
        RealNum multiplication = new RealNum(num1.getRealNum() * num2.getRealNum()); 
        return multiplication;
    }

    @Override
    public ComplexNum Multiplication(ComplexNum num1, ComplexNum num2) {
        RealNum realPart1 = new RealNum(num1.getRealNum());
        RealNum realPart2 = new RealNum(num2.getRealNum());
        RealNum imaginaryPart1 = new RealNum(num1.getImaginaryPart());
        RealNum imaginaryPart2 = new RealNum(num2.getImaginaryPart());
        ComplexNum summary;
        if (realPart1.getRealNum() == realPart2.getRealNum() 
            && imaginaryPart1.getRealNum() == -imaginaryPart2.getRealNum()){
                RealNum zero = new RealNum(0);
                summary = new ComplexNum(Summary(Multiplication(realPart1, realPart1), Multiplication(imaginaryPart1, imaginaryPart2), false), zero);
        }else{
            RealNum realPart = Summary(Multiplication(realPart1, realPart2),Multiplication(imaginaryPart1, imaginaryPart2), false);
            RealNum imaginaryPart = Summary(Multiplication(realPart1, imaginaryPart2),Multiplication(imaginaryPart1, realPart2), true);
            summary = new ComplexNum(realPart, imaginaryPart);
        }
        return summary;
    }

    @Override
    public RealNum Summary(RealNum num1, RealNum num2, boolean sign) {
        RealNum summary;
        if (sign){
            summary = new RealNum(num1.getRealNum() + num2.getRealNum());
        }else{
            summary = new RealNum(num1.getRealNum() - num2.getRealNum());
        }
        return summary;
    }

    @Override
    public ComplexNum Summary(ComplexNum num1, ComplexNum num2, boolean sign) {
        RealNum realPart1 = new RealNum(num1.getRealNum());
        RealNum realPart2 = new RealNum(num2.getRealNum());
        RealNum imaginaryPart1 = new RealNum(num1.getImaginaryPart());
        RealNum imaginaryPart2 = new RealNum(num2.getImaginaryPart());
        ComplexNum summary; 
        if (sign){
            summary = new ComplexNum(Summary(realPart1, realPart2, sign), Summary(imaginaryPart1, imaginaryPart2, sign));
        } else{
            summary = new ComplexNum(Summary(realPart1, realPart2, sign), Summary(imaginaryPart1, imaginaryPart2, sign));
        }
        return summary;
    }

    @Override
    public RealNum Division(RealNum num1, RealNum num2) throws ArithmeticException{
        if (num2.getRealNum() == 0){
            throw new ArithmeticException("division by zero");
        }
        RealNum divizion = new RealNum(num1.getRealNum() / num2.getRealNum());
        return divizion;
    }

    @Override
    public ComplexNum Division(ComplexNum num1, ComplexNum num2) throws ArithmeticException {
        if((num2.getRealNum() + num2.getRealNum()) == 0){
            throw new ArithmeticException("divizion by zero");
        }
        ComplexNum negativeNum2 = new ComplexNum(num2.getRealNum(), num2.getImaginaryPart());
        negativeNum2.setImaginaryPart(-num2.getImaginaryPart());
        ComplexNum numerator = Multiplication(num1, negativeNum2);
        System.out.println(numerator);
        ComplexNum denominator = Multiplication(num2, negativeNum2);
        System.out.println(denominator);
        RealNum temp = (RealNum)denominator;
        System.out.println(temp);
        RealNum realPart = Division((RealNum)numerator, temp);
        RealNum imaginaryPart = Division(new RealNum(numerator.getImaginaryPart()), temp);
        ComplexNum summary = new ComplexNum(realPart, imaginaryPart);
        return summary;
    }
    
}
