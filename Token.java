
public enum Token {
    O("o"),
    X("x"),
    EMPTY(".");

    private String token;



    Token(String token) {
        this.token = token;

    }

    public String getToken() {
        return token;
    }
}
