package unesp;
import java.util.ArrayList;
import java.util.List;

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
        I.distanceFromF = 19;
        A.distanceFromF = 19;
        B.distanceFromF = 16;
        C.distanceFromF = 13;
        D.distanceFromF = 13;
        E.distanceFromF = 11;
        G.distanceFromF = 9;
        H.distanceFromF = 11;
        K.distanceFromF = 11;
        F.distanceFromF = 0;
        W.distanceFromF = 5;
        T.distanceFromF = 7;
        S.distanceFromF = 11;
        R.distanceFromF = 11;
        Q.distanceFromF = 9;
        P.distanceFromF = 9;
        U.distanceFromF = 10;
        V.distanceFromF = 8;
        N.distanceFromF = 12;
        L.distanceFromF = 18;
        M.distanceFromF = 9;

        current = I;
        end = F;

        System.out.println("Finding a path from " + current.name + " to " + end.name + " by the best first search");

        // I would prefer to use visited list and avoid the infinite loop
        // although it is not necessary in this case
        visited = new ArrayList<>();

        while(true){
            City closestNeighbour = current.getClosestNeighbourFromF(visited);
            visited.add(closestNeighbour);
            System.out.println("The closest neighbour from F from " + current.name + " is " + closestNeighbour.name + " you would be then " + closestNeighbour.distanceFromF + " minutes away from F.");

            if (closestNeighbour == end) {
                System.out.println("We have arrived at " + end.name);
                break;
            } else {
                current = closestNeighbour;
            }
        }

    }
}
