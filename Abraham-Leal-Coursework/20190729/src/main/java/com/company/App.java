package com.company;

public class App {
    public static int total(int[] inputArray) {

        int total = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            total = total + inputArray[i];
        }
        return total;
    }

    //Returns the sum of only the values of the odd numbered indexes in an array of any size consisting of ints.
    public static int totalOdd(int[] inputArray) {
        int total = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 1) {
                total = total + inputArray[i];
            }

        }
        return total;
    }

    public static int totalEven(int[] inputArray) {
        int total = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                total = total + inputArray[i];
            }
        }
        return total;
    }

    //Returns the second largest number in an array of any size consisting of ints, assuming
    //input array will always have a length of at least 2.
    public static int secondLargestNumber(int[] inputArray) {

        int max1;
        int max2;
        if (inputArray[0] > inputArray[1]) {
            max1 = inputArray[0];
            max2 = inputArray[1];
        } else {
            max1 = inputArray[1];
            max2 = inputArray[0];
        }
        for (int i = 2; i < inputArray.length; i++) {
            if (inputArray[i] > max1 && inputArray[i] > max2) {
                max2 = max1;
                max1 = inputArray[i];
            } else if (inputArray[i] > max2) {
                max2 = inputArray[i];
            }

        }
        return max2;
    }

    //Takes in an array of any size consisting of strings, swaps the first and last elements,
    // and returns the array.
    public static String[] swapFirstAndLast(String[] inputArray) {
        String buffer;
        buffer = inputArray[0];
        inputArray[0] = inputArray[inputArray.length - 1];
        inputArray[inputArray.length - 1] = buffer;
        return inputArray;
    }

    //Takes in an array of any size consisting of ints and returns a new array with the array reversed.
    public static int[] reverse(int[] inputArray) {


        int reverseCounter = inputArray.length;
        int[] outputArray = new int[reverseCounter];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[reverseCounter - 1] = inputArray[i];
            reverseCounter = reverseCounter - 1;
        }

        return outputArray;
    }

    //Takes in an array of any size consisting of strings  and returns a String which
    //consists of the concatenation of all elements in the array.
    public static String concatenateString(String[] inputArray) {
        String concatenatedString = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            concatenatedString = concatenatedString + inputArray[i];
        }

        return concatenatedString;
    }

    //Takes in an array any size consisting of ints and returns an array which consists of every
    //third element.  If there are fewer than three elements in the array, will return null.
    public static int[] everyThird(int[] inputArray) {

        int x = 0;

        int[] outputArray = new int[inputArray.length / 3];
        if (inputArray.length - 1 < 3) {
            return null;
        } else {

            for (int i = 2; i < inputArray.length; i = i + 3) {
                outputArray[x] = inputArray[i];
                x++;
            }
        }
        return outputArray;

    }

    //Takes in an array of any size consisting of ints, finds the elements which are less than five,
    //and returns an array containing those elements. If there are no elements less than five, will return null.
    public static int[] lessThanFive(int[] inputArray) {

        int counter = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 5) {
                counter = counter + 1;
            }

            if (counter == 0) {
                return null;
            }

        }
        int[] outputArray = new int[counter];
        int x = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 5) {
                outputArray[x] = inputArray[i];
                x++;
            }
        }
        return outputArray;

    }

    //Takes in an array of any size consisting of ints then splits the array into two
    // new arrays, one holding the values less than 5 and the other holding the values equal to or greater than 5.
    // Returns a two-dimensional array, with the small-value array first.
    public static int[][] splitAtFive(int[] inputArray) {
        int counter = 0;
        int counter2 = 0;
        //Determines the length of the two new arrays
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 5) {
                counter = counter + 1;
            } else {
                counter2 = counter2 + 1;
            }
        }
        //Creates the two new arrays
        int[] outputArray1 = new int[counter];
        int[] outputArray2 = new int[counter2];

        int x = 0;
        int y = 0;
        //Populates the two new arrays
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < 5) {
                outputArray1[x] = inputArray[i];
                if (x != counter - 1) {
                    x++;
                }
            } else {
                outputArray2[y] = inputArray[i];
                if (y != counter2 - 1) {
                    y++;
                }
            }
        }
        //Creates the new two dimensional array
        int[][] outputArray = new int[2][];
        for (int i = 0; i < 2; i++) {
            outputArray[i] = new int[outputArray1.length];
            if (i == 1) {
                outputArray[i] = new int[outputArray2.length];
            }
        }
        //Populates the less than five array
        for (int i = 0; i < outputArray1.length; i++) {
            outputArray[0][i] = outputArray1[i];
        }
        //Populates the greater than or equal to five array
        for (int i = 0; i < outputArray2.length; i++) {
            outputArray[1][i] = outputArray2[i];
        }
        return outputArray;
    }

    //Takes in an array of Strings. Create two new arrays, one holding
    // the values of the even indices and the other the values of the odd. Returns a two-dimensional array, with
    // the even-indices array first. Your code should work for an array of any size.
    public static String[][] evensAndOdds(String[] inputArray) {
        int counter = 0;
        int counter2 = 0;
        //Determines the length of the two new arrays
        if (inputArray.length % 2 == 0) {
            counter = inputArray.length / 2;
            counter2 = counter;
        } else {
            counter = (inputArray.length / 2) + 1;
            counter2 = inputArray.length / 2;
        }
        //Create new arrays
        String[] outputArray1 = new String[counter];
        String[] outputArray2 = new String[counter2];
        int x = 0;
        int y = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 == 0) {
                outputArray1[x] = inputArray[i];
                if (x != counter - 1) {
                    x++;
                }
            } else {
                outputArray2[y] = inputArray[i];
                if (y != counter2 - 1) {
                    y++;
                }
            }
        }
        //Creates the two dimensional array
        String[][] outputArray = new String[2][];
        for (int i = 0; i < 2; i++) {
            outputArray[i] = new String[outputArray1.length];
            if (i == 1) {
                outputArray[i] = new String[outputArray2.length];
            }
        }
        //Populates even indices in first array of two dimensional array
        for (int i = 0; i < outputArray1.length; i++) {
            outputArray[0][i] = outputArray1[i];
        }
        //Populates odd indices in second array of two dimensional array
        for (int i = 0; i < outputArray2.length; i++) {
            outputArray[1][i] = outputArray2[i];
        }


        return outputArray;
    }


    public static void main(String[] args) {
        int[] array1 = {1, 27, 9, 8, 16};

        System.out.println(App.total(array1));
        System.out.println(App.totalOdd(array1));
        System.out.println(App.totalEven(array1));
        System.out.println(App.secondLargestNumber(array1));
        System.out.println();

    }

}

