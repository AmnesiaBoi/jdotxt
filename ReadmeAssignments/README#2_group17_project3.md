#Assignment 2

- Diogo Barros
	-- nº 51959
		- 51959@alunos.fc.ul.pt

- Eduardo Carvalho
	-- nº 55881
	    - fc55881@alunos.fc.ul.pt

- Software Verification and Validation.
	-- Lecturer: Dr. José Campos.

- FCUL - Faculdade de Ciências da Universidade de Lisboa.

DELIVERY STRUCTURE
---------------
group17_project3.zip
- Test_Report_jdotxt.pdf
- README.md
- Anexos
    - MD_report#1.html
	- MD_report#2.html

INTRODUCTION
---------------

> This assignment was made by Eduardo Carvalho and Diogo Barros for 
> the Software Verification and Validation - lectured by Dr. José Campos.
> The intent is to incrementally add testing capabilities and tools, either 
> manual or automatic to the dotxt project, which can originally be found here:
> https://github.com/chms/jdotxt/

BUILD INSTRUCTIONS
---------------
> To download our current project, this is the respective repository:
>
> https://github.com/AmnesiaBoi/jdotxt
>
> To run the PMD Maven plugin, run Maven build with the targets: *jxr:jxr pmd:check

REQUIREMENTS
---------------
> We recommend opening this README.md file in a markdown editor/interface for proper displaying.
> Or otherwise a normal text editor.

Recommended:
```sh 
Notepad++
```

# jdotxt DESCRIPTION
---------------
> "jdotxt is an open source, cross-platform Desktop tool for managing your todo list. 
> It’s geared towards Gina Trapani’s todo.txt file format and stores all of your stuff in two human readable text files. 
> Having these files on your owncloud, dropbox or any other cloud storage makes it easy as pie to keep your todos in sync across multiple devices"
>
> https://blog.chschmid.com/?p=1305

# BLACKBOX-TESTING | CATEGORY PARTITION
---------------
## Parameters 

> Calculates the cursor position when a string changes based on the cursor
> position prior to the change
> 
>@param priorCursorPosition
>--            the position of the cursor prior to the change
> @param priorValue
>--            the prior value of the string
> @param newValue
>--             the new value of the string
> @return the calculated position. If priorValue is null than the
>--          calculated position will be the position just after the string.
>--          If the newValue is null than the position will be 0.

## priorCursorPosition
---
### Possible values:
| priorCursorPosition | Negative | 0  | positive |
|---------------------|----------|----|----------|
| priorValue          | null     | "" | "abc"    |
| newValue            | null     | "" | "abc"    |

### Possible Combinations:
| priorCursorPosition | priorValue | newValue |
|----------|-------|-------|
| negative | ""    | "abc" |
| 0        | null  | "abc" |
| 0        | "abc" | null  |
| 0        | ""    | ""    |
| 0        | ""    | "abc" |
| 0        | "abc" | ""    |
| 0        | "abc" | "abc" |
| positive | ""    | ""    |
| positive | ""    | "abc" |
| positive | "abc" | ""    |
| positive | "abc" | "abc" |

## insertAt
> Possible values:
> TODO
> TODO
> TODO

#Possible Combinations:
| priorCursorPosition | priorValue | newValue |
-----------------------------------------------
|      negative       |    ""      |   "abc"  |   negative priorCursorPosition
-----------------------------------------------
|         0           |   null     |   "abc"  |	  each string as null
|         0           |   "abc"    |   null   |
-----------------------------------------------
|         0           |    ""      |    ""    |
|         0           |    ""      |   "abc"  |
|         0           |   "abc"    |    ""    |
|         0           |   "abc"    |   "abc"  |
-----------------------------------------------
|      positive       |    ""      |    ""    |
|      positive       |    ""      |   "abc"  |
|      positive       |   "abc"    |    ""    |
|      positive       |   "abc"    |   "abc"  |

## calendarValidator
> Possible values:
> - priorCursorPosition: negative, 0, positive
> - priorValue: null, "", "abc"
> - newValue: null, "", "abc"

/**
 * This method returns a String representing the relative date by comparing
 * the Calendar being passed in to the date / time that it is right now.
 * 
 * @param calendar
 * @return String representing the relative date
 */

> public static String getRelativeDate(Calendar calendar)

> Calendar is an interface. 
> The only implementation in Java 8 of Calendar is Gregorian Calendar.
> The Gregorian calendar has these fields: ERA, YEAR, MONTH, DAY_OF_MONTH,
>   WEEK_OF_MONTH, DAY_OF_WEEK_IN_MONTH, AM_PM, HOUR, HOUR_OF_DAY, MINUTE,
>   SECOND, MILLISECOND

> Possible values:
ERA                  - BC, AD (will be ignored)
YEAR                 - negative, 0, positive
MONTH                - negative, 0, positive
DAY_OF_MONTH         - negative, 0, positive
WEEK_OF_MONTH        - (not in constructor)
DAY_OF_WEEK_IN_MONTH - (not in constructor)
AM_PM                - (not in constructor)
HOUR                 - (not in constructor)
HOUR_OF_DAY          - negative, 0, <24, >= 24 
MINUTE               - negative, 0, <60, >= 60 
SECOND               - negative, 0, <60, >= 60
MILLISECOND          - negative, 0, <1000, >= 1000

Combinations:
|   YEAR   |   MONTH   | DAY_OF_MONTH | HOUR_OF_DAY |  MINUTE  |  SECOND  | MILLISECOND |
-----------------------------------------------------------------------------------------
| negative | positive  |   positive   |    <24      |   <60    |   <60    |   <1000     |  negative ints
| positive | negative  |   positive   |    <24      |   <60    |   <60    |   <1000     |
| positive | positive  |   negative   |    <24      |   <60    |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      | negative |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    | negative |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |   <60    |  negative   |
-----------------------------------------------------------------------------------------
|    0     | positive  |   positive   |    <24      |   <60    |   <60    |   <1000     |  0
| positive |    0      |   positive   |    <24      |   <60    |   <60    |   <1000     |
| positive | positive  |      0       |    <24      |   <60    |   <60    |   <1000     |
| positive | positive  |   positive   |     0       |   <60    |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      |    0     |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |    0     |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |   <60    |     0       |
-----------------------------------------------------------------------------------------
| positive | positive  |   positive   |    >=24     |   <60    |   <60    |   <1000     |  exceeding time constraints
| positive | positive  |   positive   |    <24      |   >=60   |   <60    |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |   >=60   |   <1000     |
| positive | positive  |   positive   |    <24      |   <60    |   <60    |   >=1000    |
-----------------------------------------------------------------------------------------
| positive | positive  |   positive   |    <24      |   <60    |   <60    |   <1000     |  regular use case

group17_project3.PDF STRUCTURE
- jdotxt
    - Project Description
    - Code Structure
- Static Testing Tool: PMD
    - Tool Description
    - Usage Reasoning
    - Ruleset Configuration
- Test Report #1
    - Selected Bugs
- Test Report #2
- Comments
- Bibliography

MANTAINERS
---------------

This report was made by:
> Diogo Barros | nº51959 | fc51959@alunos.fc.ul.pt | Master's in Informatics Engineering | FCUL
> Eduardo Carvalho | nº55881 | fc55881@alunos.fc.ul.pt | Master's in Informatics | FCUL