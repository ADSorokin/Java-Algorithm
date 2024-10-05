package DZ1.task2;

import java.util.Arrays;

public class RadixSortPhoneNumbers {
    public static void countingSort(long[] arr, long exp) {
        int n = arr.length;
        long[] output = new long[n]; // результирующий массив
        int[] count = new int[10]; // массив счетчиков для цифр 0-9

        // Заполняем массив счетчиков
        for (int i = 0; i < n; i++) {
            int digit = (int) (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Преобразуем массив счетчиков в массив накопленных счетчиков
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Формируем результирующий массив
        for (int i = n - 1; i >= 0; i--) {
            int digit = (int)(arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копируем отсортированные числа обратно в исходный массив
        System.arraycopy(output, 0, arr, 0, n);
// ваша реализация
    }
    public static long[] sortPhoneNumbers(long[] arr) {
        // Найдем максимальное число, чтобы знать количество проходов
        long max = Arrays.stream(arr).max().orElse(0);

        // Выполняем сортировку с учетом каждой цифры.
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);

// ваша реализация
        return arr;
    }
    public static void main(String[] args) {
        long[] phoneNumbers = {9876543210L, 1234567890L,
                5555555555L, 1000000000L};
        System.out.println(Arrays.toString(sortPhoneNumbers(phoneNumbers)));
    }

}
