import java.util.*;
//Based on Warnsdorf's rule
public class Main {
    public static void main(String[] args) {
        
        ArrayList<Location> moves = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Methods methods = new Methods();

        System.out.println("**************Knights Tour**************");

        System.out.print("Enter a row for starting knights tour: ");
        int row = in.nextInt();

        System.out.print("Enter a column: ");
        int column = in.nextInt();

        moves.add(new Location(row, column));
        in.close();

        while(moves.size() < 64){
            Location currentLocation = methods.nextStep(moves.get(moves.size() -1), moves);
            
            if(currentLocation.toString().equals("0,0")){
                System.out.println("Task failed!");
                moves.clear();
                moves.add(new Location(row, column));
            }
  
            moves.add(currentLocation);
        }
        
        methods.displayMovements(moves);
    }
}