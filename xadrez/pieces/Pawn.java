package xadrez.pieces;

import java.util.List;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        // movement_loop = false porque o peão tem alcance fixo (não desliza).
        super(isWhite, false);

        // dir define a direção do avanço:
        //   branco anda "pra frente" (linha +1)
        //   preto anda "pra trás" (linha -1)
        int dir = isWhite ? 1 : -1;

        // Avanço normal: 1 casa pra frente, mesma coluna.
        baseMovements.add(new Movement(1 * dir, 0));
        // Avanço duplo: 2 casas pra frente, mesma coluna.
        // Só na primeira jogada
        specialMovements.add(new Movement(2 * dir, 0));
    }

}
