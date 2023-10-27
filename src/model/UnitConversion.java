package model;
import org.osgeo.proj4j.*;


public class UnitConversion {
	    public static void main(String[] args) {
	        // Define the input coordinates (latitude and longitude)
	        double latitude = 37.7749; // Example latitude
	        double longitude = -122.4194; // Example longitude

	        // Define the map projection parameters
	        String sourceProjection = "+proj=longlat +datum=WGS84 +no_defs"; // Input projection (WGS84)
	        String targetProjection = "+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +no_defs"; // Output projection (Mercator)

	        // Create a CoordinateTransformFactory and CoordinateTransform objects
	        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
	        CoordinateTransform transform = ctFactory.createTransform(sourceProjection, targetProjection);

	        // Create a ProjCoordinate object for the input coordinates
	        ProjCoordinate srcCoord = new ProjCoordinate(longitude, latitude);

	        // Create a ProjCoordinate object to store the output coordinates
	        ProjCoordinate targetCoord = new ProjCoordinate();

	        // Perform the coordinate transformation
	        transform.transform(srcCoord, targetCoord);

	        // Access the x and y values of the target coordinates
	        double x = targetCoord.x;
	        double y = targetCoord.y;

	        // Print the x and y values
	        System.out.println("X: " + x);
	        System.out.println("Y: " + y);
	    }
	}
