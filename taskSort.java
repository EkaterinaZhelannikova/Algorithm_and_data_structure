import java.util.Arrays;

public class taskSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 3, 2, 3, 4, 2, 1, 1, 2, 3, 4, 4, 2, 3, 1, 4,
                2, 3, 4, 2, 1, 2, 3, 4, 2, 1, 3, 4, 2, 1, 2, 3, 4, 4, 2, 3, 3, 2, 4 };
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * Реализовать сортировку подсчетом
     * [1 2 3 3 2 3 4 2 1 1 2 3 4 4 2 3 1 4 2 3 4 2 1 2 3 4 2 1 3 4 2 1 2 3 4 4 2 3
     * 3 2 4]
     * Подсчитываем, сколько раз встречается конкретный элемент
     * 1 -> 5 (количество единиц в массиве: число взято с потолка!)
     * 2 -> 7 (количество двоек в массиве)
     * 3 -> 3
     * 4 -> 4
     * * Вставляем единицу 5 раз
     * Вставляем двойку 7 раз
     * Вставялем тройку 3 раза
     * Вставляем четверку 4 раза
     */

    static int[] countingSort(int[] array) {
        int min, max;
        max = min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        int temp = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[temp++] = i + min;
            }
        }

        for (int i = 0; i < count.length; i++) {
            int indexCount = i + 1;
            System.out.println(indexCount + " -> " + count[i]);
        }

        return array;

    }
}