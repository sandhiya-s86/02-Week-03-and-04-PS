import java.util.*;

class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ": Risk=" + riskScore + ", Balance=" + accountBalance;
    }
}

public class PS2 {

    // Bubble Sort by riskScore ascending
    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort (Ascending Risk):");
        for (Client c : arr)
            System.out.println(c);

        System.out.println("Total Swaps = " + swaps);
    }

    // Insertion Sort by riskScore DESC + accountBalance ASC
    static void insertionSort(Client[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance > key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending Risk + Balance):");
        for (Client c : arr)
            System.out.println(c);
    }

    // Top highest risk clients
    static void topRisks(Client[] arr, int top) {
        System.out.println("\nTop " + top + " Highest Risk Clients:");
        for (int i = 0; i < top && i < arr.length; i++) {
            System.out.println(arr[i].name + " (" + arr[i].riskScore + ")");
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80, 15000),
                new Client("clientA", 20, 5000),
                new Client("clientB", 50, 10000)
        };

        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);

        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);

        topRisks(insertionArr, 3);
    }
}