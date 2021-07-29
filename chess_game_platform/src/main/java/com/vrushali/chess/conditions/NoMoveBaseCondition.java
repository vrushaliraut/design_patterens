package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Piece;

public class NoMoveBaseCondition implements MoveBaseCondition {
    @Override
    public boolean isBaseConditionFulfilled(Piece piece) {
        return true;
    }
}
