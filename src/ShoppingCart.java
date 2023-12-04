import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    ArrayList<Product> productListOfCart = new ArrayList<>();

    public void addProduct (Product item){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the product name: ");

        if(Objects.equals(item.getProductName().toLowerCase(), scanner.nextLine().toLowerCase())){ //checking if the product is available in the system
            if(item.getAvailableItemsCount() > 0){ // checking if the product is in stock
                productListOfCart.add(item);
            } else System.out.println("The product you entered is currently not in stock"); // Error message product not in stock
        } else System.out.println("The product name you entered is not available in the store"); // Error message product is not in store
    }

    public void removeProduct(Product item){
        boolean productFound = false;
        for (int i = 0; i < productListOfCart.size(); i++) {
            if(Objects.equals(productListOfCart.get(i).getProductID(), item.getProductID())){
                productListOfCart.remove(item);
                productFound = true;
                break;
            }
        }
        if(!productFound){
            System.out.println("The item you entered is not in the shopping cart");
        }
    }

    public void calculateTotal(){
        double total = 0;
        for (Product product : productListOfCart) {
            total += product.getProductPrice();
        }
        System.out.println("Total price: " + total);
    }

    public void displayProductList(){
        for (Product product : productListOfCart) {
            System.out.println(product);
        }
    }


    @Override
    public String toString() {
        return "ShoppingCart: \n" +
                "productsList=" + productListOfCart;
    }

    public static void main(String[] args) {

    }
}
