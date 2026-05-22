package xadrez;

import xadrez.pieces.Movement;
import xadrez.pieces.Piece;

// Validador de movimento — responsável por dizer se uma peça PODE ir
// da posição startSet até a posição finalSet, considerando apenas geometria.
// Ainda não verifica obstáculos, capturas inválidas ou xeque.
public class check_move {

    // piece    : a peça que está tentando se mover
    // startSet : posição atual {linha, coluna}
    // finalSet : posição destino {linha, coluna}
    // Retorna true se algum dos movimentos permitidos da peça leva
    // exatamente de startSet a finalSet.
    public boolean simpleCheckMove(Piece piece, int[] startSet, int[] finalSet) {

        // Caso 1: peça de alcance fixo (peão, cavalo, rei).
        // Cada movimento é um salto único; basta somar e comparar.
        if (!piece.isMovement_loop()) {
            // Peças de alcance fixo: peão, cavalo, rei
            for (Movement m : piece.getMovements()) {
                int[] candidate = m.applyTo(startSet);

                if (candidate[0] == finalSet[0] && candidate[1] == finalSet[1]) {
                    return true;
                }
            }
            return false;
        // Caso 2: peça deslizante (torre, bispo, dama).
        // Cada Movement é uma DIREÇÃO; itera passo a passo até a borda
        // ou até bater no destino.
        } else {
            // Peças de longo alcance: torre, bispo, dama
            for (Movement m : piece.getMovements()) {
                for (int step = 1; step < 8; step++) {
                    int newX = startSet[0] + m.dx() * step;
                    int newY = startSet[1] + m.dy() * step;

                    // saiu do tabuleiro: para esta direção
                    if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
                        break;
                    }

                    // Bateu no destino? Movimento válido.
                    if (newX == finalSet[0] && newY == finalSet[1]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}