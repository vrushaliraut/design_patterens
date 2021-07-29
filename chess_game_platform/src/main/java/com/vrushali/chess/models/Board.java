package com.vrushali.chess.models;

import com.google.common.collect.ImmutableList;
import com.vrushali.chess.conditions.PieceCellOccupyBlocker;
import com.vrushali.chess.exceptions.PieceNotFoundException;

import java.util.List;

public class Board {
    int boarSize;
    Cell[][] cells;

    public Board(int boarSize, Cell[][] cells) {
        this.boarSize = boarSize;
        this.cells = cells;
    }

    //Helper method to return cell to the left of the cell
    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    //Helper method to return cell to the right of the cell
    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    //Helper method to return cell to the up of the cell
    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    //Helper method to return cell to the down of the cell
    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    //return cell at given location
    public Cell getCellAtLocation(int x, int y) {
        if (x >= boarSize || x < 0 || y >= boarSize || y < 0) {
            return null;
        }
        return cells[x][y];
    }

    // Helper method to determine whether the player is on check on the current board.
    public boolean isPlayerOnCheck(Player player) throws PieceNotFoundException {
        return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING), kingCheckEvaluationBlockers(), player);
    }

    private List<PieceCellOccupyBlocker> kingCheckEvaluationBlockers() {
        return ImmutableList.of();
    }

    /* Method to check if the piece can be killed currently, by the opponent as the the current board configuration.
     * targetPiece :- Piece which is to be checked
     * cellOccupyBlocker :- Blockers which make cell non occupiable
     * player :- player whose piece has to be checked
     * return Boolean - indicating whether piece is in danger or not?
     * */

    public boolean checkIfPieceCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
                if (currentPiece != null && !currentPiece.isPieceFromSamePlayer(targetPiece)) {
                    List<Cell> nextPossibleCells = currentPiece.nextPossibleCells(this, cellOccupyBlockers, player);
                    if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getBoardSize() {
        return boarSize;
    }

}
