package xadrez.pieces;

// Define a "intenção" de um Movement em relação ao destino.
// Pra maioria das peças, todo movimento é MOVE_OR_CAPTURE (tanto faz se a
// casa de destino está vazia ou tem inimigo). O peão é exceção:
//   - avanço (1 ou 2 casas) só vale se o destino estiver VAZIO  -> MOVE_ONLY
//   - diagonal só vale se o destino tiver INIMIGO               -> CAPTURE_ONLY
// Útil também no futuro pra en passant, roque, etc.
public enum MoveType {
    MOVE_ONLY,
    CAPTURE_ONLY,
    MOVE_OR_CAPTURE
}
