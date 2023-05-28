/*
 * abstract class with designs 2 and 3 as subclasses
 * 
 * depends on the concrete class
 */

 public abstract class PointCP5{

    //Instance variables ************************************************

    /**
    * Contains C(artesian) or P(olar) to identify the type of
    * coordinates that are being dealt with.
    */
    private char typeCoord;

    /**
    * Contains the current value of X or RHO depending on the type
    * of coordinates.
    */
    private double xOrRho;

    /**
    * Contains the current value of Y or THETA value depending on the
    * type of coordinates.
    */
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
    
    //Constructors ******************************************************

    /**
    * Constructs a coordinate object, with a type identifier.
    */
    public PointCP5(char type, double xOrRho, double yOrTheta){
        if(type != 'C' && type != 'P'){
            throw new IllegalArgumentException();
        } else if(type == 'P'){
            this.xOrRho = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
            this.yOrTheta = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
        } else{
            this.xOrRho = xOrRho;
            this.yOrTheta = yOrTheta;
        }
    }

    public class PointCP2 extends PointCP5{

        private double rho;

        private double theta;

        public double getX(){
            return (Math.cos(Math.toRadians(theta)) * rho);
        }

        public double getY(){
            return (Math.sin(Math.toRadians(theta)) * rho);
        }

        public double getRho(){
            return rho;
        }

        public double getTheta(){
            return theta;
        }

        public PointCP2(char type, double xOrRho, double yOrTheta){
            super(type, xOrRho, yOrTheta);
        }

        public PointCP3 convertStorageToCartesian(){

            double yOrTheta = getY();
            double xOrRho = getX();

            char typeCoord = 'C';

            return new PointCP3(typeCoord, xOrRho, yOrTheta);
        }
        /**
        * Calculates the distance in between two points using the Pythagorean
        * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
        *
        * @param pointA The first point.
        * @param pointB The second point.
        * @return The distance between the two points.
        */
        public double getDistance(PointCP2 pointB){

            double deltaX = getX() - pointB.getY();
            double deltaY = getY() - pointB.getY();

            return Math.sqrt((Math.pow(deltaX, 2)) + Math.pow(deltaY,2));

        }

        /**
        * Rotates the specified point by the specified number of degrees.
        * Not required until E2.30
        *
        * @param point The point to rotate
        * @param rotation The number of degrees to rotate the point.
        * @return The rotated image of the original point.
        */

        public PointCP rotatePoint(double rotation){
            double radRotation = Math.toRadians(rotation);
            double x1 = getX();
            double y1 = getY();
            double x2 = (Math.cos(radRotation) * x1) - (Math.sin(radRotation) * y1);
            double y2 = (Math.sin(radRotation) * x1) - (Math.cos(radRotation) * y1);

            return new PointCP('C', x2, y2);
        }

        /**
        * Returns information about the coordinates.
        *
        * @return A String containing information about the coordinates.
        */
        public String toString(){
            if(typeCoord == 'C'){
                return "Stored as Cartesian ( " + getX() + "," + getY() + ")";
            } 
            return "Stored as Polar [" + getRho() + ", " + getTheta()+ "]";           
        }

    }

    public class PointCP3 extends PointCP5{
        public PointCP3(char type, double xOrRho, double yOrTheta){
            super(type, xOrRho, yOrTheta);
        }
        
    

        public double getX(){
            return xOrRho;
        }

        public double getY(){
            return yOrTheta;
        }

        public double getRho(){
            return (Math.sqrt(Math.pow(xOrRho,2)) + Math.pow(yOrTheta, 2));
        }

        public double getTheta(){
            return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
        } 

        /**
        * Converts Cartesian coordinates to Polar coordinates.
        */
        public PointCP2 convertStorageToPolar(){
            yOrTheta = getTheta();
            xOrRho = getRho();

            char typeCoord = 'P';

            return new PointCP2(typeCoord, xOrRho, yOrTheta);
        }

        /**
        * Calculates the distance in between two points using the Pythagorean
        * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
        *
        * @param pointA The first point.
        * @param pointB The second point.
        * @return The distance between the two points.
        */
        public double getDistance(PointCP3 pointB){
            double deltaX = getX() - pointB.getX();
            double deltaY = getY() - pointB.getY();

            return Math.sqrt((Math.pow(deltaX, 2))+ Math.pow(deltaY, 2));
        }

        /**
        * Rotates the specified point by the specified number of degrees.
        * Not required until E2.30
        *
        * @param point The point to rotate
        * @param rotation The number of degrees to rotate the point.
        * @return The rotated image of the original point.
        */
        public PointCP3 rotatePoint(double rotation){
            double radRotation = Math.toRadians(rotation);
            double X = getX();
            double Y = getY();

            return new PointCP3('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
            (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
        }

         /**
        * Returns information about the coordinates.
        *
        * @return A String containing information about the coordinates.
        */
        public String toString()
        {
            return "Stored as " +"Cartesian  (" + getX() + "," + getY() + ")";
        }


    
}
}