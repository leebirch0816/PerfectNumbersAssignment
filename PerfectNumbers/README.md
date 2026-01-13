# PerfectNumbers

## Overview
This Java console program finds and displays **perfect numbers** within a user-defined range.
A **perfect number** is a positive integer that equals the sum of its positive divisors **excluding itself**
(e.g., 6 = 1 + 2 + 3).

The program runs in two parts:
1. **Part 1**: Prints perfect numbers between **1 and 200**
2. **Part 2**: Prompts the user to enter an upper limit and prints perfect numbers between **1 and that limit**
   - The user may type **q** to quit.

## Program Requirements Implemented
- Display the program purpose and instructions before running
- Part 1: Use a loop to check numbers from **1 to 200**
- Part 2: Accept an upper limit from the keyboard (console input)
  - Repeat until the user chooses to quit
- For each range, determine perfect numbers by:
  - Finding divisors of each number
  - Summing divisors (excluding the number itself)
  - Comparing the sum to the original number
- Use loops and decision logic to control flow and output results

## Input Rules
- In Part 2, the user can enter:
  - A positive integer upper limit (e.g., **200**, **8000**, **90000**), OR
  - **q** to quit
- If the input is not a valid integer or is less than 1, the program prompts again

## How to Compile & Run

Compile:
- `javac -d bin src\App.java`

Run:
- `java -cp bin App`

> Note: Run these commands in the folder where `App.java` is located (e.g., in PowerShell/Terminal).