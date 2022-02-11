package shop;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> productsInBasket = new ArrayList<>();

    public void addProduct(Product product){
        productsInBasket.add(product);
    }

    public ArrayList<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public Product getProductByIndexFromBasket(int index) {
        return productsInBasket.get(index);
    }

    public void setProductsInBasket(ArrayList<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

}
