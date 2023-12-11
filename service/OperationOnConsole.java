package service;

import data.Operations;

public class OperationOnConsole {
    
    private Operations operation;
    private String stringOperation = "";
    
    public void parseOperation(String str) throws NumberFormatException{
        if (str.equals("+") || str.equals("-")){
            this.operation = operation.SUM;
        } else if (str.equals("*")){
            this.operation = operation.MULTI; 
        }else if (str.equals("/")){
            this.operation = operation.DIVIZION;
        } else{
            throw new NumberFormatException();
        }
        this.stringOperation = str;
    }

    public Operations getOperation() {
        return operation;
    }

    public String getStringOperation() {
        return stringOperation;
    }
}
