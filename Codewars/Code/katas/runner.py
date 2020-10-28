"""
    codewars-katas.py
    ------------------

    Runs the project.

    :copyrgiht: 2019 MislavJaksic
    :license: MIT License
"""
import sys

import string


def is_pangram(s):
    letters = list(string.ascii_lowercase)
    for char in s:
        try:
            letters.remove(char.lower())
        except:
            pass
        if not letters:
            return True
    print(letters)
    return False


def main(args):
    """main() will be run if you run this script directly
    """
    print(is_pangram("The quick, brown fox jumps over the lazy dog!"))


def run():
    """Entry point for the runnable script.
    """
    sys.exit(main(sys.argv[1:]))


if __name__ == "__main__":
    """main calls run().
    """
    run()
