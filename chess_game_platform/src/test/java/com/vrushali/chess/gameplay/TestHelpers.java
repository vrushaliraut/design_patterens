package com.vrushali.chess.gameplay;

import com.google.common.collect.ImmutableList;
import com.vrushali.chess.conditions.*;
import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Color;
import com.vrushali.chess.models.Piece;
import com.vrushali.chess.moves.*;

import java.util.ArrayList;
import java.util.List;

import static com.vrushali.chess.models.Color.WHITE;
import static com.vrushali.chess.models.PieceType.*;
import static com.vrushali.chess.moves.VerticalMoveDirection.BOTH;

public class TestHelpers {

    public static Board createBoard() {
        Cell[][] cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        return new Board(8, cells);
    }


    public static List<Piece> piecesSet(Color color, Board board, int mainPiecesRowNum,
                                        int pawnPiecesRowNum, VerticalMoveDirection pawnDirection) {

        ArrayList<Piece> allPieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece pawn = pawn(color, pawnDirection);

            addPieceToBoard(board, pawn, pawnPiecesRowNum, i);
            allPieces.add(pawn);
        }

        //king
        Piece king = king(color);
        addPieceToBoard(board, king, mainPiecesRowNum, 3);

        //queen
        Piece queen = queen(color);
        addPieceToBoard(board, queen, mainPiecesRowNum, 4);

        //rook1 and 2
        Piece rook1 = rook(color);
        addPieceToBoard(board, rook1, mainPiecesRowNum, 0);

        Piece rook2 = rook(color);
        addPieceToBoard(board, rook2, mainPiecesRowNum, 7);

        //bishops
        Piece bishop1 = bishop(color);
        addPieceToBoard(board, bishop1, mainPiecesRowNum, 2);

        Piece bishop2 = bishop(color);
        addPieceToBoard(board, bishop2, mainPiecesRowNum, 5);

        //knight
        Piece knight1 = knight(color);
        addPieceToBoard(board, knight1, mainPiecesRowNum, 1);

        Piece knight2 = knight(color);
        addPieceToBoard(board, knight2, mainPiecesRowNum, 6);

        ImmutableList<Piece> mainPieces = ImmutableList.of(king, queen, rook1, rook2, bishop1, bishop2, knight1, knight2);
        allPieces.addAll(mainPieces);

        return allPieces;
    }

    private static void addPieceToBoard(Board board, Piece piece, int rowNum, int colNum) {
        Cell cell = board.getCellAtLocation(rowNum, colNum);

        piece.setCurrentCell(cell);

        cell.setCurrentPiece(piece);

    }

    public static Piece randomPiece() {
        return pawn(WHITE, BOTH);
    }


    private static Piece king(Color color) {
        ImmutableList<PossibleMovesProvider> kingMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),

                new PossibleMovesProviderHorizontal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker()),

                new PossibleMovesProviderDiagonal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, kingMoveProviders, KING);
    }

    public static Piece queen(Color color) {
        ImmutableList<PossibleMovesProvider> queenMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),
                new PossibleMovesProviderHorizontal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker()),
                new PossibleMovesProviderDiagonal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, queenMoveProviders, QUEEN);
    }

    public static Piece rook(Color color) {
        ImmutableList<PossibleMovesProvider> rookMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),
                new PossibleMovesProviderHorizontal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, rookMoveProviders, ROOK);

    }

    public static Piece bishop(Color color) {
        ImmutableList<PossibleMovesProvider> bishopsMoveProviders = ImmutableList.of(
                new PossibleMovesProviderDiagonal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, bishopsMoveProviders, BISHOP);
    }

    public static Piece knight(Color color) {
        ImmutableList<PossibleMovesProvider> knightMoveProviders = ImmutableList.of(
                new PossibleMovesProviderDiagonal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), null)
        );
        return new Piece(color, knightMoveProviders, KNIGHT);
    }

    private static Piece pawn(Color color, VerticalMoveDirection pawnDirection) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), pawnDirection),
                new PossibleMovesProviderVertical(2, new MoveBaseConditionFirstMove(), defaultMoveFurtherCondition(), defaultBaseBlocker(), pawnDirection)
        );
        return new Piece(color, pawnMoveProviders, PAWN);
    }

    private static PieceMoveFurtherCondition defaultMoveFurtherCondition() {
        return new PieceMoveFurtherConditionDefault();
    }

    private static PieceCellOccupyBlocker defaultBaseBlocker() {
        return PieceCellOccupyBlockerFactory.defaultBaseBlocker();
    }
}
