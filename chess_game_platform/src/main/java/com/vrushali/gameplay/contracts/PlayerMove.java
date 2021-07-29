package com.vrushali.gameplay.contracts;

import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;

public class PlayerMove {
    Piece piece;
    Cell toCell;

    public Object getToCell() {
        return toCell;
    }

    public Piece getPiece() {
        return piece;
    }
}
