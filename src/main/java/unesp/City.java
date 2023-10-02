package unesp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class City implements Comparable<City> {

    List<Map<City, Integer>> neighbourhoods = new ArrayList<>();
    String name;
    Integer distanceFromEnd;
    City parent = null;
    Integer g; 
    Integer f;

    public City(String name) {
        this.name = name;
    }

    public void setNeighbourhood(City city, Integer distance) {
        Map<City, Integer> neighbour = new HashMap<>();
        neighbour.put(city, distance);

        this.neighbourhoods.add(neighbour);
    }


    public List<Map<City, Integer>> getNeighbourhoods() {
        return this.neighbourhoods;
    }

    public City getClosestNeighbour(List<City> alreadyVisited) {
        int minDistance = Integer.MAX_VALUE;
        City closestNeighbour = null;
        for (Map<City, Integer> neighbourhood : this.neighbourhoods) {
            for (Map.Entry<City, Integer> neighbour : neighbourhood.entrySet()) {
                int neighbourDistance = neighbour.getValue();

                if (neighbourDistance < minDistance && !alreadyVisited.contains(neighbour.getKey())) {
                    minDistance = neighbourDistance;
                    closestNeighbour = neighbour.getKey();
                }
            }
        }
        return closestNeighbour;
    }

    public City getClosestNeighbourFromF(List<City> alreadyVisited){
        int minDistance = Integer.MAX_VALUE;
        City closestNeighbour = null;
        for (Map<City, Integer> neighbourhood : this.neighbourhoods) {
            for (Map.Entry<City, Integer> neighbour : neighbourhood.entrySet()) {
                int neighbourDistanceFromF = neighbour.getKey().distanceFromEnd;
                if (neighbourDistanceFromF < minDistance && !alreadyVisited.contains(neighbour.getKey())) {
                    minDistance = neighbourDistanceFromF;
                    closestNeighbour = neighbour.getKey();
                }
            }
        }
        return closestNeighbour;
    }


    public int getDistanceTo(City city) {
        if (city == this) {
            return 0;
        }

        for (Map<City, Integer> neighbourhood : this.neighbourhoods) {
            for (Map.Entry<City, Integer> neighbour : neighbourhood.entrySet()) {
                if (neighbour.getKey().equals(city)) {
                    return neighbour.getValue();
                }
            }
        }
        
        throw new RuntimeException("City " + city.name + " is not a neighbour of " + this.name);
    }


    @Override
    public int compareTo(City o) {
        return this.f.compareTo(o.f);
    }
}