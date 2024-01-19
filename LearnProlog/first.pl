% Animal facts
has_fur(cat).
has_feathers(bird).
has_scales(fish).

% Rule to determine if an animal is warm-blooded
warm_blooded(X) :-
    has_fur(X).

warm_blooded(X) :-
    has_feathers(X).

% Rule to determine if an animal is cold-blooded
cold_blooded(X) :-
    has_scales(X).

% Query examples
% Try querying warm_blooded and cold_blooded with different animals
% For example:
% ?- warm_blooded(cat).
% ?- cold_blooded(fish).
