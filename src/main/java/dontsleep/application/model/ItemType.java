package dontsleep.application.model;

import dontsleep.application.GlobalClient;

public class ItemType {
    public int id;
    public String name;
    public String description;

    public static ItemType getItemType(int id){
        for(ItemType item : GlobalClient.itemTypes){
            if(item.id == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
