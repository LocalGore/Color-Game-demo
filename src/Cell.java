public class Cell {
    public Color cellColor;
    private double xValue;
    private double yValue;
    private boolean clicked = false;
    private double delta = .55;

    public Cell(Color cellColor, double xValue, double yValue) {
        this.cellColor = cellColor;
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public void switcher(Cell that) {
        Color temp = this.getColor();
        this.setColor(that.getColor());
        that.setColor(temp);

    }

    public void draw(){
        StdDraw.setPenColor(this.cellColor.getR(),this.cellColor.getG(),this.cellColor.getB());
        StdDraw.filledRectangle(this.xValue,this.yValue, 1,1);
    }

    public void lightener(Color original){
        int newR = (int)(original.getR()*delta);
        if(newR > 255){
            newR =255;
        }
        int newG = (int)(original.getG()*delta);
        if(newG > 255){
            newG =255;
        }
        int newB = (int)(original.getB()*delta);
        if(newB > 255){
            newB =255;
        }

        this.cellColor = new Color(newR, newG,newB);
    }

    public boolean compareTo(Cell b){
        boolean comparison = false;
        if(this.getColor().getR() == b.getColor().getR() && this.getColor().getG() == b.getColor().getG() && this.getColor().getB() == b.getColor().getB()){
            comparison = true;
        }

        return comparison;
    }

    public Color getColor() {
        return cellColor;
    }
    public void setColor(Color cellColor) {
        this.cellColor = cellColor;
    }

    public void setClicked(boolean clicked) { this.clicked = clicked; }

    public double getxValue() { return xValue; }
    public double getyValue() { return yValue; }
}

