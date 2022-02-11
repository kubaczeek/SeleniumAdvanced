package shop;

public class Product {
    private String name;
    private float price;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class ProductBuilder {

        private String name;
        private float price;
        private int quantity;

        public ProductBuilder(Product product) {
            this.name = product.name;
            this.price = product.price;
            this.quantity = product.quantity;
        }

        public ProductBuilder() {

        }

        public Product.ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Product.ProductBuilder price(float price) {
            this.price = price;
            return this;
        }

        public Product.ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.name = this.name;
            product.price = this.price;
            product.quantity = this.quantity;
            return product;
        }
    }
}
