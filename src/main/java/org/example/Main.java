package org.example;

public class Main {

    public static void main(String[] args) {

//        Test1
        String anagramWord = "desperation";
        String anagramExpression = "a rope ends it";
        String invalidWord = "desperationn";
        String invalidExpression = "a rope ends i";





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