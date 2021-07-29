package com.vrushali.chess.gameplay;

import com.vrushali.chess.models.Board;
import com.vrushali.chess.models.Cell;
import com.vrushali.chess.models.Player;
import com.vrushali.gameplay.contracts.PlayerMove;

import java.util.List;

import static com.vrushali.chess.conditions.PieceCellOccupyBlockerFactory.defaultAdditionalBlockers;

public class GameController {
    public static void gameplay(List<Player> players, Board board) {
        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);

            PlayerMove playerMove = player.makeMove();
            playerMove.getPiece().move(player, (Cell) playerMove.getToCell(), board, defaultAdditionalBlockers());
            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }
}
