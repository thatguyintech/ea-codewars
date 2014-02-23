import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Loc {

    public int[] _position = new int[2];
    public boolean visited=false;
    public ArrayList<String> _directions = new ArrayList<String>();

    public List adjLoc = new LinkedList();

    public Loc(int[] coordinates, ArrayList<String> directions){
        _position = coordinates;
        _directions = directions;
    }
}