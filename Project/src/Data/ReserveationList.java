package Data;

import MakeOrder.Menu.Menu;

import java.util.Vector;

public class ReserveationList {
    private String username;
    private Vector<Menu> menu;
    private ReserveationList(String username, Vector<Menu> menu){
        this.menu = menu;
        this.username = username;
    }
}
