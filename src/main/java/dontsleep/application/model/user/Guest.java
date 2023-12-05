package dontsleep.application.model.user;

public class Guest implements IUser{

    private String username;

    public Guest() {
        this.username = "Guest";
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean canOrder() {
        return true;
    }

    @Override
    public boolean canAddItem() {
        return false;
    }

    @Override
    public boolean canEditItem() {
        return false;
    }

}
