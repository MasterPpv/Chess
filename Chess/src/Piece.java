/**
 * The basic representation of a piece in chess. Each piece should know
 * its location on the board, as well as what squares it can legally move
 * to or not move to. Each piece has a color associated with it, which
 * represents which player's side it is on, and each piece has the ability
 * to capture opposing pieces and remove them from the game.
 * 
 * @author Priten Vora
 *
 */
public abstract class Piece {

	private Color color;			// Color of the piece - true = white & false = black
	private Tile location;			// Current location of the piece on the board

	/**
	 * Returns which tile of the board the piece is on.
	 * 
	 * @return The tile which the piece is on.
	 */
	public Tile get_location() {
		return location;
	}

	/**
	 * Returns the color of the piece.
	 * 
	 * @return True if the piece is white; false if it is black.
	 */
	public Color get_color() {
		return color;
	}

	/**
	 * Returns whether the piece has any legal moves or not.
	 * 
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the piece has legal moves available; false otherwise.
	 */
	public abstract boolean can_move(Board board);

	/**
	 * Returns whether or not the piece can move to the tile in question.
	 * 
	 * @param destination The tile the piece wants to move to.
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return True if the piece can move to this tile; false otherwise.
	 */
	public abstract boolean can_move_to(Tile destination, Board board);

	/**
	 * Moves the piece to the destination tile.
	 * 
	 * @param destination The tile to move to.
	 * @return True if the move was successful; false otherwise.
	 */
	public abstract boolean move(Tile destination);

	/**
	 * Evaluates the current position of the piece on the board and
	 * returns an array of all the tiles that it might be possible for
	 * the piece to move to. NOTE: this is NOT the list of all LEGAL
	 * moves available to the piece - this is the list of every move
	 * that COULD be legal for the piece given its current location on
	 * the board. This list must be checked with the current condition
	 * of the board and other pieces to determine the list of all the
	 * moves the piece can actually legally make.
	 * 
	 * @param board The board with all tiles present and any pieces currently in play.
	 * @return A list of all possible (but not necessarily legal) moves for the piece.
	 */
	public abstract Tile[] potential_moves(Board board);
}