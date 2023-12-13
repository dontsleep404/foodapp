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

    @Override
    public boolean isStaff() {
        return true;
    }

    @Override
    public boolean canOrder() {
        return false;
    }
    
}
