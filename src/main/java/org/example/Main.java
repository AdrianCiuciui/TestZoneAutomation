package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Test1
        String anagramWord = "desperation";
        String anagramExpression = "A rope ends it";
        String invalidWord = "desperationn";
        String invalidExpression = "a rope ends i";


        String lowerCaseWord = anagramWord.toLowerCase();
        String lowerCaseExpression = anagramExpression.toLowerCase();
        String trimmedExpression = lowerCaseExpression.trim();


        char[] charAnagram = lowerCaseWord.toCharArray();
        char[] charExpression = trimmedExpression.toCharArray();

        Arrays.sort(charAnagram);
        Arrays.sort(charExpression);


        boolean bool = Arrays.equals(charAnagram, charExpression);
        System.out.println("=========== Test #1 ============");

        System.out.println("debug " + Arrays.toString(charAnagram) + " " + Arrays.toString(charExpression));

        System.out.println("The 2 words, " + anagramWord + " and " + anagramExpression + " are: ");

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