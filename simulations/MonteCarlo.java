package simulations;


public class MonteCarlo {
    public double pi(int iteration){
        double X = Math.random();
        double Y = Math.random();
        double distance;
        int circlePoint=0,squarePoint;
        for (int i = 0; i < iteration; i++) {
            X = Math.random();
            Y = Math.random();
            distance = Math.pow(X, 2) + Math.pow(Y, 2);
            if (distance <= 1) {
                circlePoint++;
            }
        }
        squarePoint = iteration;
        return 4*circlePoint/(double)squarePoint;
    }
    public double squareRoot(int number, int iteration){
        double X;
        double rootCount=0;
        for (int i = 0; i < iteration; i++) {
            X = Math.random()*number;
            if (X*X <= number) {
                rootCount++;
            }
        }
        return (double)rootCount/(double)iteration*number;
    }
    public static void main(String[] args) {
        MonteCarlo m = new MonteCarlo();
        for (int i = 0; i < 11; i++) {
            
            System.out.println(m.squareRoot(5,99999));
        }
        
    }
}
