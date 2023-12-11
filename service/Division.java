package service;

import data.ComplexNum;
import data.RealNum;

public interface Division {
    
    RealNum Division(RealNum num1, RealNum num2);
    
    ComplexNum Division(ComplexNum num1, ComplexNum num2);

}
