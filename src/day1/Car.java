package day1;

class Car {
    public int speed = 0;

     public final void stop(){
         System.out.println("차량을 멈춥니다.");
         speed = 0;
     }

     public void speedUP(){
         speed++;
     }

     public void show(){
         System.out.println("현재 스피드 : " + speed);
     }
}