package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.todotxt.todotxttouch.task.Task;

public class TaskIoTest {

	/*
	 * TaskIo::loadTasksFromFile(File file)
	 */
	
	@Test
	public void testLoadTasksFromEmptyFile() throws IOException
	{
		File temporary = File.createTempFile("abc", null);
		
		List<Task> expected = Arrays.asList();
		List<Task> actual = TaskIo.loadTasksFromFile(temporary);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLoadTasksFromFile() throws IOException
	{
		File temporary = File.createTempFile("abc", null);
		
		List<String> tasks = Arrays.asList("task 1234", "task +project @context");
		
		PrintWriter pw = new PrintWriter(temporary);
		for (String task : tasks)
			pw.println(task);
		pw.close();
		
		List<Task> expected = Arrays.asList(new Task(0, tasks.get(0)), new Task(1, tasks.get(1)));
		List<Task> actual = TaskIo.loadTasksFromFile(temporary);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLoadTasksFromFileWithSpace() throws IOException
	{
		File temporary = File.createTempFile("abc", null);
		
		List<String> tasks = Arrays.asList("task 1234", "task +project @context");
		
		PrintWriter pw = new PrintWriter(temporary);
		for (String task : tasks)
			pw.println(task + "\n");
		pw.close();
		
		List<Task> expected = Arrays.asList(new Task(0, tasks.get(0)), new Task(2, tasks.get(1)));
		List<Task> actual = TaskIo.loadTasksFromFile(temporary);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testLoadTasksFromMissingFile() throws IOException
	{
		File temporary = new File("hellothere");
		
		List<Task> expected = Arrays.asList();
		List<Task> actual = TaskIo.loadTasksFromFile(temporary);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * TaskIo::writeToFile(List<Task> tasks, File file)
	 */
	
	@Test
	public void writeToFile() throws IOException
	{
		List<Task> tasks = Arrays.asList(new Task(0, "task +project"));
		File temporary = File.createTempFile("abc", null);
		
		TaskIo.writeToFile(tasks, temporary);
		
		List<String> expected = Arrays.asList("task +project");
		List<String> actual = new ArrayList<>();
		Scanner sc = new Scanner(temporary);
		while(sc.hasNextLine())
			actual.add(sc.nextLine());
		sc.close();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void writeToNullFile() throws IOException
	{
		ByteArrayOutputStream out;		
		// Redirect System.out
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		List<Task> tasks = Arrays.asList(new Task(0, "task +project"));
		File temporary = null;
		
		TaskIo.writeToFile(tasks, temporary);
		
		// Something was printed to the console as an error message
		assertFalse(out.toString().isEmpty());
	}
	/*
	 * new

	BREAKS MUTATION TEST due to "\r"

	@Test
	public void writeToFileWithSlashR() throws IOException
	{
		List<Task> tasks = Arrays.asList(new Task(0, "task +project"+"\r"));
		File temporary = File.createTempFile("abc", null);
		
		TaskIo.writeToFile(tasks, temporary);
		
		List<String> expected = Arrays.asList("task +project");
		List<String> actual = new ArrayList<>();
		Scanner sc = new Scanner(temporary);
		while(sc.hasNextLine())
			actual.add(sc.nextLine());
		sc.close();
		
		assertEquals(expected, actual);
	}
	 */
}
