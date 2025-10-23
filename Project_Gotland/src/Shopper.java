import java.util.ArrayList;


public class Shopper {
    
    private String name;
    private int age;
    private Basket basket;
    private ArrayList<Product> carriedProducts;
    private boolean checkedOut;


    public Shopper(String name, int age) {
        this.name = name;
        this.age = age;
        this.basket = null;
        this.carriedProducts = new ArrayList<>();
        this.checkedOut = false;
    }

    public boolean canCarryMore() {
        if(Basket != null) {
            return !basket.isFull();
        } else {
            return carriedProducts.size() < 2;
        }
    }

    public boolean addProduct(Product p) {
        if(!canCarryMore()) {
            return false;
        }
        if(Basket != null) {
            return basket.addProduct(p);
        } else {
            carriedProducts.add(p);
        }
        return true;
    }

    public boolean removeProduct(Product p) {
        if(basket != null) {
            return basket.removeProduct(p);
        } else {
            return carriedProducts.remove(p);
        }
    }

    public ArrayList<Product> getAllProducts() {
        if(basket != null) {
            return basket.getStorage().getContents();
        } else {
            return carriedProducts;
        }
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void removeBasket() {
        this.basket = null;
    }

    //getters 
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }
    public Basket getBasket() {
        return basket;
    }

    //checkout
    public void checkout() {
        checkedOut = true;
        if(basket != null) {
            basket.clear();
        }
        carriedProducts.clear();
    }

    public boolean hasCheckedOut() {
        return checkedOut;
    }

}
