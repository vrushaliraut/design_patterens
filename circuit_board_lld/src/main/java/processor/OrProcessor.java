package processor;

import models.Node;

import java.util.List;

public class OrProcessor implements BoardProcessor {
    @Override
    public int compute(List<Node> inputs) {
        int res = 1;
        for (Node parent : inputs) {
            res |= parent.processor.compute(parent.inputs);
        }
        return res;
    }
}
