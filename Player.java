
public abstract class Player {
    private String playerName;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token.getToken();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public abstract int getHit();
}
