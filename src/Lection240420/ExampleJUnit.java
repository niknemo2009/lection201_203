package Lection240420;

public class ExampleJUnit {
    public static void main(String[] args) {

    }
    void one(){

    }

    public int convert(int ball) {
        int result=0;
        if(ball<60){
            result=2;
        }else if(ball<75){
            result=3;
        }else if(ball <90){
            result=4;
        }else{
            result=5;
        }

    return  result;
    }
}
