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