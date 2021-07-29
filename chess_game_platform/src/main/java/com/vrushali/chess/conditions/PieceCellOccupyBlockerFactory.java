package com.vrushali.chess.conditions;

/* Factory class to give cell occupy blockers for different scenarios.
 * */

import com.google.common.collect.ImmutableList;

import java.util.List;

public class PieceCellOccupyBlockerFactory {

    public static PieceCellOccupyBlocker defaultBaseBlocker() {
        return new PieceCellOccupyBlockerSelfPiece();
    }

    public static List<PieceCellOccupyBlocker> defaultAdditionalBlockers() {
        return ImmutableList.of(new PieceCellOccupyBlockerKingCheck());
    }


}
