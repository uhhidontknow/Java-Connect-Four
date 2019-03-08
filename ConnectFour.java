// 7 columns, 6 rows. 13 columns for rich formatting, 11 rows for rich formatting
import java.util.*;


public class ConnectFour{
    public static void main(String[] args){
        Rack r = new Rack();
        Scanner scan = new Scanner(System.in);
        int firstPlayer = 0;
        boolean keepPlaying = true;
        
        while(keepPlaying){
            if(firstPlayer == 0){
                System.out.print("Enter a column to put a piece into (1-7): ");
                int input = scan.nextInt();
                r.play(input);
                if(r.checkFour("x")){
                    System.out.println("You win! Do you want to keep playing? (Y/n)");
                    String input2 = scan.next();
                    if(input2.equalsIgnoreCase("n")){
                        keepPlaying = false;
                    }else{
                        firstPlayer = 1;
                        r.cleanup();
                    }
                }
                r.cpuPlay();
                if(r.checkFour("o")){
                    System.out.println("You lose! Do you want to keep playing? (Y/n)");
                    String input2 = scan.next();
                    if(input2.equalsIgnoreCase("n")){
                        keepPlaying = false;
                    }else{
                        firstPlayer = 1;
                        r.cleanup();
                    }
                }
            }
            if(firstPlayer == 1){
                System.out.print("Enter a column to put a piece into (1-7): ");
                int input = scan.nextInt();
                r.play(input);
                if(r.checkFour("x")){
                    System.out.println("You win! Do you want to keep playing? (Y/n)");
                    String input2 = scan.next();
                    if(input2.equalsIgnoreCase("n")){
                        keepPlaying = false;
                    }else{
                        firstPlayer = 0;
                        r.cleanup();
                    }
                }
                r.cpuPlay();
                if(r.checkFour("o")){
                    System.out.println("You lose! Do you want to keep playing? (Y/n)");
                    String input2 = scan.next();
                    if(input2.equalsIgnoreCase("n")){
                        keepPlaying = false;
                    }else{
                        firstPlayer = 0;
                        r.cleanup();
                    }
                }
            }
        }
    }
}
