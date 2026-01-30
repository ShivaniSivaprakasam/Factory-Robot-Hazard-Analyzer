import java.util.Scanner;

// UC6: Enhanced hazard risk calculation
// UC7: Final integration and user-friendly output
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        System.out.println("Factory Robot Hazard Analyzer");
        System.out.println("====================================");

        Scanner scanner = new Scanner(System.in);

        try {
            // UC2: Accept inputs
            System.out.print("Enter Arm Precision (0.0 - 1.0): ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter Worker Density (0 - 20): ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // clear buffer

            System.out.print("Enter Machinery State (NORMAL / CRITICAL): ");
            String machineryState = scanner.nextLine();

            // UC5: Validation
            validateInputs(armPrecision, workerDensity, machineryState);

            // UC6: Hazard calculation
            RobotHazardAuditor auditor = new RobotHazardAuditor();
            double hazardRiskScore =
                    auditor.calculateHazardRisk(
                            armPrecision,
                            workerDensity,
                            machineryState
                    );

            // UC7: User-friendly success output
            System.out.println("------------------------------------");
            System.out.println("Hazard Analysis Completed Successfully");
            System.out.println("Calculated Hazard Risk Score : " + hazardRiskScore);
            System.out.println("------------------------------------");

        } catch (InvalidHazardInputException e) {
            // UC7: User-friendly error output
            System.out.println("------------------------------------");
            System.out.println("Hazard Analysis Failed");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------");
        }

        scanner.close();
    }

    private static void validateInputs(double arm

