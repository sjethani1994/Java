package inventoryManagement;

public class Product {
    private String name;
    private String specification;
    private double cost;
    private int quantity;

    public Product(String name, String specification, double cost, int quantity) {
        this.name = name;
        this.specification = specification;
        this.cost = cost;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + "\nSpecification: " + specification +
                "\nCost: $" + cost + "\nQuantity: " + quantity;
    }
}

