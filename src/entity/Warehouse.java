package entity;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c8e0e928-61bf-4b53-8d1e-88b44e44d04a")
public class Warehouse {
    @objid ("ee3812eb-85c9-4ff5-af1c-acd6139cdfae")
    private List<Position> positions = new ArrayList<Position> ();

    @objid ("1fe578cf-6887-44d2-9332-dc8dcb8978ab")
    private List<Square> squares = new ArrayList<Square> ();
    
    public Square getNeighbour(Square square, Direction direction) {
    	Position position = square.getPosition();
    	int rowDifference = 0;
    	int columnDifference = 0;
    	switch (direction) {
    		case LEFT:
    			columnDifference = -1;
    			break;
    		case RIGHT:
    			columnDifference = 1;
    			break;
    		case UP:
    			rowDifference = -1;
    			break;
    		case DOWN:
    			rowDifference = 1;
    			break;
    	}
    	for (Position otherPosition : positions) {
    		if (otherPosition.getColumn() == position.getColumn() + columnDifference && 
    				otherPosition.getRow() == position.getRow() + rowDifference) {
    			return otherPosition.getSquare();
    		}
    	}
    	return null;
    }
    
    public void allocate(Moveable m, Floor floor) {
    	floor.setMoveable(m);
    }

}
