female(aa).
female(cc).
female(dd).
female(gg).
female(ii).
female(kk).
female(nn).

male(bb).
male(ff).
male(ee).
male(hh).
male(jj).
male(mm).
male(ll).

child(cc,bb).
child(dd,bb).
child(ee,bb).

child(hh,ff).
child(ii,ff).
child(jj,ff).

child(kk,ee).
child(ll,ee).

child(nn,mm).

child(pp,hh).

marriedTo(aa,bb).
marriedTo(cc,ff).
marriedTo(gg,ee).
marriedTo(kk,mm).
marriedTo(oo,hh).

couple(X,Y):-marriedTo(Y,X).
couple(X,Y):-marriedTo(X,Y).

husband(H,W):-couple(H,W),male(H).
husband(H,W):-couple(W,H),male(H).

wife(W,H):-couple(H,W),male(H).
wife(W,H):-couple(W,H),male(H).

parent(P,C):-child(C,P).
parent(P,C):-couple(P,X),child(C,X).

father(F,C):-parent(F,C),male(F).
mother(M,C):-parent(M,C),female(M).

sibling(A,B):- parent(X,A),child(B,X),A\=B.

brother(B,X):-male(B),sibling(B,X).
sister(S,X):-female(S),sibling(S,X).

cousin(X,Y):-father(A,X),father(B,Y),sibling(A,B).
cousin(X,Y):-mother(A,X),mother(B,Y),sibling(A,B).
cousin(X,Y):-father(A,X),mother(B,Y),sibling(A,B).
cousin(X,Y):-mother(A,X),father(B,Y),sibling(A,B).

grand_father(F,C):-parent(X,C),parent(F,X),male(F).
grand_mother(M,C):-parent(X,C),parent(M,X),female(M).

ancesstor(A,D):-parent(A,D).
ancesstor(A,D):-parent(A,X),ancesstor(X,D).


aunt(A,B):-female(A),parent(X,B),sibling(A,X).
uncle(A,B):-male(A),parent(X,B),sibling(A,X).

meternal_aunt(A,B):-female(A),mother(X,B),sibling(A,X).
meternal_uncle(A,B):-male(A),mother(X,B),sibling(A,X).

bhabhi(B,X):-husband(H,B),brother(H,X).
dewar(D,X):-husband(H,X),brother(D,H).
sasur(S,X):-father(S,Y),couple(Y,X).