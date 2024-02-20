% :-use_module(library(clpfd)).

puzzle([S,E,N,D] + [M,O,R,E] = [M,O,N,E,Y]) :-
Vars = [S,E,N,D,M,O,R,Y],
Vars ins 0..9,
all_different(Vars),
S*1000 + E*100 + N*10 + D +
M*1000 + O*100 + R*10 + E #=
M*10000 + O*1000 + N*100 + E*10 + Y,
M #\= 0, S #\= 0.


weather(dubai, summer,hot).
weather(dubai,winter,warm).
weather(sharjah,winter,cold).

greetings:-
    write('What is your name ?'),
    nl,
    read(X),
    write('hi '),
    write(X).


greet(hamish):-
    write('How are you doin, pal?').
greet(amelia):-
    write('Awfully nice to see you!').

% prin([])
% prin([X|Y]):-write(X),prin(Y).

p([]).
p([X|Y]):-write(X),p(Y).

q([]).
q([X|Y]):-write(X),write(' '),q(Y).

member(H,[H|_]).
member(H,[_|T]):-
member(H,T).

f(X,Y):-X<3,!,Y is 0;X<6,!,Y is 2; Y is 4.
