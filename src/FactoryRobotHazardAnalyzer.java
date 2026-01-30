// UC5: Input Validation using if-else
// Validation logic is intentionally kept inside main method

import java.util.Scanner;

// UC5: Validation + exception handling
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        // UC1: Display system name
        System.out.println("Factory Robot Hazard Analyzer");

        Scanner scanner = new Scanner(System.in);

        // UC2: Accept inputs
        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = scanner.nextDouble();
        try {
            // UC2: Accept inputs
            System.out.print("Enter Arm Precision: ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter Worker Density: ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // clear buffer

            System.out.print("Enter Worker Density (1 - 20): ");
            int workerDensity = scanner.nextInt();
            System.out.print("Enter Machinery State (NORMAL / CRITICAL): ");
            String machineryState = scanner.nextLine();

            scanner.nextLine(); // clear buffer
            // UC5: Validation
            validateInputs(armPrecision, workerDensity, machineryState);

            // UC3: Calculation (no change)
            RobotHazardAuditor auditor = new RobotHazardAuditor();
            double hazardRiskScore =
                    auditor.calculateHazardRisk(
                            armPrecision,
                            workerDensity,
                            machineryState
                    );

            System.out.println("Robot Hazard Risk Score: " + hazardRiskScore);

        } catch (InvalidHazardInputException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = scanner.nextLine();
        scanner.close();
    }

    // UC4: Validation using if-else
    // UC5: Validation method
    private static void validateInputs(double armPrecision,
                                       int workerDensity,
                                       String machineryState)
            throws InvalidHazardInputException {

        // Validate arm precision
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            throw new InvalidHazardInputException(
                    "Error: Arm precision must be between 0.0 and 1.0"
            );
        }
        // Validate worker density
        else if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");

            if (workerDensity < 0 || workerDensity > 20) {
                throw new InvalidHazardInputException(
                        "Error: Worker density must be between 0 and 20"
                );
            }
            // Validate machinery state
            else if (
                    !machineryState.equals("Worn") &&
                            !machineryState.equals("Faulty") &&
                            !machineryState.equals("Critical")
            ) {
                System.out.println("Error: Unsupported machinery state");

                if (!machineryState.equalsIgnoreCase("NORMAL") &&
                        !machineryState.equalsIgnoreCase("CRITICAL")) {

                    throw new InvalidHazardInputException(
                            "Error: Machinery state must be NORMAL or CRITICAL"
                    );
                }
                else {
                    // UC3 logic reused (only if inputs are valid)
                }
            }

            double machineryRiskFactor = 1.0;
            /*
             * UC3: Auditor class (unchanged)
             */
            class RobotHazardAuditor {

            if (machineryState.equals("Worn")) {
                    machineryRiskFactor = 1.3;
                } else if (machineryState.equals("Faulty")) {
                    machineryRiskFactor = 2.0;
                } else if (machineryState.equals("Critical")) {
                    machineryRiskFactor = 3.0;
                }
                public double calculateHazardRisk(double armPrecision,
                                                  int workerDensity,
                                                  String machineryState) {

                    double hazardRiskScore =
                            ((1.0 - armPrecision) * 15.0) +
                                    (workerDensity * machineryRiskFactor);
                    double riskScore = armPrecision * workerDensity;

                    System.out.println("Robot Hazard Risk Score: " + hazardRiskScore);
                    if (machineryState.equalsIgnoreCase("CRITICAL")) {
                        riskScore = riskScore * 1.5;
                    }

                    scanner.close();
                    return riskScore;
                }
            }
        }