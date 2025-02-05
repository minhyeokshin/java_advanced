package day3.FactoryExample;

public abstract class Factory {
    private int openHour; // 공장가동시각
    private int closeHour; // 공장종료시각
    private String name;

    public int getOpenHour() {
        return openHour;
    }

    public void setOpenHour(int openHour) {
        this.openHour = openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(int closeHour) {
        this.closeHour = closeHour;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public Factory(){}
    public Factory(String name,int openHour,int closeHour){
        this.name = name;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public String getFactoryName(){
        return getName();
    };

    public int getWorkingTime(){
        return (this.getCloseHour() - this.getOpenHour());
    }

    public abstract int makeProduct(char skill);

}
