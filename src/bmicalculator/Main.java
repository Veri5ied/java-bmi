package bmicalculator;
import java.util.*;
import java.text.*;

public class Main {

    final static double KG_TO_LBS = 2.20462;
    final static double M_TO_IN = 39.3701;
    private static DecimalFormat TWO_DECIMAL_PLACES = new DecimalFormat(".##");

    public static void main(String[] args) {
        int age;
        String surName, firstName, gender, stateOfOrigin, address, phone;
        double height, weight;

        System.out.println("######.......A BMI CALCULATOR BY GROUP 5........#######");
        System.out.println();

        //Scanner passed below is for reading input in Java programme. Values are obtained with the scanner and the java.util packages
        Scanner sc = new Scanner(System.in);
        Scanner askUser = new Scanner(System.in);

        //Acceptance of users input goes below....
        System.out.println("Please enter your Surname: ");
        surName = sc.nextLine();
        if (surName == null) {
            System.out.println("Wrong entry, please try again");
            surName = sc.nextLine();
            return;
        }

        System.out.println("Please enter your First Name: ");
        firstName = sc.nextLine();

        System.out.println("Please enter your Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter Gender: ");
        gender = sc.nextLine();

        System.out.println("Please enter your State Of Origin: ");
        stateOfOrigin = sc.nextLine();

        System.out.println("Please enter your Address: ");
        address = sc.nextLine();

        System.out.println("Please enter your Phone Number: ");
        phone = sc.nextLine();
        System.out.println("Details successfully saved.......");
        System.out.println();

        System.out.println("What is your weight (kg)?: ");
        weight = askUser.nextDouble();

        System.out.println("What is your height (m)?: ");
        height = askUser.nextDouble();

        System.out.println();
        System.out.println("*************************************************************************");
        System.out.println("Name: " + surName + " " + firstName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("State Of Origin: " + stateOfOrigin);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phone);
        System.out.println();
        System.out.println("Thank you for using our BMI Calculator. Your result should be displayed below in kg and pounds of which you can go with your preferred unit");

        System.out.println("*************************************************************************");
        System.out.println("Hello, " + surName + "  " + firstName + " Your body weight is: ");
        System.out.println("In metrics units: " + TWO_DECIMAL_PLACES.format(metricFormula(height, weight)) + "kg");
        System.out.println("In Imperial units: " + TWO_DECIMAL_PLACES.format(imperialFormula(height, weight)) + "lbs");
        System.out.println("From the result obtained above, you are " + getCategory(metricFormula(height, weight)));

        System.out.println("*************************************************************************");
        System.out.println("Please take note of your medical report below...");
        System.out.println(medicalAdvice(metricFormula(height, weight)));

        askUser.close();
        System.exit(0);
    }

    //Code for the metric formula for weight calculation goes below................
    public static double metricFormula(double m, double kg) {
        double result = 0;

        result = kg / (Math.pow(m, 2));
        return result;
    }

    //Code for the imperial formula goes below...............
    public static double imperialFormula(double m, double kg) {
        double result = 0;
        double lbs = Math.round(kg * KG_TO_LBS);
        double in = Math.round(m * M_TO_IN);

        result = (lbs / (Math.pow((in / 100), 2))) * 703;

        return result;
    }

    //Yaay!!!!! we're almost done. Code for different categories goes below...........
    public static String getCategory(double result) {
        String category;
        if (result < 15) {
            category = "Extremely underweight";
        } else if (result >= 15 && result <= 16) {
            category = "Very underweight";
        } else if (result > 16 && result <= 18.5) {
            category = "Underweight";
        } else if (result > 18.5 && result <= 25) {
            category = "Healthy weight";
        } else if (result > 25 && result <= 30) {
            category = "Overweight";
        } else if (result > 30 && result <= 35) {
            category = "Getting Obese";
        } else {
            category = "Las las you don blow";
        }
        return category;
    }

    //Medical advice for each category goes below......
    public static String medicalAdvice(double result) {
        String advice;
        if (result < 15) {
            advice = "Please eat more of healthy foods because being extremely underweight can limit your abilities. We wish you well and hope to see you healthy next time";
        } else if (result >= 15 && result <= 16) {
            advice = "Well you are few steps to being extremely underweight dear. Please eat more of healthy food and take a lot of fruits too";
        } else if (result > 16 && result <= 18.5) {
            advice = "You are underweight and as a result we would advice you do more than just eating but maintain a regular routine of exercise and rest";
        } else if (result > 18.5 && result <= 25) {
            advice = "Kudos!!! you are not just healthy, but more than healthy. Please maintain your regular dose which keeps you healthy";
        } else if (result > 25 && result <= 30) {
            advice = "Overweight, well you can engage in daily exercise and be rest assured that you'll hit the healthy point next time you come to check your weight";
        } else if (result > 30 && result <= 35) {
            advice = "Getting Obese? Don't worry all hope is not lost. Just don't relax via eating alone. Try to do more of exercise, eat less and take more water";
        } else {
            advice = "More work is need on your part. You'll need to be attended to specially by our experts. Do well to contact the number below: +2348145075442";
        }
        return advice;
    }
}
