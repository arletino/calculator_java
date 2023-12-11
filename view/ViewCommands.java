package view;


import service.ReadFromConsole;

public class ViewCommands {
    
    public String inputNum(){
        String intro = "Input complex number like \"3+7i\"";
        ReadFromConsole readFromConsole = new ReadFromConsole();
        readFromConsole.readOnConsole(intro);
        String stringNum = (readFromConsole.getStr());
        return stringNum;
    }

    public String inputOperation(){
        String intro = "Input operation(Summ - \"+\" or \"-\", Multi - \"*\", Division - \"/\")";
        ReadFromConsole readFromConsole = new ReadFromConsole();
        readFromConsole.readOnConsole(intro);
        String stringOperation = (readFromConsole.getStr());
        return stringOperation;
    }
}
