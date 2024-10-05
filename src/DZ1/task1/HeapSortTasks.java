package DZ1.task1;

import java.util.Arrays;

public class HeapSortTasks {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }

    }

    public static int[] sortTasksByPriority(int[] tasks) {
        int n = tasks.length;
        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(tasks, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = tasks[0];
            tasks[0] = tasks[i];
            tasks[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(tasks, i, 0);
        }
        return tasks;

    }

    public static void main(String[] args) {
        int[] tasks = {3, 1, 4, 2, 5};
        System.out.println(Arrays.toString(sortTasksByPriority(tasks)));
    }
}