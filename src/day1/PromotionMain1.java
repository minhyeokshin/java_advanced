package day1;

class AA{}
class BB extends AA{}
class CC extends AA{}
class DD extends BB{}
class EE extends CC{}

public class PromotionMain1 {
    BB bb = new BB();
    CC cc = new CC();
    DD dd = new DD();
    EE ee = new EE();

    AA a1 = bb;
    AA a2 = cc; // 상속 관계에 있음(자동변환)
    AA a3 = dd;
    AA a4 = ee;

    BB b1 = dd;
    CC c1 = ee;

//    BB b2 = ee;  컴파일에러(상속관계에 있지않다)
//    CC c2 = dd;

}
