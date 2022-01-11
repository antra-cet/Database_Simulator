package santahelpers;

import enums.Cities;
import santalists.Children;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class NiceCityScoreSortStrategy implements SortStrategy {
    public HashMap<String, CitiesAverage> citiesAverage = new HashMap<>();

    /**
     * Singleton pattern
     */
    private static NiceCityScoreSortStrategy cityInstance = null;

    /**
     * Singleton instance setter
     */
    public static NiceCityScoreSortStrategy getInstance() {
        if (cityInstance == null) {
            cityInstance = new NiceCityScoreSortStrategy();
        }

        return cityInstance;
    }

    /**
     * Constructors
     */
    public NiceCityScoreSortStrategy() {
    }

    public NiceCityScoreSortStrategy(final HashMap<String, CitiesAverage> citiesAverage) {
        this.citiesAverage = citiesAverage;
    }

    /**
     * Getters and Setters
     */

    /**
     * Getter for hashmap
     * @return the map
     */
    public HashMap<String, CitiesAverage> getCitiesAverage() {
        return citiesAverage;
    }

    /**
     * Setter for hashmap
     * @param citiesAverage to set the map
     */
    public void setCitiesAverage(final HashMap<String, CitiesAverage> citiesAverage) {
        this.citiesAverage = citiesAverage;
    }

    /**
     * Additional methods
     */

    /**
     * Creates new key-value positions in the map that contain
     * all the city names as keys and new array lists with
     * average children scores
     * */
    public void addAllCities() {
        for (Cities c : Cities.values()) {
            citiesAverage.put(c.name(),
                    new CitiesAverage(new CitiesAverage.CityBuilder(new ArrayList<>())));
        }
    }

    /**
     * Calculates all the average scores for each city based
     * on the array of nice scores
     */
    public void calculateAllScores() {
        for (String key : citiesAverage.keySet()) {
            citiesAverage.get(key).calculateAverage();
        }
    }

    /**
     * Adds new score in the array list
     */
    public void putScore(final double score, final String city) {
        citiesAverage.get(city).addScore(score);
    }

    /**
     * Creates a new array of children that are sorted after nice
     * city score
     * @param children the initial array
     * @return the sorted array
     */
    @Override
    public ArrayList<Children> sortChildren(final ArrayList<Children> children) {
        ArrayList<Children> newArr = new ArrayList<>(children);
        newArr.sort(new Comparator<Children>() {
            @Override
            public int compare(final Children o1, final Children o2) {
                if (o1.getCity().equals(o2.getCity())) {
                    return Integer.compare(o1.getId(), o2.getId());
                }

                if (citiesAverage.get(o1.getCity().name()) == null) {
                    System.out.println(o1.getCity().name());
                    System.out.println(citiesAverage);
                }

                if (citiesAverage.get(o1.getCity().name()).getAverageScore()
                        == citiesAverage.get(o2.getCity().name()).getAverageScore()) {
                    return o1.getCity().name().compareTo(o2.getCity().name());
                }

                return (-1)
                        * Double.compare(citiesAverage.get(o1.getCity().name()).getAverageScore(),
                        citiesAverage.get(o2.getCity().name()).getAverageScore());
            }
        });

        return newArr;
    }
}
