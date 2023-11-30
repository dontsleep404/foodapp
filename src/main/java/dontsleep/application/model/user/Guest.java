package dontsleep.application.model.user;

public class Guest {

    private String username;

    public Guest() {
        this.username = "Guest";
    }
    
    public String getUsername() {
        return username;
    }

    public boolean canOrder(){
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
