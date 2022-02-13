package com.LockedMe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class LockedMe {

		public static void main(String[] args) {
			try {
				System.out.println("Welcome to LockedMe.com");
				Thread.sleep(1000);
				System.out.println("Developed By Chethan R");
				Thread.sleep(1000);
				System.out.println("LockedMe.com Helps to protect your Data");


			}
			catch (Exception e) {
				System.out.println("Some prob");
			}
			Scanner sc = new Scanner(System.in);
			Scanner s1 = new Scanner(System.in);

			System.out.println("Enter 1 to get the file list");
			System.out.println("Enter 2 to Business Operations");
			System.out.println("Enter 3 to close the Application");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println("Enter the File Location");
				String loc = s1.nextLine();
				File fileDir = new File(loc);
				if(fileDir.isDirectory()){
					List<String> listFile = Arrays.asList(fileDir.list());
					System.out.println("Sorting by filename in ascending order");
					for(String s:listFile){
						System.out.println(s);
					}
				}
				else{
					System.out.println(fileDir.getAbsolutePath() + " is not a directory");
				}
			}
			else if (choice ==2) {
				System.out.println("Enter 5 to create file");
				System.out.println("Enter 6 to Delete file");
				System.out.println("Enter 7 to Search file");
				
				int opt = sc.nextInt();
				if(opt == 5) {
				try {
					File file=new File("D:\\Test\\testfile5.txt");
					
					//create the file
					if(file.createNewFile())
						System.out.println("File is created");
					else
						System.out.println("File already Exist");
					
					//write data to file
					
					FileWriter writer=new FileWriter(file);
					writer.write("Welcome to File Handling");
					writer.close();
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
				}
				else if(opt ==6) {
					try {
						Files.deleteIfExists(Paths.get("D:\\Test\\testfile5.txt"));
						
					} catch (NoSuchFileException e) {
						System.out.println(e);
					}
					catch (DirectoryNotEmptyException e) {
						System.out.println("Directory is not Empty");
					}
					catch (IOException e) {
						System.out.println("IOException "+e);
					}
					System.out.println("Deletion successfull");
				}
				else if(opt == 7) {
					  String path = sc.nextLine();
						String fileName = sc.nextLine();
				          try {
				                  System.out.println("Please Enter the path-");
				                  BufferedReader filePathReader = new BufferedReader(
				                                  new InputStreamReader(System.in));
				                  path = filePathReader.readLine();
				                  System.out.println("Please Enter file Name-");
				                  BufferedReader fileNameReader = new BufferedReader(
				                                  new InputStreamReader(System.in));
				                  fileName = fileNameReader.readLine();

				                  File directory = new File(path);
				                  File[] listOfFiles = directory.listFiles();
				                  for (File file : listOfFiles) {
				                          String name = file.getName();
				                          if (name.equals(fileName)) {
				                                  System.out.println(name +" - File Found");				                                 
				                                  return;
				                          }
				                  }
				                  System.out.println(fileName + " not found in " + path + " directory");
				                  System.out.println("File Not Found");
				          } catch (IOException e) {
				                  e.printStackTrace();
				          }
				}
				
			}
			else if(choice == 3){
				
				 System.out.println("Closing your application... \nThank you!");
            }
				
		
	}

}
