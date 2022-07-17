package entities;

public class OrderItem {
    
    private Integer quantity;
    private Double price;
    private Product product = new Product();

    public OrderItem() {}

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        price = product.getPrice();
    }

    /**
     * @return Integer return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Double return the price
     */
    public Double getPrice() {
        return product.getPrice();
    }

    public Double subTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + ", " + product.getPrice() + ", Quantity: " + quantity + ", Subtotal: $" + this.subTotal() ;
    }

    
}
