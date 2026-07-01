#!/usr/bin/env python3
# NOTE: Very useful in utility scripts and debugging scenarios.

def counter():
    counter.count += 1
    return counter.count


# Initialize the counter
counter.count = 0

for i in range(3):
    print(f"Loop {i} -> Count = {counter()}")
