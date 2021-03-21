package level3_lesson6;

public class Main {

  //1. Написать метод, которому в качестве аргумента передается не пустой одномерный
  // целочисленный массив. Метод должен вернуть новый массив, который получен путем
  // вытаскивания из исходного массива элементов, идущих после последней четверки.
  // Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
  // выбросить RuntimeException.
    public int[] becomeArray(int[] array) throws RuntimeException {
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4)
                break;
            count++;
        }
        if (count == array.length) {
            throw new RuntimeException();
        }
        int[] newArray = new int[count];
        for (int i = newArray.length - 1, j = array.length - 1; i >= 0; i--, j--) {
            newArray[i] = array[j];
        }
        return newArray;
    }


    //2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    // Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    // Если содержиться число отличное от 1 и 4, то метод вернет false;
    // Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    public boolean arrayControl(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += array[i];
            if (array[i] != 4 && array[i] != 1)
                return false;
        }
        if (count == array.length || count == array.length * 4)
            return false;

        return true;
    }
}

