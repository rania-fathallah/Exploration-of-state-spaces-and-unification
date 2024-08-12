# Exploration of state spaces and unification

## Project Overview

This project explores various problem-solving techniques in artificial intelligence, with a particular focus on search algorithms and unification. The codebase includes implementations in both Prolog and Java.


## Directory Structure

### fermier:
    Contains code related to the farmer's problem, including state representations and search algorithms.

### unification:
    Implements a unification algorithm for first-order logic.

### integer_factorization:
    Explores integer factorization using backtracking in Prolog and Java.

## Problem Descriptions

### Farmer's Problem:
    A classic AI planning problem involving a farmer, a wolf, a goat, and a cabbage. The goal is to transport all items across a river while ensuring that no harmful combinations occur.
### Unification:
    A fundamental operation in logic programming, used to determine if two terms can be made identical by substituting variables with terms.

### Integer Factorization:
    The problem of decomposing a composite number into its prime factors.


## Code Explanation

### fermier:
#### State:
    Represents a state in the farmer's problem, including the positions of the farmer and the items.

#### Solver:
Implements a search algorithm (e.g., depth-first search, breadth-first search) to explore the state space.

### unification:
#### SubstitutionSet:
    Represents a set of variable substitutions.
#### unify:
    Implements the unification algorithm.

### Languages:
#### Prolog:
    Uses backtracking to recursively explore possible factorizations.
#### Java:
    Implements a similar backtracking algorithm.

### Each file has more information on the project it contains in a file name 'exploration.pdf'.
