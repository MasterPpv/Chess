package Game.Pieces;
import java.util.ArrayList;
import Game.*;

/**
 * A specific type of Piece corresponding to the Rook piece in chess. It
 * can only move horizontally and vertically and cannot pass through other
 * pieces. It is worth approximately 5 pawns and can perform the special
 * movement technique called "Castling" with the King (see the description
 * of the King class for details).
 * 
 * @author Priten Vora
 *
 */
public class Rook extends Piece {

	/**
	 * Constructor for the rook. Gets and sets its color.
	 * 
	 * @param piece_color The color of the rook (either BLACK or WHITE).
	 */
	public Rook(Color piece_color) {
		super(piece_color);
	}

	/**
	 * Returns whether or not the rook can move to the tile in question.
	 * 
	 * @param destination The tile the rook wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the rook can move to this tile; false otherwise.
	 */
	public boolean canMoveTo(Tile destination, Board board) {

		// Check if the destination tile already has one of your own pieces.
		Piece destPiece = destination.getPiece();
		if(destPiece != null && destPiece.getColor() == this.getColor()) {
			return false;
		}

		// Collect the necessary information and set up variables.
		boolean movable = true;
		Location myLocation = currentTile.getLocation();
		Location destLocation = destination.getLocation();
		Tile[][] currentBoard = board.getTiles();

		// Set up variables to make next part easier
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int destX = destLocation.getX();
		int destY = destLocation.getY();

		// Destination is in the same file but in a higher rank.
		if(myX == destX && myY < destY) {
			for(int i = (myY + 1); i < destY; i++) {
				Tile toTest = currentBoard[myX][i];
				movable = (toTest.getPiece() == null);
			}
		}
		// Destination is in the same file but in a lower rank.
		else if(myX == destX && myY > destY) {
			for(int i = (myY - 1); i > destY; i--) {
				Tile toTest = currentBoard[myX][i];
				movable = (toTest.getPiece() == null);
			}
		}
		// Destination is in the same rank but in a higher file.
		else if(myY == destY && myX < destX) {
			for(int i = (myX + 1); i < destX; i++) {
				Tile toTest = currentBoard[i][myY];
				movable = (toTest.getPiece() == null);
			}
		}
		// Destination is in the same rank but in a lower file.
		else if(myY == destY && myX > destX) {
			for(int i = (myX - 1); i > destX; i--) {
				Tile toTest = currentBoard[i][myY];
				movable = (toTest.getPiece() == null);
			}
		}
		// Destination is some other tile on the board (can't move there).
		else {
			movable = false;
		}

		return movable;
	}

	public boolean move(Tile destination) {
		return false;
	}

	/**
	 * Evaluates the current position of the rook on the board and
	 * returns an array of all the tiles that it might be possible for
	 * the rook to move to. NOTE: this is NOT the list of all LEGAL
	 * moves available to the rook - this is the list of every move
	 * that COULD be legal for the rook given its current location on
	 * the board. This list must be checked with the current condition
	 * of the board and other pieces to determine the list of all the
	 * moves the rook can actually legally make.
	 * 
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return A list of all possible (but not necessarily legal) moves for the piece.
	 */
	public ArrayList<Tile> potentialMoves(Board board) {

		// Set up the necessary variables.
		Location myLocation = currentTile.getLocation();
		Tile[][] currentBoard = board.getTiles();
		ArrayList<Tile> moves = new ArrayList<Tile>();
		int myX = myLocation.getX();
		int myY = myLocation.getY();
		int width = board.getWidth();
		int height = board.getHeight();

		// Add all squares in the same rank besides the one we're on.
		for(int i = 0; i < width; i++) {
			if(i != myX) {
				moves.add(currentBoard[i][myY]);
			}
		}

		// Add all squares in the same file besides the one we're on.
		for(int j = 0; j < height; j++) {
			if(j != myY) {
				moves.add(currentBoard[myX][j]);
			}
		}

		return moves;
	}
}