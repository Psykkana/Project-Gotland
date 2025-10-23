public class Basket {
    
    private Equipment storage;

    public Basket() {
        storage = new Equipment(15);
    }
    //since it extends from equipment, put the same variables
    public boolean addProduct(Product p) {
        return storage.addProduct(p);
    }
    
    public boolean removeProduct(Product p) {
        return storage.removeProduct(p);
    }

    public boolean isFull() {
        return storage.isFull();
    }

    public int getItemCount() {
        return storage.getItemCount();
    }
    
    public int getCapacity() {
        return storage.getCapacity();
    }

    public void clear() {
        storage.clear(); //to clear the equipment's list of products
    } // for encapsulation
    
    public Equipment getStorage() {
        return storage;
    }


}
