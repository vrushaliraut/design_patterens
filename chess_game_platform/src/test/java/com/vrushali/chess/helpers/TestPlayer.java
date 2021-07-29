package com.vrushali.chess.helpers;

import com.vrushali.chess.gameplay.TestHelpers;
import com.vrushali.chess.models.*;
import com.vrushali.gameplay.contracts.PlayerMove;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.vrushali.chess.conditions.PieceCellOccupyBlockerFactory.defaultAdditionalBlockers;
import static com.vrushali.chess.models.Color.WHITE;
import static com.vrushali.chess.models.PieceType.*;
import static com.vrushali.chess.moves.VerticalMoveDirection.DOWN;
import static com.vrushali.chess.moves.VerticalMoveDirection.UP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlayer extends Player {


    public TestPlayer(List<Piece> pieces) {
        super(pieces);
    }

    @Override
    protected Piece[] getPieces() {
        return new Piece[0];
    }

    @Override
    public PlayerMove makeMove() {
        return null;
    }
}

class GamePlay {

    @Test
    void testSampleGamePlay() {
        Board board = TestHelpers.createBoard();

        List<Piece> whitePieces = TestHelpers.piecesSet(WHITE, board, 0, 1, UP);
        List<Piece> blackPieces = TestHelpers.piecesSet(Color.BLACK, board, 7, 6, DOWN);

        Player whitePlayer = new TestPlayer(whitePieces);
        Player blackPlayer = new TestPlayer(blackPieces);

        printBoard(board, "Initial");

        // Validate that queen has no possible moves initially.
        Piece whiteQ = board.getCellAtLocation(0, 4).getCurrentPiece();
        assertEquals(whiteQ.getColor(), WHITE);
        assertEquals(whiteQ.getPieceType(), QUEEN);

        List<Cell> whiteBishop1NextPossibleCells = whiteQ.nextPossibleCells(board, defaultAdditionalBlockers(), whitePlayer);
        assertTrue(whiteBishop1NextPossibleCells.isEmpty());


        // Move a pawn from front of queen.
        Piece whitePawn4 = board.getCellAtLocation(1, 4).getCurrentPiece();
        assertEquals(whitePawn4.getColor(), WHITE);
        assertEquals(whitePawn4.getPieceType(), PAWN);

        List<Cell> whitePawn4NextPossibleCells = whitePawn4.nextPossibleCells(board, defaultAdditionalBlockers(), whitePlayer);
        assertEquals(2, whitePawn4NextPossibleCells.size());
        whitePawn4.move(whitePlayer, whitePawn4NextPossibleCells.get(1), board, defaultAdditionalBlockers());
        printBoard(board, "Post PAWN Move");
        assertEquals(whitePawn4.getCurrentCell(), whitePawn4NextPossibleCells.get(1));


        // Now queen should be able to make 2 moves since its pawn has moved 2 moves.
        List<Cell> whiteQMove2 = whiteQ.nextPossibleCells(board, defaultAdditionalBlockers(), whitePlayer);
        assertEquals(whiteQMove2.size(), 2);

    }

    private void printBoard(Board board, String title) {
        System.out.println("\n\n" + title);
        for (int i = board.getBoardSize() - 1; i >= 0; i--) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                System.out.print(displayChar(board.getCellAtLocation(i, j)) + " ");
            }
            System.out.println();
        }
    }

    String displayChar(Cell cell) {
        if (cell.getCurrentPiece() == null) {
            return " ";
        }
        switch (cell.getCurrentPiece().getPieceType()) {
            case PAWN:
                return "P";
            case BISHOP:
                return "B";
            case KING:
                return "K";
            case ROOK:
                return "R";
            case QUEEN:
                return "Q";
            case KNIGHT:
                return "G";
        }
        return "0";
    }


}

