"""
    codewars-katas.py
    ------------------

    Runs the project.

    :copyrgiht: 2019 MislavJaksic
    :license: MIT License
"""
import sys

import itertools


def choose_best_sum(t, k, ls):
    combs = list(itertools.combinations(ls, k))
    best = -1
    for comb in combs:
        distance = sum(comb)
        if distance > best and distance <= t:
            best = distance
    return best if best != -1 else None


def main(args):
    """main() will be run if you run this script directly
    """
    print(
        choose_best_sum(
            430,
            8,
            [100, 76, 56, 44, 89, 73, 68, 56, 64, 123, 2333, 144, 50, 132, 123, 34, 89],
        )
    )


def run():
    """Entry point for the runnable script.
    """
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    """main calls run().
    """
    run()
