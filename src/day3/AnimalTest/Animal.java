package day3.AnimalTest;

public abstract class Animal {
    private int speed; //속도 km/h
    private double distance; // 이동거리 km
    private String name;

    public Animal(int speed,String name){
        this.speed = speed;
        this.name = name;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public abstract void run();

    public double getDistance() {return distance;}

    public void setDistance(double distance) {this.distance += distance;}

    public int getSpeed() {return speed;}

    public void setSpeed(int speed) {this.speed = speed;}

    }
