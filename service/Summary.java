package service;

import data.ComplexNum;
import data.RealNum;

public interface Summary {
    
    RealNum Summary(RealNum num1, RealNum num2, boolean sign);
    
    ComplexNum Summary(ComplexNum num1, ComplexNum num2, boolean sign);

}
