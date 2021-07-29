package com.vrushali.chess.moves;

import com.vrushali.chess.conditions.MoveBaseCondition;
import com.vrushali.chess.conditions.PieceCellOccupyBlocker;
import com.vrushali.chess.conditions.PieceMoveFurtherCondition;
import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Piece;
import com.vrushali.chess.models.Player;

import java.util.ArrayList;
import java.util.List;

import static com.vrushali.chess.moves.VerticalMoveDirection.*;

public class PossibleMovesProviderVertical extends PossibleMovesProvider {
    private VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition,
                                         PieceMoveFurtherCondition moveFurtherCondition,
                                         PieceCellOccupyBlocker baseBlocker,
                                         VerticalMoveDirection verticalMoveDirection) {
        super(maxSteps, baseCondition, moveFurtherCondition, baseBlocker);
        this.verticalMoveDirection = verticalMoveDirection;
    }


    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        if (this.verticalMoveDirection == UP || this.verticalMoveDirection == BOTH) {
            result.addAll(findAllNextMoves(piece, board::getUpCell, board, additionalBlockers, player));
        }
        if (this.verticalMoveDirection == DOWN || this.verticalMoveDirection == BOTH) {
            result.addAll(findAllNextMoves(piece, board::getDownCell, board, additionalBlockers, player));
        }
        return result;
    }
}
