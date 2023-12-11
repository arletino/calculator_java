package data;

public class RealNum {

    private double doubleRealNum;
    private NumsType type = NumsType.REALNUM;


    public RealNum(double doubleRealNum){
        this.doubleRealNum = doubleRealNum;
    }


    public double getRealNum() {
        return doubleRealNum;
    }

    public void setRealNum(double doubleRealNum) {
        this.doubleRealNum = doubleRealNum;
    }
    
}
