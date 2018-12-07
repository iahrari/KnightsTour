public class Location {
    private int row;
    private int column;

    Location(int row, int column){
        this.column = column;
        this.row = row;
    }

    int getColumn(){
        return column;
    }

    int getRow(){
        return row;
    }

    @Override
    public String toString(){
        return row + "," + column;
    }

}