package xadrez.pieces;

// basicamente uma classe para definir as posições no plano
public record Movement(int dx, int dy, MoveType type) {

    // Construtor curto: assume MOVE_OR_CAPTURE (caso comum, todas as peças exceto peão).
    public Movement(int dx, int dy) {
        this(dx, dy, MoveType.MOVE_OR_CAPTURE);
    }

    // função para permitir somar valores as posições,
    // permite simular a movimentação das peças
    public int[] applyTo(int[] start) {
        return new int[] { start[0] + dx, start[1] + dy };
    }
}
