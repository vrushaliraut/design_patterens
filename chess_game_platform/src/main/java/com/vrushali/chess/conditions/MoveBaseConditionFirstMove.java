package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Piece;

public class MoveBaseConditionFirstMove implements MoveBaseCondition {
    @Override
    public boolean isBaseConditionFulfilled(Piece piece) {
        return piece.getNumMoves() == 0;
    }
}
