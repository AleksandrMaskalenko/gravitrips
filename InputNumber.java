import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputNumber {

    static int move;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public int getHit() {
        boolean validMove = false;
        while (!validMove) {
            try {
                System.out.println("Enter your number from 1 to 7!");
                int move = Integer.parseInt(reader.readLine());
                if ((move >= 1) && (move <= 7)) {
                    this.move = move;
                    validMove = true;
                } else {
                    System.out.println("Try again. Please set valid number range (1-7)");
                }

            } catch (Exception e) {
                System.out.println("Wrong!!! Please enter valid move!!!");
            }
        }

        return move-1;

    }
}
