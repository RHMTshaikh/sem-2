yCar(auckland, hamilton).
byCar(hamilton,raglan).
byCar(valmont, saarbruecken).
byCar(valmont, metz).

byTrain(metz,frankfurt).
byTrain(saarbruecken, frankfurt).
byTrain(metz, paris).
byTrain(saarbruecken, paris).

byPlane(frankfurt, bangkok).
byPlane(frankfurt, singapore).
byPlane(paris, losAngeles).
byPlane(bangkok, auckland).
byPlane(losAngeles, auckland).

show_path([C1,C2,M|T]) :- nl, show_path(T).

direct_path(C1,C2,[C1,C2,' by car']):- byCar(C1,C2).
direct_path(C1,C2,[C1,C2,' by train']):- byTrain(C1,C2).
direct_path(C1,C2,[C1,C2,' by plane']):- byPlane(write(C1), write(' to_'),write(C2), write(Me(C1,C2).

travel(C1,C2,L) :- direct_path(C1,C2,L).
travel(C1,C2,L) :-direct_path(C1,C3,L1), travel(C3,C2,L2),append(L1,L2,L).

go(C1,C2) :- travel(C1,C2,L), show_path(L).

