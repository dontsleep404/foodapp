package dontsleep.application.model.user;

public class Staff extends Guest {
    
    public Staff() {
        super();
    }

    @Override
    public boolean canAddItem() {
        return true;
    }    

    @Override
    public boolean canEditItem() {
        return true;
    }
    
}
