import java.util.ArrayList;

public class Equipment {

    private int nCapacity;
    private ArrayList<Product> contents;

    //the constrcutor

    public Equipment(int nCapacity) {
        this.nCapacity = nCapacity;
        this.contents = new ArrayList<>();
    }

    //this method is to add a product if there is space

    public boolean addProduct(Product p) {

        if(contents.size() < nCapacity) {
            contents.add(p);
            return true;
        }
        return false; // full
    }

    public boolean removeProduct(Product p) {
        return contents.remove(p);
    }

    public boolean isFull() {
        return contents.size() >= capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public ArrayList<Product> getContents() {
        return contents;
    }

    public int getItemCount() {
        return contents.size();
    }


}
