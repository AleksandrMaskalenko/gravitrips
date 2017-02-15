import java.util.Random;

public class ComputerPlayer extends Player{

    public ComputerPlayer() {
        setPlayerName("MEGAMIND");
        setToken(Token.O);
    }

    @Override
    public int getHit() {

        Random r = new Random();

        return r.nextInt(7);
    }
}
