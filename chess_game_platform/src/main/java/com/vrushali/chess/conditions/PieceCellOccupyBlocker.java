package com.vrushali.chess.conditions;

// this check tell whether a piece can occupy a give cell in the board or not
import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;
import com.vrushali.chess.models.Player;

public interface PieceCellOccupyBlocker {
    boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player);

}
