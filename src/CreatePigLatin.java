
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chris on 6/21/2017.
 *
 * See README.md for more documentation.
 */
class CreatePigLatin {

    private final static String EXIT = ("exit");
    private final static String AY = ("ay");
    private final static String YAY =("yay");
    private final static String inputFile = ("Input.txt");
    private final static String spaceRegex = ("\\s");
    private final static List<String> vowels = Arrays.asList("A", "E", "I", "O", "U", "Y", "a", "e", "i", "o", "u", "y");

    CreatePigLatin() {
        // Default ctor
    }
    // ========================================================

    void Translate() {
        File file = new File(inputFile);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String inputLine = scan.nextLine();

                String words[] = BreakIntoWords(inputLine);

                if (inputLine.equals(EXIT)) {
                    return;
                }
                for (String word : words) {

                    if( !DoesWordHaveAnyLetters(word)) {
                        System.out.print(word + " ");
                        continue;
                    }
                    int vowelOffset = FindFirstVowel(word);
                    if( vowelOffset == -1) {
                        PrintWordInPigLatin("", word, vowelOffset);
                        continue;
                    }
                    String prefix = GetPrefix(word, vowelOffset);

                    String stem = GetStem(word, vowelOffset);

                    PrintWordInPigLatin(prefix, stem, vowelOffset);
                }
                System.out.println("");
            }
            System.out.println("At end of file, without finding the word 'exit'. So we are done.");
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.toString());
            System.out.println("Input file not found here " + file.getAbsolutePath());
        }
    }
    // ========================================================

    /**
     * "tokenize" on space
     * @param inputLine The line of text from the input file
     * @return Array of Strings
     */
    private String[] BreakIntoWords(String inputLine) {

        return (inputLine.split(spaceRegex));
    }
    // ========================================================

    /**
     * Check for word having at least one letter
     * @param word The word
     * @return False if no letters found in the word.
     */
    private boolean DoesWordHaveAnyLetters(String word) {

        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(word);
        return (m.find());
    }
    // ========================================================

    /**
     * Look for the first vowel in the word
     * @param word The word
     * @return Index of vowel, else -1 for not found
     */
    private int FindFirstVowel(String word) {

        // TODO: Cut the time in half by only dealing with lower case
        // TODO: Decrease search time, by ordering the vowels by popularity.

        // It would seem that if the word is less they 7 characters, it would
        // make more sense to compare the vowels to the word, instead of the
        // word to the vowels.  The problem with doing that, is that you need
        // the first vowel.  So you would need to keep track of each hit, then
        // figure out which was had the smaller index.  Which is a lot more code.

        for (String vowel : vowels) {
            if (word.contains(vowel)) {
                return word.indexOf(vowel);
            }
        }
        return -1;
    }
    // ========================================================

    /**
     * @param word The word
     * @param vowelOffset Offset of the first vowel in the word
     * @return Substring, up to but not including the vowel
     */
    private String GetPrefix(String word, int vowelOffset) {

        return word.substring(0, vowelOffset);
    }
    // ========================================================

    /**
     * @param word The word
     * @param vowelOffset The offset of the first vowel in the word
     * @return Substring, starting at vowel
     */
    private String GetStem(String word, int vowelOffset) {

        return word.substring(vowelOffset, word.length());
    }
    // ========================================================

    /**
     * Print "stem" and "prefix" and ("AY" or "YAY")
     * @param prefix The text before the first vowel
     * @param stem The rest of the word
     * @param vowelOffset 0 for first character is vowel, -1 for no vowel found
     */
    private void PrintWordInPigLatin(String prefix, String stem, int vowelOffset) {

        System.out.print(stem + prefix);
        if (vowelOffset == 0 || vowelOffset == -1) {
            System.out.print(YAY);
        } else {
            System.out.print(AY);
        }
        System.out.print(" ");
    }
}
