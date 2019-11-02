package com.company;

public class ConverterSwitch implements Converter {

    /**
     * This method converts the given number into its corresponding month.
     * @param monthNumber the number you wish to convert to a month
     * @return the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise
     */

    @Override
    public String convertMonth(int monthNumber) {

        String month;

        switch (monthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            //Prints  error message if the user enters a number less than 1 or greater than 12
            default:
                month = "Invalid entry. You must enter a number between 1 and 12.";
        }

        return month;
    }



    /**
     * This method converts the given number into its corresponding day of the week.
     * @param dayNumber number you wish to convert to a day of the week
     * @return the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
     * The first day of the week is Sunday
     */

    @Override
    public String convertDay(int dayNumber) {

        String day;

        switch (dayNumber) {
            case 1:
                day ="Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
            default:
                //Prints  error message if the user enters a number less than 1 or greater than 7
                day = "Invalid entry. You must enter a number between 1 and 7.";
        }

        return day;
    }
}
