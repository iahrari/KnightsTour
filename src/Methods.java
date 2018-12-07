import java.util.*;

class Methods{

    //This method gives us possible moves that knights can take!
    private ArrayList<Location> possibleMoves(Location l, ArrayList<Location> moves){
        ArrayList<Location> possibleMoves = new ArrayList<>();

        Location one = new Location(l.getRow() - 2, l.getColumn() - 1);
        if(isLocationValid(moves, one))
            possibleMoves.add(one);

        Location two = new Location(l.getRow() - 2, l.getColumn() + 1);
        if(isLocationValid(moves,two))
            possibleMoves.add(two);

        Location three = new Location(l.getRow() + 2, l.getColumn() -1);
        if(isLocationValid(moves, three))
            possibleMoves.add(three);

        Location four = new Location(l.getRow() + 2, l.getColumn() + 1);
        if(isLocationValid(moves, four))
            possibleMoves.add(four);
        
        Location five = new Location(l.getRow() -1, l.getColumn() - 2);
        if(isLocationValid(moves, five))
            possibleMoves.add(five);
            
        Location six = new Location(l.getRow() - 1, l.getColumn() + 2);
        if(isLocationValid(moves, six))
            possibleMoves.add(six);

        Location seven = new Location(l.getRow() +1, l.getColumn() - 2);
        if(isLocationValid(moves, seven))
            possibleMoves.add(seven);
          
        Location eight = new Location(l.getRow() + 1, l.getColumn() + 2);
        if(isLocationValid(moves, eight))
            possibleMoves.add(eight);
        
        return possibleMoves;
    }

    //This method gives us best moves that knights can take based on Warensdorf's rule.
    private ArrayList<Location> bestMoves(Location position, ArrayList<Location> moves){
        ArrayList<Location> possibleMoves = possibleMoves(position, moves);
        ArrayList<Location> bestMoves = new ArrayList<>();

        int min = 8;
        for(Location l : possibleMoves){
            int size = possibleMoves(l, moves).size();

            if(size < min){
                bestMoves.clear();
                min = size;
                bestMoves.add(l);
            } else if(size == min)
                bestMoves.add(l);
        }
        return bestMoves;
    }

    //This method gives us a random step from best moves.
    Location nextStep(Location l, ArrayList<Location> moves){
        ArrayList<Location> bestMoves = bestMoves(l, moves);
        return (bestMoves.isEmpty())? new Location(0, 0) : bestMoves.get(new Random().nextInt(bestMoves.size()));
    }

    private boolean isLocationValid(ArrayList<Location> i, Location l){
        return !containsLocation(i, l) && l.getRow() > 0 && l.getRow() < 9 && l.getColumn() > 0 && l.getColumn() < 9;
    }

    private boolean containsLocation(final ArrayList<Location> list, final Location l){
        return list.stream().anyMatch(o -> o.toString().equals(l.getRow() + "," + l.getColumn()));
    }

    void displayMovements(ArrayList<Location> moves){
        System.out.println();

        for(int i = 1; i < 9; i++){
            for(int c = 1; c < 9; c++)
                for(Location l : moves)
                    if(l.toString().equals(i + "," + c))
                        System.out.print(moves.indexOf(l) + "\t"); 
                
            System.out.println();
        }
    } 
}