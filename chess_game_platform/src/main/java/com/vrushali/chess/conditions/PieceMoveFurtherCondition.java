package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;

// interface to tell whether a piece can further move from a cell

public interface PieceMoveFurtherCondition {
    boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board);
}
