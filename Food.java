public class Food
{
    private int foodID;
    private String foodName;
    //constructors
    public Food(){
        this.foodID=0;
        foodName=" ";
    }
    public Food(int foodID, String foodName) {
        this.foodID = foodID;
        this.foodName = foodName;
    }
    
    //setters
    public void setFoodID(int f)
    {
        foodID=f;
    }
    public void setFoodName(String fn)
    {
        foodName=fn;
    }
    //getters
    public int getFoodID()
    {
        return foodID;
    }
    public String getFoodName()
    {
        return foodName;
    }
}