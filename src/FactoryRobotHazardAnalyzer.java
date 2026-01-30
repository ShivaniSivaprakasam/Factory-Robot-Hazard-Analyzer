import java.util.Scanner;

// UC5: Validation + exception handling
// UC6: Enhanced hazard risk calculation
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            double armPrecision = scanner.nextDouble();
            int workerDensity = scanner.nextInt();
            String machineryState = scanner.next();

            // UC5: Validation
            validateInputs(armPrecision, workerDensity, machineryState);

            // UC3: Calculation (no change)
            // UC6: Final hazard calculation
            RobotHazardAuditor auditor = new RobotHazardAuditor();
            double hazardRiskScore =
                    auditor.calculateHazardRisk(
                            armPrecision,
                            workerDensity,
                            machineryState
                    );

            System.out.println("Final Hazard Risk Score: " + hazardRiskScore);

        } catch (InvalidHazardInputException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // UC5: Validation method
    // UC5: Validation logic (unchanged)
    private static void validateInputs(double armPrecision,
                                       int workerDensity,
                                       String machineryState)
            throws InvalidHazardInputException {

        if (armPrecision <= 0 || workerDensity <= 0) {
            throw new InvalidHazardInputException("Invalid numeric input");
        }

        if (!machineryState.equalsIgnoreCase("CRITICAL")
                && !machineryState.equalsIgnoreCase("NORMAL")) {
            throw new InvalidHazardInputException("Invalid machinery state");
        }
    }
}

/*
 * UC3: Auditor class (unchanged)
 * UC6: Finalized hazard risk calculation logic
 */
class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryState) {

        // Base risk
        double riskScore = armPrecision * workerDensity;

        // Machinery impact
        if (machineryState.equalsIgnoreCase("CRITICAL")) {
            riskScore = riskScore * 1.5;
        } else {
            // NORMAL state
            riskScore = riskScore * 1.0;
        }

        return riskScore;
    }
}
