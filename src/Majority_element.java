
import java.util.HashMap;

public class Majority_element {

        public static void main(String[] args) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int ct = 0;
            int arr[] = {2, 4, 3, 3, 3, 3, 3, 2, 2};
            int n = arr.length;

            // Initialize the map with each element of the array and their count as 0
            for (int i = 0; i < n; i++)
                map.put(arr[i], 0);

            int max = 0, index = 0;

            // Iterate through the array and update the count of each element in the map
            for (int i = 0; i < n; i++) {
                ct = map.get(arr[i]) + 1;
                map.put(arr[i], ct);

                // Update max and index if the current count is greater than the current max
                if (ct > max) {
                    max = ct;
                    index = i;
                }
            }

            // If the count of the majority element is greater than n/2, print the majority element
            if (max > n / 2)
                System.out.println("Majority element: " + arr[index]);
            else
                System.out.println("No majority element");
        }
    }


