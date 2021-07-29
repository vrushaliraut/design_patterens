package com.vrushali.chess.moves;

import com.vrushali.chess.conditions.MoveBaseCondition;
import com.vrushali.chess.conditions.PieceCellOccupyBlocker;
import com.vrushali.chess.conditions.PieceMoveFurtherCondition;
import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;
import com.vrushali.chess.models.Player;

import java.util.List;

public class PossibleMovesProviderDiagonal extends PossibleMovesProvider {

    public PossibleMovesProviderDiagonal(int maxSteps, MoveBaseCondition baseCondition,
                                         PieceMoveFurtherCondition pieceMoveFurtherCondition,
                                         PieceCellOccupyBlocker baseBlocker) {
        super(maxSteps, baseCondition, pieceMoveFurtherCondition, baseBlocker);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board inBoard,
                                                       List<PieceCellOccupyBlocker> additionalBlockers,
                                                       Player player) {
        return null;
    }
}
