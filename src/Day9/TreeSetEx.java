package Day9;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        //TreeSet 컬렉션 생성
        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(87);
        scores.add(77);
        scores.add(95);
        scores.add(92);
        scores.add(100);
//        System.out.println(scores);
        for (Integer score : scores){
            System.out.printf(score+"점\t");
        }
        System.out.println();
        System.out.println("최저점 : "+scores.first());
        System.out.println("가장 높은 점수 : " + scores.last());
        System.out.println("95점 기준 바로 아래 점수 : "+scores.lower(95));
        System.out.println("95점 기준 바로 위 점수 : "+scores.higher(95));
        System.out.println("85 점 : "+scores.floor(85));
        System.out.println("85 점 : "+scores.ceiling(85));


        //내림차순 정렬하기
        NavigableSet<Integer> descScores = scores.descendingSet();
        System.out.println("내림차순 정렬");
        for(Integer s : descScores) System.out.printf(s + "점 ");
        System.out.println();

        //점수기준 범위 검색 (80<=)
        NavigableSet<Integer> rangeSet = scores.tailSet(80,true);
        System.out.println("점수기준 정렬(80점 이상)");
        for(Integer range : rangeSet) System.out.printf(range + "점 ");
        System.out.println();

        //범위 검색
        rangeSet = scores.subSet(80,true,90,false);
        System.out.println("80점 ~ 90점 범위검색");
        for (Integer s : rangeSet) System.out.printf(s + "점 ");

    }
}
