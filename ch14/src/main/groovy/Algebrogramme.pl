% algram([0, M, O, R, E],[0, S, E, N, D],[M, O, N, E, Y]).

algram(Word1, Word2, [H|T]):-
    s(Word1, Word2, [H|T],
    0,0,
    [1,2,3,4,5,6,7,8,9,0],_), not(H=0).

s([], [], [], 0, 0, Numbers, Numbers).
s([H1|T1], [H2|T2], [H|T], N1, N, Number1, Number):-
    s(T1, T2, T, N1, N2, Number1, Number2),
    sumnum(H1, H2, N2, H, N, Number2, Number).

sumnum(H1, H2, N1, H, N, Number1, Number):-
        del(H1, Number1, Number2),
        del(H2, Number2, Number3),
        del(H, Number3, Number),
        S is H1 + H2 + C1,
        H is S mod 10,
        C is S // 10.

del(A, L, L):- nonvar(A), !.
del(A, [A|L], L).
del(A, [B|L], [B|L1]):- del(A,L,L1).