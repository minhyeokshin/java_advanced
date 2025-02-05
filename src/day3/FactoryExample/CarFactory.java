package day3.FactoryExample;

public class CarFactory extends Factory implements IWorkingTogether{

    public CarFactory(String name,int openHour,int closeHour){
        super(name,openHour,closeHour);
    }

    @Override
    public int makeProduct(char skill) {
        switch (skill){
            case 'A':
                return 3 * getWorkingTime();
            case 'B':
                return 2 * getWorkingTime();
            case 'C':
                return 1 * getWorkingTime();
            default:
                return 0 * getWorkingTime();
        }
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return 2 * getWorkingTime();
    }

    @Override
    public String name(IWorkingTogether partner) {
        return getName();
    }
}
