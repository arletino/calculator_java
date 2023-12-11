package data;

public class ComplexNum extends RealNum{
    private double imaginaryPart;
    private NumsType type = NumsType.COMPLEXNUM;

    
    public double getImaginaryPart() {
        return imaginaryPart;
    }


    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }


    public ComplexNum(RealNum realPart,RealNum imaginaryPart){
        super(realPart.getRealNum());
        this.imaginaryPart = imaginaryPart.getRealNum();

    }
    
    public ComplexNum(double realPart, double imaginaryPart){
        super(realPart);
        this.imaginaryPart = imaginaryPart;
    }
    public ComplexNum(ComplexNum complexNum){
        super(complexNum.getRealNum());
        this.imaginaryPart = complexNum.getRealNum();
    }

    @Override
    public double getRealNum() {
        return super.getRealNum();
    }


    @Override
    public void setRealNum(double doubleRealNum) {
        super.setRealNum(doubleRealNum);
    }


    @Override
    public String toString() {
        if (imaginaryPart > 0){
            return "ComplexNum (" + super.getRealNum() + " + " + imaginaryPart + "i)";
        }else {
            return "ComplexNum (" + super.getRealNum() + ""  + imaginaryPart + "i)";
        }
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
