package uk.gov.hmrc.london.util;

import org.apache.lucene.util.SloppyMath;
import uk.gov.hmrc.london.model.User;


public class DistanceCalculator {

    public static final double LONDON_LATITUDE = 51.509865d;
    public static final double LONDON_LONGITUDE = -0.118092d;

    public static final double MILE_TO_METER = 1609.344d;

    public static double getDistanceInMiles(double fromLatitude, double fromLongitude, double toLatitude, double toLongitude) {
        return SloppyMath.haversinMeters(fromLatitude, fromLongitude, toLatitude, toLongitude) / MILE_TO_METER;
    }

    public static double getDistanceFromLondonInMiles(User user) {
        return getDistanceInMiles(LONDON_LATITUDE, LONDON_LONGITUDE, user.getLatitude(), user.getLongitude());
    }

}
