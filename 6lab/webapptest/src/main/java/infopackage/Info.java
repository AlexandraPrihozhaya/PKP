package infopackage;

import tourpackage.Tour;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.round;

public class Info {

    public static int findAverageNumberOfDays(ArrayList<Tour> tourArray) {
        float res = 0;
        for (Tour tour : tourArray) {
            res += tour.getNumberOfDays();
        }
        return round(res/tourArray.size());
    }

    public static int findAverageNumberOfPeople(ArrayList<Tour> tourArray) {
        int res = 0;
        for (Tour tour : tourArray) {
            res += tour.getNumberOfPeople();
        }
        return res/tourArray.size();
    }

    public static int findAveragePrice(ArrayList<Tour> tourArray) {
        int res = 0;
        for (Tour tour : tourArray) {
            res += tour.getPrice();
        }

        return res/tourArray.size();
    }

    public static int findMaxNumberOfDays(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getNumberOfDays());
        }

        return Collections.max(list);
    }

    public static int findMaxNumberOfPeople(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getNumberOfPeople());
        }

        return Collections.max(list);
    }

    public static int findMaxPrice(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getPrice());
        }

        return Collections.max(list);
    }

    public static int findMinNumberOfDays(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getNumberOfDays());
        }

        return Collections.min(list);
    }

    public static int findMinNumberOfPeople(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getNumberOfPeople());
        }

        return Collections.min(list);
    }

    public static int findMinPrice(ArrayList<Tour> tourArray) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Tour tour : tourArray) {
            list.add(tour.getPrice());
        }

        return Collections.min(list);
    }
}
