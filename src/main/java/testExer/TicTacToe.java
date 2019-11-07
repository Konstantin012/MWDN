package testExer;

import java.util.Scanner;


public class TicTacToe {

    public static int number;
    public static String value;
    public static PlaiyngFiled plaiyngFiled;
    public static int whoIsNext;
    public static Scanner scanner;

    public static void main(String[] args) {
        startToPlay();
        oneMoreTime();
    }

    private static void oneMoreTime() {
        boolean bo = true;
        while (bo){
            System.out.println("Do you want to play one more time? Y/N");
            String s = scanner.nextLine().toUpperCase();
            if(s.equals("Y") | s.equals("N")){
                if(s.equals("Y"))
                    startToPlay();
                else
                    bo = false;
            }
            else {
                System.out.println("Please, enter Y or N");
                bo=true;
            }

        }
    }

    public static void startToPlay(){
        whoIsNext=1;
        plaiyngFiled= new PlaiyngFiled();
        System.out.println("Game start from X-player!");
        System.out.println("You have the next playing filed");
        plaiyngFiled.showCurrentfield();
        while (!plaiyngFiled.findTheWinner()){
            enterValue();
            if(!checkNumberIsFree(number,value))
                continue;
            plaiyngFiled.reWriteMap(number,value);
            whoIsNext++;
        }
    }

    public static boolean checkNumberIsFree(int i,String s){
        return plaiyngFiled.reWriteMap(number,value);


    }

    public static void enterValue(){
        while (!CheckEnteredValue(0));
        while (!CheckEnteredValue(1));
    }

    public static boolean CheckEnteredValue(int i) {
        scanner = new Scanner(System.in);
        Boolean point=true;
        if(i==0){
            System.out.println("Select the 'number' on the map, where you want to put your letter");
            try {
                number = Integer.parseInt(scanner.nextLine());
                   if(number>=1 & number <=9){
                    return  point;
                }
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid input! You have to choose the number from 1 to 9. Try again...");
                return  point= false;
            }
        }
        else {

            System.out.println("Write your Character");
            value = scanner.nextLine().toUpperCase();
            if(value.equals("X") | value.equals("O")){
                boolean bol = findNextPlayer();
                if(!bol) return point=false;
                return point;
            }else {
                System.out.println("Invalid input! You have to choose only 'X' or 'O' letters. Try again...");
                return point=false;
            }
        }
    }

    private static boolean findNextPlayer() {
        if (whoIsNext % 2 != 0) {
            if (value.equals("X")) {
                return true;
            } else {
                System.out.println("X-player's turn now!");
                return false;
            }
        }
        else  {
            if (value.equals("O")) {
                return true;
            } else {
                System.out.println("O-player's turn now!");
                return false;
            }
        }
    }


}
