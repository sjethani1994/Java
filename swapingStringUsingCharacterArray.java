public class swapingStringUsingCharacterArray {
    public static void main(String[] args) {
        String str = "abc";
        generateCombinations(str);
    }

    public static void generateCombinations(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;

        generateHelper(charArray, length, 0);
    }

    private static void generateHelper(char[] charArray, int length, int currentIndex) {
        if (currentIndex == length - 1) {
            System.out.println(String.valueOf(charArray));
            return;
        }

        for (int i = currentIndex; i < length; i++) {
            swap(charArray, currentIndex, i);
            generateHelper(charArray, length, currentIndex + 1);
        }
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
