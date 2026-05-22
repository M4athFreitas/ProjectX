package xadrez.pieces;
import java.util.ArrayList;
import java.util.List;

// Serve como "molde" para as peças reais (Pawn, Rook, etc.) herdarem.
public abstract class Piece {
	protected boolean isWhite;			// cor da peça (true = branco)
	protected boolean movement_loop;	// true para peças deslizantes (torre, bispo, dama)
	protected boolean moved = false;	// vira true depois do primeiro movimento

	// baseMovements: movimentos sempre disponíveis (ex.: peão avança 1)
	// specialMovements: movimentos extras só quando a peça nunca moveu
	protected List<Movement> baseMovements = new ArrayList<>();
	protected List<Movement> specialMovements = new ArrayList<>();

	Piece(boolean isWhite, boolean movementLoop) {
		this.isWhite = isWhite;
		this.movement_loop = movementLoop;
	}

	public boolean isMoved() { return moved; }		// Getter: a peça já se mexeu pelo menos uma vez?
	public void setMoved() { this.moved = true; }	// Marca a peça como já tendo se movido.

	// Getter para o check_move saber se essa peça desliza (rook, bishop, queen)
	public boolean isMovement_loop() { return movement_loop;}

	// Devolve a lista completa de movimentos disponíveis NESTE MOMENTO.
	// Monta uma cópia da base e, se a peça nunca se moveu, agrega os especiais.
	public List<Movement> getMovements() {
		List<Movement> result = new ArrayList<>(baseMovements);
		if (!moved) {
			result.addAll(specialMovements);
		}
		return result;
	}
}
