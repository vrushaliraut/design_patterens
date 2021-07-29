package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;
import com.vrushali.chess.models.Player;

public class PieceCellOccupyBlockerSelfPiece implements PieceCellOccupyBlocker{

    @Override
    public boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player) {
        if (cell.isFree()){
            return false;
        }
        return cell.getCurrentPiece().getColor() == piece.color;
    }
}
