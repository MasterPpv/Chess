/**
 * An enumerator that can be either WHITE or BLACK, corresponding
 * to the two possibilities for tile colors, player designations,
 * and piece colors that are available on a chess board. 
 * 
 * @author Priten Vora
 *
 */
public enum Color {
	WHITE, BLACK;	// The color of pieces, tiles and players - white or black.

	public Color other() {
		return (this == WHITE)? BLACK : WHITE;
	}
}