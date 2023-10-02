package unesp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class App 
{
    public static void main( String[] args )
    {
        // Cities
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");
        City G = new City("G");
        City H = new City("H");
        City I = new City("I");
        City K = new City("K");
        City L = new City("L");
        City M = new City("M");
        City N = new City("N");
        City W = new City("W");
        City T = new City("T");
        City S = new City("S");
        City R = new City("R");
        City Q = new City("Q");
        City P = new City("P");
        City U = new City("U");
        City V = new City("V");

        // Neighbourhoods Setup
        A.setNeighbourhood(B, 3);
        A.setNeighbourhood(I, 3);

        B.setNeighbourhood(C, 4);
        B.setNeighbourhood(T, 11);
        B.setNeighbourhood(I, 4);
        
        C.setNeighbourhood(D, 3);
        C.setNeighbourhood(E, 3);
        C.setNeighbourhood(B, 4);

        D.setNeighbourhood(E, 2);
        D.setNeighbourhood(C, 3);

        E.setNeighbourhood(G, 3);
        E.setNeighbourhood(D, 2);
        E.setNeighbourhood(C, 3);

        G.setNeighbourhood(H, 3);
        G.setNeighbourhood(K, 3);
        G.setNeighbourhood(E, 3);
 
        H.setNeighbourhood(K, 2);
        H.setNeighbourhood(G, 3);

        K.setNeighbourhood(F, 8);
        K.setNeighbourhood(H, 2);

        F.setNeighbourhood(W, 8);
        F.setNeighbourhood(M, 8);
        F.setNeighbourhood(K, 8);

        W.setNeighbourhood(T, 3);
        W.setNeighbourhood(F, 8);

        T.setNeighbourhood(S, 4);
        T.setNeighbourhood(V, 7);
        T.setNeighbourhood(B, 11);
        T.setNeighbourhood(W, 3);

        S.setNeighbourhood(R, 2);
        S.setNeighbourhood(T, 4);

        R.setNeighbourhood(Q, 2);
        R.setNeighbourhood(S, 2);

        Q.setNeighbourhood(P, 2);
        Q.setNeighbourhood(R, 2);

        P.setNeighbourhood(N, 3);
        P.setNeighbourhood(U, 3);
        P.setNeighbourhood(Q, 2);

        U.setNeighbourhood(V, 2);
        U.setNeighbourhood(P, 3);

        L.setNeighbourhood(M, 27);
        L.setNeighbourhood(I, 5);

        I.setNeighbourhood(A, 3);
        I.setNeighbourhood(B, 4);
        I.setNeighbourhood(N, 12);
        I.setNeighbourhood(L, 5);

        N.setNeighbourhood(P, 3);
        N.setNeighbourhood(I, 12);

        // Find a path from 
        City current = I;
        City end = F;
        System.out.println("Finding a path from " + current.name + " to " + end.name);

        // Hill Climbing
        List<City> visited = new ArrayList<>();
        while(true) {
            City closestNeighbour = current.getClosestNeighbour(visited);
            visited.add(closestNeighbour);
            System.out.println("The closest neighbour from " + current.name + " is " + closestNeighbour.name + " you can go there in " + current.getDistanceTo(closestNeighbour) + " minutes.");

            if (closestNeighbour == end) {
                System.out.println("We have arrived at " + end.name);
                break;
            } else {
                current = closestNeighbour;
            }
        }
        
        /* it outputs:
        Finding a path from I to F
            The closest neighbour from I is A you can go there in 3 minutes.
            The closest neighbour from A is B you can go there in 3 minutes.
            The closest neighbour from B is C you can go there in 4 minutes.
            The closest neighbour from C is D you can go there in 3 minutes.
            The closest neighbour from D is E you can go there in 2 minutes.
            The closest neighbour from E is G you can go there in 3 minutes.
            The closest neighbour from G is H you can go there in 3 minutes.
            The closest neighbour from H is K you can go there in 2 minutes.
            The closest neighbour from K is F you can go there in 8 minutes.
        We have arrived at F
         */


        // Best first search
        I.distanceFromEnd = 19;
        A.distanceFromEnd = 19;
        B.distanceFromEnd = 16;
        C.distanceFromEnd = 13;
        D.distanceFromEnd = 13;
        E.distanceFromEnd = 11;
        G.distanceFromEnd = 9;
        H.distanceFromEnd = 11;
        K.distanceFromEnd = 11;
        F.distanceFromEnd = 0;
        W.distanceFromEnd = 5;
        T.distanceFromEnd = 7;
        S.distanceFromEnd = 11;
        R.distanceFromEnd = 11;
        Q.distanceFromEnd = 9;
        P.distanceFromEnd = 9;
        U.distanceFromEnd = 10;
        V.distanceFromEnd = 8;
        N.distanceFromEnd = 11;
        L.distanceFromEnd = 18;
        M.distanceFromEnd = 9;

        current = I;
        end = F;

        System.out.println("Finding a path from " + current.name + " to " + end.name + " by the best first search");

        // I would prefer to use visited list and avoid the infinite loop
        // although it is not necessary in this case
        visited = new ArrayList<>();

        while(true){
            City closestNeighbour = current.getClosestNeighbourFromF(visited);
            visited.add(closestNeighbour);
            System.out.println("The closest neighbour from F from " + current.name + " is " + closestNeighbour.name + " you would be then " + closestNeighbour.distanceFromEnd + " minutes away from F.");

            if (closestNeighbour == end) {
                System.out.println("We have arrived at " + end.name);
                break;
            } else {
                current = closestNeighbour;
            }
        }


        // A* search, finds the shortest path from I to F 
        // testing every possible path
        PriorityQueue<City> alreadyProcessedCities = new PriorityQueue<>();
        PriorityQueue<City> citiesToBeProcessed = new PriorityQueue<>();
        
        current = I;
        end = F;

        current.f =  + current.getDistanceTo(current) + current.distanceFromEnd;
        current.g = 0;
        citiesToBeProcessed.add(current);

        while(!citiesToBeProcessed.isEmpty()){
            City currentCity = citiesToBeProcessed.peek();

            if(currentCity == end){
                System.out.println("A* arrived at " + end.name);
                break;
            }

            for(Map<City, Integer> neighbourhood : currentCity.getNeighbourhoods()){
                for(Map.Entry<City, Integer> neighbour : neighbourhood.entrySet()){
                    
                    City neighbourCity = neighbour.getKey();
                    Integer currentCost = currentCity.g + neighbour.getValue();   

                    if(!citiesToBeProcessed.contains(neighbourCity) && !alreadyProcessedCities.contains(neighbourCity)){
                        neighbourCity.parent = currentCity;
                        neighbourCity.g = currentCost; 
                        neighbourCity.f = neighbourCity.g + neighbourCity.distanceFromEnd;
                        citiesToBeProcessed.add(neighbourCity);
                    } else {
                        if(currentCost < neighbourCity.g){
                            neighbourCity.parent = currentCity;
                            neighbourCity.g = currentCost;
                            neighbourCity.f = neighbourCity.g + neighbourCity.distanceFromEnd;

                            if (alreadyProcessedCities.contains(neighbourCity)){
                                alreadyProcessedCities.remove(neighbourCity);
                                citiesToBeProcessed.add(neighbourCity);
                            }
                        }
                    }
                }
            }

            citiesToBeProcessed.remove(currentCity);
            alreadyProcessedCities.add(currentCity);
        }

        // Print the path 
        City currentCity = end;
        List<City> path = new ArrayList<>();
        System.out.println("The shortest path from " + I.name + " to " + F.name + " based on A* is:\n");
        while(currentCity != null){
            currentCity = currentCity.parent;
            path.add(currentCity);
        }
        for(int i = path.size() -2; i >= 0; i--){
            System.out.print(path.get(i).name + " -> ");
        }
        System.out.println(end.name);

        // Uniform Cost Search
        // It is the same as A* but without the heuristic function (distanceFromEnd)
        // It finds the shortest path from I to F
        // testing every possible path
        alreadyProcessedCities = new PriorityQueue<>();
        citiesToBeProcessed = new PriorityQueue<>();
        
        current = I;
        end = F;

        current.f =  + current.getDistanceTo(current);
        current.g = 0;
        citiesToBeProcessed.add(current);
        currentCity = null;

        while(!citiesToBeProcessed.isEmpty()){
            currentCity = citiesToBeProcessed.peek();

            if(currentCity == end){
                System.out.println("A* arrived at " + end.name);
                break;
            }

            for(Map<City, Integer> neighbourhood : currentCity.getNeighbourhoods()){
                for(Map.Entry<City, Integer> neighbour : neighbourhood.entrySet()){
                    
                    City neighbourCity = neighbour.getKey();
                    Integer currentCost = currentCity.g + neighbour.getValue();   

                    if(!citiesToBeProcessed.contains(neighbourCity) && !alreadyProcessedCities.contains(neighbourCity)){
                        neighbourCity.parent = currentCity;
                        neighbourCity.g = currentCost; 
                        neighbourCity.f = neighbourCity.g;
                        citiesToBeProcessed.add(neighbourCity);
                    } else {
                        if(currentCost < neighbourCity.g){
                            neighbourCity.parent = currentCity;
                            neighbourCity.g = currentCost;
                            neighbourCity.f = neighbourCity.g;

                            if (alreadyProcessedCities.contains(neighbourCity)){
                                alreadyProcessedCities.remove(neighbourCity);
                                citiesToBeProcessed.add(neighbourCity);
                            }
                        }
                    }
                }
            }

            citiesToBeProcessed.remove(currentCity);
            alreadyProcessedCities.add(currentCity);
        }

        // Print the path 
        currentCity = end;
        path = new ArrayList<>();
        System.out.println("The shortest path from " + I.name + " to " + F.name + " based on Uniform Cost Search is:\n");
        while(currentCity != null){
            currentCity = currentCity.parent;
            path.add(currentCity);
        }
        for(int i = path.size() -2; i >= 0; i--){
            System.out.print(path.get(i).name + " -> ");
        }
        System.out.println(end.name);
    }
}