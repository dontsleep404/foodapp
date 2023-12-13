package dontsleep.application.model.user;

public interface IUser {
    public boolean canOrder();
    public boolean canAddItem();
    public boolean canEditItem();
    public boolean isStaff();
}
