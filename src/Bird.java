public class Bird {
    
    float x = 50;
    float y = 310;

    float yVel = 0;
    double yAcceleration = 0;

    public Bird(){

    }

    public float[] getPosition(){
        return new float[] {x,y};
    }

    public void applyGravity(){
        yAcceleration += 0.0005;
        yVel += yAcceleration;
        y += yVel;
    }

    public void jump(){
        yAcceleration = 0;
        yVel = 0;
        yVel -= 2;
        System.out.print("jump");
    }

}
