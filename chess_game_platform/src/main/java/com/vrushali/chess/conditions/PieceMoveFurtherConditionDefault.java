package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;

// Default condition for moving further. By defalut, a piece is allowed
// to move from a cell only if the cell was free when it came there

public class PieceMoveFurtherConditionDefault implements PieceMoveFurtherCondition {
    @Override
    public boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board) {
        return cell.isFree();
    }
}
