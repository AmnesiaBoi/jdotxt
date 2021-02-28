## METADATA

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

REQUIREMENTS
---------------
> We recommend opening this README.md file in a markdown editor/interface for proper displaying.

Recommended:
```sh 
Notepad++
```

jdotxt Description
---------------
> "jdotxt is an open source, cross-platform Desktop tool for managing your todo list. 
> It’s geared towards Gina Trapani’s todo.txt file format and stores all of your stuff in two human readable text files. 
> Having these files on your owncloud, dropbox or any other cloud storage makes it easy as pie to keep your todos in sync across multiple devices"
>
> https://blog.chschmid.com/?p=1305

Build Instructions
---------------
> To download our current project, this is the respective repository:
>
> https://github.com/AmnesiaBoi/jdotxt
>
> To run the PMD Maven plugin, run Maven build with the targets: *jxr:jxr pmd:check

PMD_report#_.html STRUCTURE
---------------
> The HTML report follows a downward entry of bug urgency, going from most critical to least

> #Syntax
> *com/<user>/<project_name>/<file_name>.java

| Rule            | Violation   | Line        |
|-----------------|-------------|-------------|
| Convention Name | Description | Line Number |
|                 |             |             |

> #Example
| Rule                    | Violation                                                                                          | Line |
|-------------------------|----------------------------------------------------------------------------------------------------|------|
| MethodNamingConventions | The native method name 'SetCurrentProcessExplicitAppUserModelID' doesn't match '[a-z][a-zA-Z0-9]*' | 52   |
|                         |                                                                                                    |      |

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