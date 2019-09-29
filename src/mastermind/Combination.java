package mastermind;

public class Combination {
    
    private Color colorOne,colorTwo,colorThree,colorFour;
    
    public Color getColorOne(){
        return colorOne;
    }
    
    public Color getColorTwo(){
        return colorTwo;
    }
    
    public Color getColorThree(){
        return colorThree;
    }
    
    public Color getColorFour(){
        return colorFour;
    }
    
    public void setColorOne(Color colorOne){
        this.colorOne = colorOne;
    }
    
    public void setColorTwo(Color colorTwo){
        this.colorTwo = colorTwo;
    }
    
    public void setColorThree(Color colorThree){
        this.colorThree = colorThree;
    }
    
    public void setColorFour(Color colorFour){
        this.colorFour = colorFour;
    }
    
    public Color searchColor(char nameColor){
        for (Color color : Color.values()){
            if (color.name().equals(String.valueOf(nameColor)))
                return color;
        }
        return null;
    }
}
