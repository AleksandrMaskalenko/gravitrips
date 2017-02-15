import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

    public HumanPlayer(int numberOfPlayer) throws IOException {
        String count;

        if (numberOfPlayer == 2) {
            count = "second";
            setToken(Token.O);
        } else {
            count = "first";
            setToken(Token.X);
        }
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of " + count + " player:");
            setPlayerName(reader.readLine());

    }

    @Override
    public int getHit() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int move = 0;
        boolean validMove = false;

        while (!validMove) {
            try {

                System.out.println("Enter your number from 1 to 7!");
                move = Integer.parseInt(reader.readLine());

                if ((move >= 1) && (move <= 7)) {

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
