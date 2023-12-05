package dontsleep.application.model;

import dontsleep.application.GlobalClient;

public class Item {
    public int id;
    public String name;
    public String description;
    public int price;
    public int type;
    public boolean isAvailable;
    public String image;
    
    public static Item getItem(int id){
        for(Item item : GlobalClient.items){
            if(item.id == id){
                return item;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
