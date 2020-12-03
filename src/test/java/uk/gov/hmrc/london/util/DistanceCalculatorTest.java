package uk.gov.hmrc.london.util;

import org.junit.jupiter.api.Test;
import uk.gov.hmrc.london.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.hmrc.london.util.DistanceCalculator.LONDON_LATITUDE;
import static uk.gov.hmrc.london.util.DistanceCalculator.LONDON_LONGITUDE;

class DistanceCalculatorTest {

    public static final double KAX_LATITUDE = 34.003135d;
    public static final double KAX_LONGITUDE = -117.7228641d;

    @Test
    public void testGetDistanceInMiles() {
        double kaxDistanceFromLondonInMiles = DistanceCalculator.getDistanceInMiles(LONDON_LATITUDE, LONDON_LONGITUDE, KAX_LATITUDE, KAX_LONGITUDE);
        assertThat(kaxDistanceFromLondonInMiles).isEqualTo(5426.752435345267);
    }

    @Test
    public void testGetDistanceFromLondonInMiles() {
        User aUserLivingInKax = new User();
        aUserLivingInKax.setLatitude(KAX_LATITUDE);
        aUserLivingInKax.setLongitude(KAX_LONGITUDE);
        double kaxDistanceFromLondonInMiles = DistanceCalculator.getDistanceFromLondonInMiles(aUserLivingInKax);
        assertThat(kaxDistanceFromLondonInMiles).isEqualTo(5426.752435345267);
    }
}