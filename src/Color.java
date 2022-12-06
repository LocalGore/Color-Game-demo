public class Color {
    //red value
    private int r;
    //green value
    private int g;
    //blue value
    private int b;

    //values for the HSV color system
    private double h;
    private double s;
    private double v;

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(double hue){
        this.h = hue;
        this.s = .85;
        this.v = 1.0;

        double C = this.v * this.s;
        double X = C * (1-Math.abs((this.h/60)%2.0-1.0));
        double m = this.v - C;

        double[] array = new double[3];
        if(this.h >= 0 && this.h <60){
            array[0] = C;
            array[1] = X;
            array[2] = 0;
        } else if (this.h >= 60 && this.h <120){
            array[0] = X;
            array[1] = C;
            array[2] = 0;
        } else if (this.h >= 120 && this.h <180){
            array[0] = 0;
            array[1] = C;
            array[2] = X;
        } else if (this.h >= 180 && this.h <240){
            array[0] = 0;
            array[1] = X;
            array[2] = C;
        } else if (this.h >= 240 && this.h <300){
            array[0] = X;
            array[1] = 0;
            array[2] = C;
        } else if (this.h >= 300 && this.h <360){
            array[0] = C;
            array[1] = 0;
            array[2] = X;
        }

        double[] finalArray = new double[3];
        finalArray[0] = (array[0] + m)*255;
        finalArray[1] = (array[1] + m)*255;
        finalArray[2] = (array[2] + m)*255;

        this.r = (int)finalArray[0];
        this.g = (int)finalArray[1];
        this.b = (int)finalArray[2];
    }

    public Color(){
        this.h = (int)(Math.random()*360);
        this.s = .85;
        this.v = 1.0;

        double C = this.v * this.s;
        double X = C * (1-Math.abs((this.h/60)%2.0-1.0));
        double m = this.v - C;

        double[] array = new double[3];
        if(this.h >= 0 && this.h <60){
            array[0] = C;
            array[1] = X;
            array[2] = 0;
        } else if (this.h >= 60 && this.h <120){
            array[0] = X;
            array[1] = C;
            array[2] = 0;
        } else if (this.h >= 120 && this.h <180){
            array[0] = 0;
            array[1] = C;
            array[2] = X;
        } else if (this.h >= 180 && this.h <240){
            array[0] = 0;
            array[1] = X;
            array[2] = C;
        } else if (this.h >= 240 && this.h <300){
            array[0] = X;
            array[1] = 0;
            array[2] = C;
        } else if (this.h >= 300 && this.h <360){
            array[0] = C;
            array[1] = 0;
            array[2] = X;
        }

        double[] finalArray = new double[3];
        finalArray[0] = (array[0] + m)*255;
        finalArray[1] = (array[1] + m)*255;
        finalArray[2] = (array[2] + m)*255;

        this.r = (int)finalArray[0];
        this.g = (int)finalArray[1];
        this.b = (int)finalArray[2];
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }

    public double getH() { return h; }
}
