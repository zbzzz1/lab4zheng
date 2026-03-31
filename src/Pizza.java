/**
 * Project: Lab 4
 * Purpose: Pizza object with getters, setters, constructor
 * Course: IST242
 * Author: Ziyan Zheng
 * Date Developed: 3/30/26
 * Last Date Changed: 3/30/26
 * Rev: 1
 */
public class Pizza {
    /**
     * Size of pizza (small, medium, large)
     */
    private String size;

    /**
     * Crust type (thin, thick, stuffed)
     */
    private String crust;

    /**
     * Topping of pizza
     */
    private String topping;

    /**
     * Constructor for Pizza
     * @param size pizza size
     * @param crust crust type
     * @param topping pizza topping
     */
    public Pizza(String size, String crust, String topping) {
        this.size = size;
        this.crust = crust;
        this.topping = topping;
    }

    public String getSize() { return size; }
    public String getCrust() { return crust; }
    public String getTopping() { return topping; }

    public void setSize(String size) { this.size = size; }
    public void setCrust(String crust) { this.crust = crust; }
    public void setTopping(String topping) { this.topping = topping; }
}
