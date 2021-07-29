package com.vrushali.chess.models;

/* Abstract com.vrushali.chess.gameplay.model class representing a player.
 * This is abstract because we are not sure how player is going to make his move.
 * If the player is a local player, then he can move locally. A player can also be network based player,
 * So, depending on the type of player, he can make a move on his way.
 * */


import com.vrushali.chess.exceptions.PieceNotFoundException;
import com.vrushali.gameplay.contracts.PlayerMove;

import java.util.List;

public abstract class Player {
    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType) throws PieceNotFoundException {
        for (Piece piece : getPieces()) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    protected abstract Piece[] getPieces();

    abstract public PlayerMove makeMove();
}
