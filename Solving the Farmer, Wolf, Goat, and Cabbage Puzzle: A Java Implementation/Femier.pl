goal(1,1,1,1).
fermier(F,W,G,C):-fermier(F,W,G,C,[(F,W,G,C)]).
fermier(F,W,G,C,L):-goal(F,W,G,C);moveW(F,W,G,C,L);moveG(F,W,G,C,L);moveC(F,W,G,C,L);moveF(F,W,G,C,L).

valid_state(F,W,G,C) :-( F \= W , F \= G);( F \= G, F \= C).
moveW(F,W,G,C,L):- F=W,(W = 1 -> W1 is -1 ; W1 is 1),(F = 1 -> F1 is -1 ; F1 is 1),not(valid_state(F1,W1,G,C)),not(member((F1,W1,G,C),L)),fermier(F1,W1,G,C,[(F1,W1,G,C)|L]).
moveC(F,W,G,C,L):- F=C,(C = 1 -> C1 is -1 ; C1 is 1),(F = 1 -> F1 is -1 ; F1 is 1),not(valid_state(F1,W,G,C1)),not(member((F1,W,G,C1),L)),fermier(F1,W,G,C1,[(F1,W,G,C1)|L]).
moveG(F,W,G,C,L):- F=G,(G = 1 -> G1 is -1 ; G1 is 1),(F = 1 -> F1 is -1 ; F1 is 1),not(valid_state(F1,W,G1,C)),not(member((F1,W,G1,C),L)),fermier(F1,W,G1,C,[(F1,W,G1,C)|L]).
moveF(F,W,G,C,L):-(F = 1 -> F1 is -1 ; F1 is 1),not(valid_state(F1,W,G,C)),not(member((F1,W,G,C),L)),fermier(F1,W,G,C,[(F1,W,G,C)|L]).
