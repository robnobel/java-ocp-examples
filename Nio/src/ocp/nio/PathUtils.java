package ocp.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

	 static Path root = Paths.get("root"); 
	 static Path subdir = Paths.get("root/subdir");
	 static Path file1 = Paths.get("root/file1.txt");
	 static Path file2 = Paths.get("root/file2.txt");
	 static Path file3 = Paths.get("root/subdir/file3.txt");
	 static Path file4 = Paths.get("root/subdir/file4.txt");
	
	 public static void initDirWithFiles(){		
		 
		 try 
		 {
			Files.createDirectory(root);
			Files.createDirectory(subdir);
			Files.createFile(file1);
			Files.createFile(file2);
			Files.createFile(file3);
			Files.createFile(file4);
		 } 
		 catch (IOException e) 
		 {
			e.printStackTrace();
		 }
	 }
	 
	 public static void cleanupInitDirWithFiles(){
		try {
			removeDirInclContents(root);
			Files.delete(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 private static void removeDirInclContents(Path path){
		
		 try(DirectoryStream<Path> rootStream = Files.newDirectoryStream(path);){
			 for(Path p:rootStream){
				 if(Files.isDirectory(p)){
					 removeDirInclContents(p);
				 }
			     Files.delete(p); 
			 }			 
		 } catch (IOException e) {
			e.printStackTrace();
		 }
		 
	 }
	 
	
}
