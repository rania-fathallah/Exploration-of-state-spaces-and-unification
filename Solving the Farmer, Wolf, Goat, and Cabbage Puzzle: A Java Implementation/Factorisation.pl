factorisation(X,D):-factors(X,D,2).
factors(X,D,Y):-Y=<X, (X1 is X/Y, 0 is X mod Y, factors(X1,K,Y), D = [Y|K] ;Y1 is Y+1,factors(X,D,Y1)).
factors(1,[],Y).
