package coding_skills.question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParkingBill {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        System.out.println("Entry time:");
        String entryTime = br.readLine().trim();
        if(!isValidLocalTime(entryTime)) {
            System.out.println("Please provide a valid input time");
            System.exit(0);
        }

        System.out.println("Exit time:");
        String exitTime = br.readLine().trim();
        if(!isValidLocalTime(exitTime)) {
            System.out.println("Please provide a valid exit time");
            System.exit(0);
        }

        int parkingCharge = solution(entryTime, exitTime);
        System.out.println(parkingCharge);

        wr.close();
        br.close();
    }

    /**
     * The first full or partial hour costs 3;
     * Each successive full or partial hour (after the first) costs 4.
     * @param entry
     * @param exit
     * @return
     */
    static int solution(String entry, String exit) {
        // Starting charge is set to 2 due to entrance fee
        int charge = 2;

        LocalTime inTime = LocalTime.parse(entry);
        LocalTime outTime = LocalTime.parse(exit);

        Duration duration = Duration.between(inTime, outTime);

        long hours = duration.toHours();
        int minutes = duration.toMinutesPart();

        if(hours > 0) {
            // 3 is added at the end as a fee for initial hour
            charge += ((hours-1) * 4) + 3;
        }
        // Checking a case of partial hour
        if(minutes > 0) {
            // This is case of initial hour
            if(charge == 2) {
                charge += 3;
            } else {
                charge += 4;
            }
        }

        return charge;
    }

    static boolean isValidLocalTime(String inputTime) {
        try {
            LocalTime.parse(inputTime, formatter);
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }
}
