import controller.Controller;


public class Program {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.inputNum1OnConsole();
        controller.inputOperation();
        controller.inputNum2OnConsole();
        controller.getResult();
    }

}
