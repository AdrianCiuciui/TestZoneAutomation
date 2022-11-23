package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Test1
        /**
         * Known issue:
         *
         *  cannot remove the spaces. Line 31.
         */

        String anagramWord = "desperation";
        String anagramExpression = "A rope ends it";
        String invalidWord = "silent";
        String invalidExpression = "Listen";

        String lowerCaseWord = anagramWord.toLowerCase();
        String lowerCaseExpression = anagramExpression.toLowerCase();

        char[] charAnagram = lowerCaseWord.toCharArray();
        char[] charExpression = lowerCaseExpression.toCharArray();

        Arrays.sort(charAnagram);
        Arrays.sort(charExpression);

        String trimmedExpression = Arrays.toString(charExpression);
        trimmedExpression = trimmedExpression.strip(); //this doesn't work
        String stringWord = Arrays.toString(charAnagram);

        boolean bool = stringWord.equals(trimmedExpression);
        System.out.println("=========== Test #1 ============");

        System.out.println("debug " + stringWord + " " + trimmedExpression);

        System.out.println("The 2 words, '" + anagramWord + "' and '" + anagramExpression + "' are: ");

        if (bool) {
            System.out.println("The same");
        } else {
            System.out.println("Not the same");
        }






//        Test 2

        int[] myNumbers = {4, 8, 6, 1, 2, 9, 4};
        int[] theDifferences = new int[myNumbers.length - 1];
        int minimumDifference = Integer.MAX_VALUE;
        int winningIndexPosition = -1;

        for (int i = 0; i < myNumbers.length - 1; i++) {
            theDifferences[i] = Math.abs(myNumbers[i] - myNumbers[i+1]);
        }


        for (int i = 0; i < theDifferences.length; i++) {
            if (theDifferences[i] < minimumDifference) {
                minimumDifference = theDifferences[i];
                winningIndexPosition = i;
            }
        }

        for (int theDifference : theDifferences) {
            if (theDifference == minimumDifference) {
                System.out.println("======== Test #2 =======\n" +
                        "The minimum distance from the array is: " + minimumDifference +
                        "\nand the position of the index is: " + winningIndexPosition);
            }
        }



    }
}