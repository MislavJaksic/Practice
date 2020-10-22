"""
    codewars-katas.py
    ------------------

    Runs the project.

    :copyrgiht: 2019 MislavJaksic
    :license: MIT License
"""
import sys


def iq_test(numbers):
    even_i = 0
    odd_i = 0
    list = numbers.split(" ")
    list = [int(x) for x in list]
    for (number, i) in zip(list, range(len(numbers))):
        if number % 2 == 0:
            if even_i == 0:
                even_i = i + 1
            elif odd_i != 0:
                return odd_i
        else:
            if odd_i == 0:
                odd_i = i + 1
            elif even_i != 0:
                return even_i
    return len(list)


def main(args):
    """main() will be run if you run this script directly
    """
    print(iq_test("16 20 50 6 4 2 22 2 50 26 48 10 47"))


def run():
    """Entry point for the runnable script.
    """
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    """main calls run().
    """
    run()
