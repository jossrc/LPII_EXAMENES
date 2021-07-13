package interfaces;

import java.util.ArrayList;

import model.Shipping;

public interface ShippingInterface {

    public int register(Shipping shipping);
    
    public ArrayList<Shipping> list();
    
}
