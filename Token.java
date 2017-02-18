
public enum Token {
    O("o"),
    X("x"),
    EMPTY(".");

    private String token;



    Token(String token) {
        this.token = token;

    }

    @Override
    public String toString() {
        return this.token;
    }
}
