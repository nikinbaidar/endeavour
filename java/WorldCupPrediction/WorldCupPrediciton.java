import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class WorldCupPrediciton {
    private static int avgTournamentsForNewWinner(HashMap<Integer, String> winners) {

        Integer [] editions = winners.keySet().toArray(new Integer[0]);

        int first_edition = editions[0];
        int latest_edition = editions[0];

        for (int i = 1; i < editions.length; i++) {
            if (editions[i] < first_edition) {
                first_edition = editions[i];
            }
            if (editions[i] > latest_edition) {
                latest_edition = editions[i];
            }
        }

        HashMap< String, List<Integer> > records = new HashMap<>();

        double mean = 0;

        int previousEditionsInWhichNewChampionFirstTime = first_edition;

        for (int year=first_edition; year<=latest_edition; year+=4) {
            String current_winner = winners.get(year);
            if (records.get(current_winner) == null)  {
                // Current winner are winners for the fist time in history.
                records.put(current_winner, new ArrayList<>(List.of(year)));
                /* No torunament due to world war 2 in 1942 and 1946 */
                if (current_winner != null) {
                    mean += (year - previousEditionsInWhichNewChampionFirstTime);
                    previousEditionsInWhichNewChampionFirstTime = year;
                }
            }
            else 
                records.get(current_winner).add(year);

        }

        mean /= ( records.size() - 2 );

        /* Calculate mean nTournamenst from mean years before a new country
         * wins the world cup. */

        mean = Math.round(mean / 4.0); 

        return (int) mean;
    }


    public static void main(String[] args) throws IOException {

        HashMap<Integer, String> winners = new HashMap<>();

        List<String> lines = Files.readAllLines(Path.of("./winners.csv"));

        for (String line: lines) {
            int year = Integer.parseInt(line.split(",")[0]);
            String winner;

            try {
                winner = line.split(",")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                winner = null;
            }

            winners.put(year, winner);
        }

        WorldCupPrediciton x = new WorldCupPrediciton();

        int avgtournaments = x.avgTournamentsForNewWinner(winners);
        System.out.println("New champion crowned for the first time after " + avgtournaments + " tournaments on average.");

    }
}
