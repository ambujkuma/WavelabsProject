package fog;
import java.util.Arrays;

public class NumerousNT {
	public int[] bestCoordinate(int[][] towers, int radius) {
        int maxQuality = 0;
        int[] maxCoordinate = new int[]{-1, -1};

        for (int x = 0; x <= 50; x++) { // Assume the maximum value of coordinates is 50
            for (int y = 0; y <= 50; y++) {
                int quality = 0;

                for (int[] tower : towers) {
                    int towerX = tower[0];
                    int towerY = tower[1];
                    int towerQuality = tower[2];

                    double distance = Math.sqrt((x - towerX) * (x - towerX) + (y - towerY) * (y - towerY));
                    if (distance <= radius) {
                        quality += towerQuality / (1 + distance);
                    }
                }

                if (quality > maxQuality) {
                    maxQuality = quality;
                    maxCoordinate = new int[]{x, y};
                }
            }
        }

        return maxCoordinate;
    }
}


