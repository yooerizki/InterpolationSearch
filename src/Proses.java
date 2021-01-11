import java.util.Scanner;

public class Proses {
    public void sortigSearch() {
        Scanner input = new Scanner(System.in);
        int arr[] = new int[15];
        int i, j, key, tukar;
        int low, high, posisi, hs;

        for (i = 0; i < arr.length; i++) {
            System.out.format("Data ke %d : ", i + 1); // loping jumlah data masuk
            arr[i] = input.nextInt();
        }

        System.out.println("Masukkan data yang dicari : ");
        key = input.nextInt();

        // sorting data
        for (i = 0; i < arr.length; i++) { // lopig array
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tukar = arr[i];
                    arr[i] = arr[j]; // swap
                    arr[j] = tukar; // tampung
                }
            }
        }
        // Data yang telah diurut
        System.out.println("Data yang sudah diurut");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // proses mencari index terdapat pada variable posisi
        hs = 0;
        low = 0;
        high = 14;
        // loping
        do {
            // rumus untuk mencari nilai pos
            posisi = ((key - arr[low]) / (arr[high] - arr[low])) * (high - low) + low;

            if (arr[posisi] == key) { // kondisi jika target sama
                hs++;
                break;
            }

            if (arr[posisi] > key)
                high = posisi - 1;

            if (arr[posisi] < key)
                low = posisi + 1;

        } while (key >= arr[low] && key <= arr[high]); // kondisi data di dalam loping

        // loping hasil
        if (hs > 0) {
            System.out.format("Data ditemukan pada index ke : %d\n", posisi);
        } else {
            System.out.print("Data tidak dalam array");
        }
    }
}

// big O dari program ini
