## Cracking the Coding Interview

Cracking The Coding Interview is a book written by Gayle Laakmann McDowell.  
It promises to help the reader get a great coding job.  
Be it as it may, what it does have is a lot of interesting problems (and solutions).  

### Introduction

Candidates have to solve interview questions.  
To solve them they need to practice developing fresh algorithms.  

### Interview process

Talk out loud throughout the problem.  
A candidate will be scored on the following:
* how many hints did they need; was the solution optimal; how long did it take them; did they think about tradeoffs  
* did you translate your algorithm into code well; was it clean and organized; did they think about errors; did they have a good style  
* do they have a strong foundation in computer science  
* have they made good technical decisions; have they built challenging projects; did they show drive and initiative  
* how well did they communicate; were they a good culture fit  

The book answers why these questions are important.  

### Behind the scenes

A candidate will first do a screening interview.  
After a successful screening, you will be brought on site to interview with 3 to 6 people.  

In general, most big tech companies interview the same way.  

### Special situations

TODO, nothing special though.

### Before the interview

#### Get the right experience

Big class projects, interships and freelance project are great for students.  
Professionals should build something for fun or try to shift their work responsibilities.  

Companies want to see you are smart and that you can construct programs.  

#### Writing a CV

Make sure your CV fits onto one page.  
Only include the most relevent and most impressive positions.  

Write strong bullet points.  
Show what you did, how you did it and what were the results:  
```
"Reduced object rendering time by 75% by implementing distributed caching, leading to a 10% reduction in log-in time."
"Increased average match accuracy from 1.2 to 1.5 by implementing a new comparison algorithm based on windiff."
```

Add up to 4 relevent projects to your CV.  
Say what it was about, which technologies you used and if it was a team/individual/independent/course project.  

Describe your software and language profficiency in plain English.  

### Behavioral questions

TODO

### Big O

Example 1: O(N + N) -> O(N)  
* Easy, just drop the constant  
Example 2: O(N*N) -> O(N**2)  
* Easy, multiply FOR loops  
Example 3: O(N*N/k) -> O(N*N)  
* Easy, triangular matrix or sum the inner loop steps  
Example 4: O(N*M)  
* Easy, N and M are different  
Example 5: O(N*M*k) -> O(N*M)  
* Easy, a constant amount of work, no matter how big it is is still constant  
Example 6: O(N/k) -> O(N)  
* Easy, drop the constant  
Example 7: O(N + N/k) -> O(N); O(k*N) -> O(N); O(N + logN) -> O(N); O(N + M)  
* Easy, drop constants and suppress non-largest terms  
Example 8: O(S*logS*A + A*logA*S) -> O(S*A*(logA + logS))  
* Break down the problem: compare chars, sort characters, compare strings, sort strings  
Example 9: O(N)  
* Imagine a tree and how many times each node is visited  
Example 10: O(root(N))  
* Worst case scanario, the number is prime  
* You could argue that division is not O(1); if you sum every subtraction then it is O(N)  
Example 11: O(N)  
* Easy, don't get distracted, inspect what the algorithm does  
Example 12: O(N!*N*N)  
* Hard, imagine a large tree; string printing, tree depth and path to leaf node length have to be taken into account  
Example 13: O(2**N)  
* Easy, imagine a tree and how much work each node has to do  
Example 14: O(2**(N+1)) -> O(2**N)  
* Trap question, sum the steps it takes to generate each number  
Example 15: O(2*N)  
* Easy, examine howto algorithm behaves  
Example 16: O(logN)  
* Easy, imagine how muchmore work you have to do as the number grows larger  

V1: O(B)  
* Easy, as B increases, the number of steps increases  
V2: O(B)  
* Easy, similar to the previous question  
V3: O(1)  
* Easy, assuming that division and multiplication are both O(1)  
V4: O(A/B)  
* Both affect the final outcome  
V5: O(logN)  
* Halves the interval at each step  
V6: O(root(N))  
* Trick question, look at the FOR loop counter  
V7: O(N)  
* Worst case, the tree is a single linked list  
V8: O(N)  
* Searching a non search tree is as bad as searching a list  
V9: O(N**2)  
* Sum all the steps it takes to create an array from scratch  
V10: O(logN)  
* Trick question, the number of digits is equal to the logarithm!  
V11: O(K*(C**K))  
* Check if the string is ordered and generate all strings in the alphabet  
V12: O(B*logB + A*logB)  
* Mergesort, then binary search multiple times  

### Technical questions

Solve problems on your own.  
Solve them on paper first.  
Test your code on paper.  
Retype your code into the computer.  

You need to know the basics:  
* lists, trees, tries, graphs, stacks, queues, heaps, vectory, hash tables  
* breadth first, depth first, binary search, merge sort, quick sort  
* bit manipulation, memory concepts, recursion, dynamic programming, big O  

If you are unsure how they work, implement them until you do.  

Some tips:
* listen carefully: examine each word and concepts, they might be important  
* draw a good example; not too big not too small; avoid drawing a neat special case  
* state the brute force algorithm as soon as possible as well as big O
* test your naive algorithm: pay attention to strange code, exceptional inputs, special and edge cases  
* optimize the algortihm; use examples, ask questions, make space time trades, use data structures  
* always walk though your optimal code  
* implement your code in a neat way  

Optimization and solving tips:
* reduce bottlenecks, remove unnecessary work, eliminate duplicate work
* solve the problem by hand
* simplify then generalize
* find the base case teh nbuild up
* walk through the data structures

Good code has a few characteristics:
* correctness
* efficiency
* simplicity
* readability
* maintainability
* uses lots of data structures
* reuses code
* is modular
* is flexible and robust
* checks for errors

### The offer and beyond

### Interview questions

#### Arrays and strings

HashTables:
