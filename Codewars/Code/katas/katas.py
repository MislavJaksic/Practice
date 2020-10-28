# def count_sheeps(sheep):
#     return len([x for x in sheep if x == True])


def count_sheeps(sheep):
    return sheep.count(True)


# def open_or_senior(data):
#     positions = []
#     for (age, handicap) in data:
#         if age > 54 and handicap > 7:
#             positions.append("Senior")
#         else:
#             positions.append("Open")
#     return positions


def openOrSenior(data):
    return [
        "Senior" if age > 54 and handicap > 7 else "Open" for (age, handicap) in data
    ]


# def tribonacci(signature, n):
#     if 3 > n:
#         return signature[:n]
#     while n > len(signature):
#         signature.append(sum(signature[-3:]))
#     return signature


def tribonacci(signature, n):
    while n > len(signature):
        signature.append(sum(signature[:-3]))
    return signature[:n]


# def validate_pin(pin):
#     count = 0
#     for digit in pin:
#         if digit in ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"]:
#             count += 1
#             if count > 6:
#                 return False
#         else:
#             return False
#
#     if count in [4, 6]:
#         return True
#     return False


def validate_pin(pin):
    return len(pin) in (4, 6) and pin.isdigit()


def array_diff(a, b):
    return [x for x in a if not x in b]


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


# A clever alternative solution: does not short-circuit!
# def iq_test(numbers):
# e = [int(i) % 2 == 0 for i in numbers.split()]
#
# return e.index(True) + 1 if e.count(True) == 1 else e.index(False) + 1


# def get_digit(word):
#     for char in word:
#         if char.isdigit():
#             return int(char)
#
#
# def order(sentence):
#     word_list = sentence.split(" ")
#     order = [get_digit(x) for x in word_list]
#     ordered = list(zip(word_list, order))
#     ordered.sort(key=lambda tup: tup[1])
#     return " ".join([word for (word, i) in ordered])

# More pythonic then mine
# def extract_number(word):
#     for l in word:
#         if l.isdigit(): return int(l)
#     return None
#
# def order(sentence):
#     return ' '.join(sorted(sentence.split(), key=extract_number))


# Concise: split, find key, sort by key, join
def order(words):
    return " ".join(sorted(words.split(), key=lambda w: sorted(w)))


# def namelist(names):
#     names = [x["name"] for x in names]
#     if 0 == len(names):
#         return ""
#     if 1 == len(names):
#         return names[0]
#     return ", ".join(names[:-1]) + " & " + names[-1]

# Three clear cases
def namelist(names):
    if len(names) > 1:
        return "{} & {}".format(
            ", ".join(name["name"] for name in names[:-1]), names[-1]["name"]
        )
    elif names:
        return names[0]["name"]
    else:
        return ""


import string


# def alphabet_position(text):
#     return " ".join(
#         [
#             str(string.ascii_lowercase.index(letter) + 1)
#             for letter in text.lower()
#             if letter in string.ascii_lowercase
#         ]
#     )


# More elegent solution
def alphabet_position(s):
    return " ".join(str(ord(c) - ord("a") + 1) for c in s.lower() if c.isalpha())


def is_valid_walk(walk):
    distance = 0
    for dir in walk:
        if dir == "n":
            distance += 1
        if dir == "s":
            distance += -1
        if dir == "e":
            distance += 11
        if dir == "w":
            distance += -11

    if distance == 0 and len(walk) == 10:
        return True
    return False


# Clever, but we have to pass through the list 4 times!
# def isValidWalk(walk):
#     return len(walk) == 10 and walk.count('n') == walk.count('s') and walk.count('e') == walk.count('w')


def find_it(seq):
    dict = {}
    for num in seq:
        if dict.get(num):
            dict[num] += 1
        else:
            dict[num] = 1
    for key, value in dict.items():
        if value % 2 == 1:
            return key


# Clever  but has to pass through the list n times!
# def find_it(seq):
#     for i in seq:
#         if seq.count(i)%2!=0:
#             return i

# Very clever!
# import operator
#
# def find_it(xs):
#     return reduce(operator.xor, xs)

import string


def transform(c):
    if c.islower():
        return string.ascii_lowercase[(ord(c) % 97 + 13) % 26]
    else:
        return string.ascii_uppercase[(ord(c) % 65 + 13) % 26]


def rot13(message):
    encrypted = []
    for c in message:
        if c.isalpha():
            c = transform(c)
        encrypted.append(c)

    return "".join(encrypted)


# Clever and short
# import string
#
# trans = string.maketrans('ABCDEFGHIJKLMabcdefghijklmNOPQRSTUVWXYZnopqrstuvwxyz', 'NOPQRSTUVWXYZnopqrstuvwxyzABCDEFGHIJKLMabcdefghijklm')
#
# def rot13(message):
#     return message.translate(trans)

import math


def race(v1, v2, g):
    if v2 > v1:
        v_diff = v2 - v1
        t = g / v_diff * 3600
        h = math.trunc((t / 3600))
        m = math.trunc((t % 3600) / 60)
        s = math.trunc(t % 60)
        return [h, m, s]
    return None


# Shorter syntax
# def race(v1, v2, g):
#     if v1 < v2:
#         t = g * 3600 / (v2 - v1)
#         return [t//3600, t//60%60, t%60]


import itertools


def choose_best_sum(t, k, ls):
    combs = list(itertools.combinations(ls, k))
    best = -1
    for comb in combs:
        distance = sum(comb)
        if distance > best and distance <= t:
            best = distance
    return best if best != -1 else None


# Concise but inefficient as you need to create another list
# from itertools import combinations
#
# def choose_best_sum(t, k, ls):
#     return max((s for s in (sum(dists) for dists in combinations(ls, k)) if s <= t), default=None)


def find_uniq(arr):
    dict = {}
    for n in arr:
        if not dict.get(n):
            dict[n] = 1
        else:
            if len(dict) > 1:
                for key in dict:
                    if key != n:
                        return key
    return arr[-1]


# Clever use of a set data structure
# def find_uniq(arr):
#     a, b = set(arr)
#     return a if arr.count(a) == 1 else b


def title_case(title, minor_words=""):
    exceptions = minor_words.lower().split(" ")
    if title:
        all = title.lower().split(" ")
        first = [all[0].capitalize()]
        other = [word if word in exceptions else word.capitalize() for word in all[1:]]
        first.extend(other)
        return " ".join(first)
    return ""


# Much better solution; less verbose
# def title_case(title, minor_words=''):
#     title = title.capitalize().split()
#     minor_words = minor_words.lower().split()
#     return ' '.join([word if word in minor_words else word.capitalize() for word in title])

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


# Short and simple
# import string
#
# def is_pangram(s):
#     return set(string.ascii_lowercase).issubset(s.lower())


def duplicate_count(text):
    dict = {}
    for char in text.lower():
        if dict.get(char):
            dict[char] += 1
        else:
            dict[char] = 1
    count = 0
    for value in dict.values():
        if value > 1:
            count += 1
    return count


# Clever but not efficient
# def duplicate_count(s):
#   return len([c for c in set(s.lower()) if s.lower().count(c)>1])


def bouncing_ball(h, bounce, window):
    if h > 0 and h > window and bounce > 0 and 1 > bounce:
        count = 1
        while h * bounce > window:
            h = h * bounce
            count += 2
        return count
    else:
        return -1


# A horrid solution!
# def abbreviate(s):
#     new_string = []
#     first = None
#     previous = []
#     count = 0
#     for char in s:
#         if first:
#             if char.isalpha():
#                 count += 1
#                 previous.append(char)
#             else:
#                 new_string.append(first)
#                 if count > 2:
#                     new_string.append(str(count - 1))
#                     new_string.append(previous.pop())
#                 else:
#                     new_string.append("".join(previous))
#                 new_string.append(char)
#                 first = None
#                 previous = []
#                 count = 0
#         else:
#             if char.isalpha():
#                 first = char
#             else:
#                 new_string.append(char)
#     new_string.append(first)
#     if count > 2:
#         new_string.append(str(count - 1))
#         new_string.append(previous.pop())
#     else:
#         new_string.append("".join(previous))
#     return "".join(new_string)

# Better solution, a lot better one
import re

regex = re.compile("[a-z]{4,}", re.IGNORECASE)


def replace(match):
    word = match.group(0)
    return word[0] + str(len(word) - 2) + word[-1]


def abbreviate(s):
    return regex.sub(replace, s)
