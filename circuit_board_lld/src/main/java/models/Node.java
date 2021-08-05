package models;

import processor.BoardProcessor;

import java.util.List;

public class Node {
    int id;
    public List<Node> inputs;

    BoardType boardType;
    public BoardProcessor processor;

    public Node(BoardType boardType) {
        this.boardType = boardType;
    }

    public Node(int id, BoardType boardType) {
        this.id = id;
        this.boardType = boardType;
        this.processor = BoardProcessor.getInstance(boardType);
    }



    public void setInputs(List<org.w3c.dom.Node> nodes) {
        this.inputs = inputs;
    }
}
