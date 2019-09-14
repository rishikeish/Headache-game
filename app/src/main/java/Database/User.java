package Database;

public class User {

    private String username;
    private String password;

    User(){}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
