import java.util.Scanner;

/**
 * Created by Chris on 6/20/2017.
 */
public class CreatePigLatin_Original {

    private final static String vowels[] = {"A", "E", "I", "O", "U", "Y", "a", "e", "i", "o", "u", "y"};

    public CreatePigLatin_Original() {
    }

    public void Translate() {
        Scanner scan = new Scanner("Input.txt");

        // Loop

//        String inputLine = scan.nextLine();

        String word = new String ("sandwich");

        // Check for inputLine == "exit"

        // String words [] = BreakIntoWords( inputLine);

        // Loop on words

        int vowelOffset = FindFirstVowel( word);

        String prefix = GetPrefix( word, vowelOffset);

        String stem = GetStem( word, vowelOffset);

        // Print stem + prefix + "ay"


    }
    /**
     * @param word
     * @return Index of vowel, else -1 for not found
     */
    private int FindFirstVowel(String word) {

        for(int i=0; i<vowels.length; i++) {

            if( word.indexOf(vowels[i]) >= 0);
            return i;
        }
        return -1;
    }
    /**
     * @param inputLine
     * @return
     */
    private String[] BreakIntoWords( String inputLine) {
        String spaceRegex = new String("\\s");
        return ( inputLine.split(spaceRegex));
    }
//    /**
//     * @param inputLine
//     * @param indexToStartFrom
//     * @return String, as delimited by space
//     */
//    private String GetNextWord(String inputLine, int indexToStartFrom) {
//        // inputLine.
//        //return inputLine.substring(indexToStartFrom, )
//        return Ok;
//    }
    /**
     * @param word
     * @param vowelOffset
     * @return Substring, as delimited by vowel
     */
    private String GetPrefix(String word, int vowelOffset) {
        return word.substring(0, vowelOffset-1);
    }
    /**
     * @param word
     * @param vowelOffset
     * @return Substring, starting at vowel
     */
    private String GetStem(String word, int vowelOffset) {
        return word.substring(vowelOffset, word.length());
    }
}
