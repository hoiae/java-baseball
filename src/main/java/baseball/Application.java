package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        /*do while문 사용*/
        do{
            System.out.println(BaseBallJudge(new ArrayList<Integer>(Arrays.asList(1,2,3)) , "509"));
            int judgeNum = JudgeInputNum();
            if(judgeNum == 2)
                break;
        }
        while(true);

    }

    /* 재시작, 종료 판별 메소드 구현*/
    private static int JudgeInputNum(){
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int inputNum = Integer.parseInt(readLine());
            if(inputNum == 1 )
                return 1;
            if(inputNum == 2)
                return 2;
            System.out.println("잘못된 값을 입력하셨습니다.");
        }
    }
    /* 난수 발생 메소드 구현 */
    public static List<Integer> makeRandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
        return computer;
    }

    /*입력 예외 처리, 예외 발생시 IllegalArgumentException 발생 시키기.*/
    private static String handleException(String str){
        System.out.println("실행");
        int num = 0;
        if(str.length() != 3)
            throw new IllegalArgumentException();

        try{
            num = Integer.parseInt(str);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
        return str;
    }

    /* 사용자 입력 메소드 구현*/
    private static String inputNum(){
        String str = readLine();
        String result = handleException(str);
        return result;
    }

    /* 스트라이크,볼,낫싱 판단 메소드 구현*/
    private static String BaseBallJudge(List<Integer> RandomNum, String num){

        int countBall = 0;
        int countStrike = 0;

        String result = null;

        List<Integer> numList = new ArrayList<>();
        numList.add(num.charAt(0) - '0');
        numList.add(num.charAt(1) - '0');
        numList.add(num.charAt(2) - '0');

        for(int i = 0; i < 3; i++){
            int currRandomNum = RandomNum.get(i);
            if(numList.contains(currRandomNum) && numList.get(i)==currRandomNum){
                countStrike ++;
            } else if (numList.contains(currRandomNum)) {
                countBall ++;
            }
        }

        String strikeMent = "";
        String ballMent = "";
        if(countStrike > 0)
            strikeMent = countStrike + "스트라이크";
        if(countBall > 0)
            ballMent = countBall + "볼";

        String resultMent = ballMent + " " + strikeMent;

        if(countBall + countStrike > 0 )
            return resultMent;
        return "낫싱";
    }
//    private static int isStrike(int currindex, int currRandomNum, List<Integer> numList){
//        if(numList.get(currindex) == currRandomNum)
//            return 1;
//        return -1;
//    }
}
