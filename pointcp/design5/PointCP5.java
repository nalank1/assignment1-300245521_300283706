public abstract class PointCP5{

    private char typeCoord;

    private double xOrRho;

    private double yOrTheta;

    public abstract double getDistance(PointCP5 other);

    public abstract PointCP5 rotatePoint(double rotation);

    public abstract char getType();
    
    public abstract double getX();

    public abstract double getY();

    public abstract double getRho();
    
    public abstract double getTheta();

    public abstract PointCP3 convertStorageToCartesian();

    public abstract PointCP2 convertStorageToPolar();
    
}