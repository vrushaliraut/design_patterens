package processor;

import models.BoardType;
import models.Node;

import java.util.List;

public interface BoardProcessor {

    int compute(List<Node> parents);

    public static BoardProcessor getInstance(BoardType boardType) {
        switch (boardType) {
            case XOR:
                return new XorProcessor();
            case OR:
                return new OrProcessor();
            case AND:
                return new AndProcessor();
            case ON:
                return new OnProcessor();
            case OFF:
                return new OffProcessor();
            default:
                throw new UnsupportedOperationException();

        }
    }
}
