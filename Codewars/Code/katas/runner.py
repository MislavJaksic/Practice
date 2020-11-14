"""
    codewars-katas.py
    ------------------

    Runs the project.

    :copyrgiht: 2019 MislavJaksic
    :license: MIT License
"""
import sys


def shorten(string):
    if len(string) < 4:
        return string
    return string[0] + str(len(string[1:-1])) + string[-1]


def abbreviate(s):
    low = 0
    high = 0
    new_string = ""
    for i in range(len(s)):
        if s[i].isalpha():
            high = i
        else:
            if high > low:
                new_string += shorten(s[low + 1 : high + 1])
            new_string += s[i]
            low = i
            high = i
    if high > low:
        new_string += shorten(s[low + 1 : high + 1])

    return new_string


def main(args):
    """main() will be run if you run this script directly
    """
    print(abbreviate("Accessibility"))


def run():
    """Entry point for the runnable script.
    """
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    """main calls run().
    """
    run()
