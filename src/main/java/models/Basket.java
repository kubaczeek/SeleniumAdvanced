package models;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> productsInBasket = new ArrayList<>();

    public void addProduct(Product product) {
        productsInBasket.add(product);
    }

    public ArrayList<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(ArrayList<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    public Product getProductByIndex(int index) {
        return productsInBasket.get(index);
    }

    public int getItemsQuantity() {
        int count = 0;
        for (Product productFromBasket : getProductsInBasket()) {
            count += productFromBasket.getQuantity();
        }
        return count;
    }

    public void addProductToBasket(Product product) {
        for (Product productFromBasket : getProductsInBasket()) {
            if (productFromBasket.getName().equals(product.getName()) && productFromBasket.getPrice() == product.getPrice()) {
                productFromBasket.setQuantity(productFromBasket.getQuantity() + product.getQuantity());
                return;
            }
        }
        addProduct(product);
    }
}
