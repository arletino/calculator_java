package controller;

import data.ComplexNum;
import data.Operations;
import service.Calculator;
import service.LogToFile;
import service.OperationOnConsole;
import service.ParseNum;
import view.ViewCommands;

public class Controller {

    private ViewCommands viewCommands = new ViewCommands();
    private Calculator calculator = new Calculator();
    private OperationOnConsole operation = new OperationOnConsole();
    private LogToFile logger = new LogToFile();
    private ParseNum parseNum = new ParseNum();
    private ComplexNum complexNum1;
    private ComplexNum complexNum2;
 
    public void inputNum1OnConsole(){
        String num = viewCommands.inputNum();
        try {
            parseNum.parseStringNumList(num);
            complexNum1 = new ComplexNum(parseNum.getComplexNum());
            System.out.println("Complex number read successfully " + complexNum1.toString() );
            logger.info("Read num from console successfully " + complexNum1.toString());
        } catch (NumberFormatException e) {
            logger.warning("Input uncorrected format");
            logger.closeLogger();
        }
    }
    public void inputNum2OnConsole(){
        String num = viewCommands.inputNum();
        try {
            parseNum.parseStringNumList(num);
            complexNum2 = new ComplexNum(parseNum.getComplexNum());
            System.out.println("Complex number read successfully " + complexNum2.toString() );
            logger.info("Read num from console successfully " + complexNum2.toString() );
        } catch (NumberFormatException e) {
            logger.warning("Input uncorrected format");
            logger.closeLogger();
        }
    }
    public void inputOperation(){
        String num = viewCommands.inputOperation();
        try {
            operation.parseOperation(num);
            logger.info("Operation recognize successfully: " + operation.getOperation());
        } catch (NumberFormatException e) {
            logger.warning("Operation recognize not successfully");
            logger.closeLogger();    
        }
    }

    public void getResult(){
        if (complexNum1 == null || complexNum2 == null || operation.getStringOperation() == ""){
            logger.warning("Some complex numbers or operation don't load");
            logger.closeLogger();
        } else{
                choiceOperation(operation.getOperation());            
        }
        logger.closeLogger();
    }

    public void choiceOperation(Operations operation){
        String result = "";
        if (operation == Operations.SUM){
            if(this.operation.getStringOperation() == "-"){
                result = calculator.Summary(complexNum1, complexNum2, false).toString();
            }else {
                result = calculator.Summary(complexNum1, complexNum2, true).toString();
            }        
        }
        else if (operation == Operations.MULTI){
            result = calculator.Multiplication(complexNum1, complexNum2).toString();
        }
        else if (operation == Operations.DIVIZION){
            result = calculator.Division(complexNum1, complexNum2).toString();
        }
        System.out.println(result);
        logger.info("Summary done successfully - answer is: " + result);
    }
}
