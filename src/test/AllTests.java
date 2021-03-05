package com.todotxt.todotxttouch.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	
	import java.util.EmptyStackException;
	import java.util.Stack;

	class JunitTesting extends copyFile {

		@Test
	    @FileSource(file = newFile)
	    void testFileExists(newFile.exists())
	    }
	}
}


/*Category Partition Method

grep - search a file for a X pattern
grep <pattern> <filename>

guide:
http://209.242.1.146/docs/TestPatternCategoryPartition.pdf

Parameters:
	Pattern size:
	empty 										[property Empty]
	single character 							[property NonEmpty]
	many character 								[property NonEmpty]
	longer than any line in the file 			[property NonEmpty]
Quoting:
	pattern is quoted 							[property Quoted1
	pattern is not quoted 						[if NonEmpty]
	pattern is improperly quoted 				[if NonEmpty]
Embeddedblanks:
	no embedded blank 							[if NonEmpty]
	one embedded blank 							[if NonEmpty and Quoted1
	several embedded blanks 					[if NonEmpty and Quoted]
Embeddedquotes:
	no embedded quotes 							[if NonEmpty]
	one embedded quote 							[if NonEmpty]
	several embedded quotes 					[if NonEmpty]
Filename:
	good file name
	no file with this name
	omitted
Environments:
	Number of occurrences ofpatterninfile:
		none									[if NonEmpty]
		exactly one 							[if NonEmpty] [property Match]
		more than one 							[if NonEmpty] [property Match]
	Pattern occurrencesontargetline:
		# assumes line contains the pattern
		one 									[if Match]
		more than one 							[if Match]

*/