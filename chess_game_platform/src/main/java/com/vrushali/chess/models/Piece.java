package com.vrushali.chess.models;

import com.google.common.collect.ImmutableList;
import com.vrushali.chess.conditions.PieceCellOccupyBlocker;
import com.vrushali.chess.exceptions.InvalidMoveException;
import com.vrushali.chess.moves.PossibleMovesProvider;

import java.util.ArrayList;
import java.util.List;

import static com.vrushali.chess.helpers.ListHelpers.removeDuplicates;

// class representing a single piece which can be moved on the board
public class Piece {

    private boolean isKilled = true;
    public final Color color;
    private final ImmutableList<PossibleMovesProvider> movesProviders;
    private Integer numMoves = 0;
    PieceType pieceType;

    private Cell currentCell;

    public Piece(Color color, ImmutableList<PossibleMovesProvider> movesProviders, PieceType pieceType) {
        this.color = color;
        this.movesProviders = movesProviders;
        this.pieceType = pieceType;
    }

    public void killIt() {
        this.isKilled = true;
    }

    // method to move piece from current cell to a given cell
    public void move(Player player, Cell toCell, Board board, java.util.List<PieceCellOccupyBlocker> additionalBlockers) {
        if (isKilled) {
            throw new InvalidMoveException();
        }
        java.util.List<Cell> nextPossibleCells = nextPossibleCells(board, additionalBlockers, player);
        if (!nextPossibleCells.contains(toCell)) {
            throw new InvalidMoveException();
        }

        killPieceInCell(toCell);
        this.currentCell.setCurrentPiece(null);
        this.currentCell = toCell;
        this.currentCell.setCurrentPiece(this);
        this.numMoves++;
    }

    // helper method to kill the piece in a given cell
    private void killPieceInCell(Cell targetCell) {
        if (targetCell.getCurrentPiece() != null) {
            targetCell.getCurrentPiece().killIt();
        }
    }

    /* Method which tells what are all next possible cells to which the current piece can move from the current cell .
     * @param board              Board on which the piece is present.
     * @param additionalBlockers Blockers which make a cell non-occupiable for a piece.
     * @param player             Player who owns the piece.
     * @return List of all next possible cells.
     * */

    public java.util.List<Cell> nextPossibleCells(Board board, java.util.List<PieceCellOccupyBlocker>
            additionalBlockers, Player player) {
        java.util.List<Cell> result = new ArrayList<>();
        for (PossibleMovesProvider movesProvider : this.movesProviders) {
            List<Cell> cells = movesProvider.possibleMoves(this, board, additionalBlockers, player);
            if (cells != null) {
                result.addAll(cells);
            }
        }
        return removeDuplicates(result);
    }

    // Helper method to check if two pieces belong to same player
    public boolean isPieceFromSamePlayer(Piece piece) {
        return piece.getColor().equals(this.color);
    }

    public Color getColor() {
        return color;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }


    public int getNumMoves() {
        return numMoves;
    }
}
