package com.vrushali.chess.conditions;

import com.vrushali.chess.models.Piece;

// base condition for a piece to move. The piece would only be allowed to move from its current
// position if the condition fulfills
public interface MoveBaseCondition {
    boolean isBaseConditionFulfilled(Piece piece);
}
