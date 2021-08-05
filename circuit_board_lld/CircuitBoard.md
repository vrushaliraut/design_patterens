## Problem

Design a Circuit board system that can contain one or more switches in any specific arrangement as defined by User
input (Assume inputs from command line, UI not required).

* Rules:

-A switch can be of type XOR, OR, AND, NOT. -A switch can have one or more inputs. Each input can be 0 or 1. -A switch
will always result in one output which is 0 or 1. -It is possible to arrange switches in series or parallel. And there
can be intermediate switches such that inputs of switch is coming from output to other switches.

-As a system, the circuit should result in a single output.

-Expectation:

-Data Models to support such a system. -Algorithm to calculate the resultant output (0 or 1) of the Circuit board.

## Solution

- The Circuit board has been modeled as a graph, where switches are defined as nodes.
- Parent connections are needed to compute the output of any node.

* BoardManager

- BoardSystem

* BoardSystem - Holds the state

- Map<Integer, Node> nodes
- Map<Integer, List<Integer>> parents
- initialize(int[] nodes, int[][] edges, String[] types)
- int compute()
- addNode(id, type)
- addEdge(parentNodeId, childNodeId)

* Node

- id
- type

* BoardProcessor processor - Defines the calculation behavior - OR/AND/XOR.

- My initial thinking is that each node can be subclassed into Or, And, .. for node level calculation.
- But its a reasonable assumption that users want to edit/change the compute behavior of node at run time.
- So Strategy pattern works best to compose this behavior into a Processor class.

* BoardProcessor

- int compute(List<Node> parents)

* Concrete Processor classes

- OnProcessor - always 1, for initial input switches
- OffProcessor - always 0, for initial input switches
- OrProcessor
- AndProcessor
- XorProcessor 