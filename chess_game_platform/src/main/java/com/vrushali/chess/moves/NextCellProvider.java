package com.vrushali.chess.moves;

import com.vrushali.chess.models.Cell;

// Given a cell, it will provide next cell which can reach to.

public interface NextCellProvider {
    Cell nextCell(Cell cell);
}
