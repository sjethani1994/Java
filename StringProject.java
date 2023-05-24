public class StringProject {
    public static void main(String[] args) {
        String sample_string = "This is a sample string";
        String[] words = sample_string.split(" ");
        int wordCount = words.length;
        System.out.println("Number of Words: " + wordCount);

        String sampleString = sample_string.trim();
        int characterCount = sampleString.length();
        System.out.println("Number of Characters: " + characterCount);

        // Check Length of String with spaces's removed
        String stringWithoutSpaces = sample_string.replaceAll("\\s+", "");
        int characterCountAfterSpacesRemoved = stringWithoutSpaces.length();
        System.out.println("Number of Characters after removing spaces: " + characterCountAfterSpacesRemoved);

        // Pallindrome String
        String str1 = "mad am";
        String str2 = str1.replaceAll("\\s+", "");
        StringBuilder stringBuilder = new StringBuilder(str2).reverse();
        System.out.println(stringBuilder);
        String reversedString = stringBuilder.toString();

        if (reversedString.equalsIgnoreCase(str2)) {
            System.out.println("String is pallindrome.");
        } else {
            System.out.println("String is not pallindrome.");
        }

        // Find Vowels
        String[] vowels = { "a", "e", "i", "o", "u" };
        String sampleStringArray = sample_string.trim();
        for (int i = 0; i < sampleStringArray.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (sampleStringArray.charAt(i) == vowels[j].charAt(0)) {
                    System.out.println("Found a vowel: " + vowels[j]);
                }
            }
        }

    }
}
