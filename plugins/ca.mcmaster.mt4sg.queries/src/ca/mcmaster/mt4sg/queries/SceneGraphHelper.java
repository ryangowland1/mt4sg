package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue;

public class SceneGraphHelper {

    // RSS parameters (representative values from the literature)
    private static final double RHO       = 0.5;   // reaction time (s)
    private static final double A_LON_MAX = 3.5;   // max lon accel during reaction (m/s^2)
    private static final double B_LON_MIN = 4.0;   // min ego braking decel (m/s^2)
    private static final double B_LON_MAX = 8.0;   // max other braking decel (m/s^2)
    private static final double A_LAT_MAX = 0.2;   // max lateral accel during reaction (m/s^2)
    private static final double B_LAT_MIN = 0.8;   // min lateral braking decel (m/s^2)
    private static final double MU        = 0.1;   // lateral fluctuation margin (m)

    /**
     * RSS minimum safe longitudinal distance (AV_Safety_Frameworks.pdf, Equation 1).
     *
     * @param vRear  longitudinal speed of rear (ego) vehicle (m/s, >= 0)
     * @param vFront longitudinal speed of front (lead) vehicle (m/s, >= 0)
     * @return minimum safe longitudinal gap (m)
     */
    public static double rssLongitudinalSafeDistance(double vRear, double vFront) {
        double reactionRear = vRear + RHO * A_LON_MAX;
        return Math.max(0.0,
            vRear * RHO
              + 0.5 * A_LON_MAX * RHO * RHO
              + (reactionRear * reactionRear) / (2.0 * B_LON_MIN)
              - (vFront * vFront) / (2.0 * B_LON_MAX));
    }

    /**
     * RSS minimum safe lateral distance (AV_Safety_Frameworks.pdf, Equation 3).
     *
     * Both arguments are non-negative lateral closing speeds toward the
     * other vehicle. The VQL converts signed lane-relative lateral
     * velocities into these closing speeds based on which side the
     * other vehicle occupies.
     *
     * vLateral convention: positive = LEFT, negative = RIGHT.
     */
    public static double rssLateralSafeDistance(double vEgoToward, double vOtherToward) {
        vEgoToward = Math.max(vEgoToward, 0.0);
        vOtherToward = Math.max(vOtherToward, 0.0);

        double egoReaction = vEgoToward + RHO * A_LAT_MAX;
        double otherReaction = vOtherToward + RHO * A_LAT_MAX;

        double safeGap =
              ((vEgoToward + egoReaction) / 2.0) * RHO
            + (egoReaction * egoReaction) / (2.0 * B_LAT_MIN)
            + ((vOtherToward + otherReaction) / 2.0) * RHO
            + (otherReaction * otherReaction) / (2.0 * B_LAT_MIN);

        return MU + Math.max(0.0, safeGap);
    }

    /**
     * Returns the distance threshold for a given semantic distance value.
     *
     * @param distVal the semantic distance value
     * @return the corresponding distance threshold (m)
     */
    public static double getDistanceThreshold(SemanticDistanceValue distVal) {
        if (distVal == null) {
            return 999.0;
        }
        switch (distVal) {
            case PRE_COLLISION: return 0.0;
            case SUPER_NEAR:     return 4.0;
            case VERY_NEAR:      return 7.0;
            case NEAR:           return 10.0;
            case VISIBLE:        return 16.0;
            default:             return 999.0;
        }
    }
    
    public static boolean isLongitudinalRSSViolation(
            double vRear, double vFront, double threshold, double bodyLengthSum) {
        return threshold < rssLongitudinalSafeDistance(vRear, vFront) + bodyLengthSum;
    }

    public static boolean isLateralRSSViolation(
            double vEgoToward, double vOtherToward, double threshold, double bodyWidthSum) {
        return threshold < rssLateralSafeDistance(vEgoToward, vOtherToward) + bodyWidthSum;
    }
    
}
