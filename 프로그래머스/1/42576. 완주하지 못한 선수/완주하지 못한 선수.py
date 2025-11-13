from collections import Counter

def solution(participant, completion):
    p = Counter(participant)
    c = Counter(completion)

    return next(iter(p - c))
