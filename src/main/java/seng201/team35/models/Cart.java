package seng201.team35.models;

/** A Class which handles Carts. Has multiple get and set methods.
 *
 */
public class Cart {
    private int size;
    private double speed;
    private String resourceType;
    private int direction;
    private int currentAmount;
    private boolean isFilled = false;

    /**Constructor for a Cart Instance.
     * Creates a Cart Instance with variable size, resourceType and speeds
     * Default direction = 0, default fillAmount = 0 (currentAmount)
     *
     * @author msh254, nsr36
     *
     * @param size
     * @param resourceType
     * @param speed
     */
    public Cart(int size, String resourceType, double speed) {
        this.size = size;
        this.currentAmount = 0;
        this.resourceType = resourceType;
        this.speed = speed;
        this.direction = 0;
    }

    /** A function which fills the Cart via altering the currentAmount
     * *can take negative amounts
     * @author msh254
     * @param fillAmount
     */
    public void fillCart(int fillAmount) {
        currentAmount += fillAmount;
    }

    /**A function which checks if the cart is filled or not.
     * @author msh254
     *
     * @return boolean isFilled
     */
    public boolean isCartFilled() {
        isFilled = currentAmount >= this.size;
        return isFilled;
    }

    /**gets the current amount the cart is at (how fill the cart is)
     *
     * @author msh254
     *
     * @return
     */
    public int getCurrentAmount() {
        return currentAmount;
    }

    /**Gets the resource type of a Cart
     *
     * @author msh254
     * @return String resourceType
     */
    public String getResourceType() {
        return resourceType;
    }

    /**returns the speed of the Cart
     *
     * @author msh254
     * @return double speed
     */
    public double getSpeed() {
        return speed;
    }

    /**gets the direction of the Cart
     * (direction is set to 0 as a default)
     * @author msh254
     *
     * @return int direction
     */
    public int getDirection() {
        return direction;
    }

    /**sets the direction of the Cart
     *
     * @param direction (int)
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /** returns the size of the Cart
     * (the Max amount the Cart can have)
     *
     * @return int size
     */
    public int getSize() {
        return size;
    }
}
