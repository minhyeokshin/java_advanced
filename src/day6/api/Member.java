package day6.api;


public class Member {
    String id;
    String name;

    public Member(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){  //Object 의 equal()메소드 재정의
        if (obj instanceof Member target){ //obj Member 타입인지 검사하고 타입변환 후 target 변수에 대입
            if (id.equals(target.id)){  //id 문자열이 같은지 비교 같으면 같은회원
                return true;
            }
        }
        return false;   //같지 않으면 false 리턴
    }
}
