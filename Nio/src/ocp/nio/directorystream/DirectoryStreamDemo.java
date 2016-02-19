package ocp.nio.directorystream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ocp.nio.PathUtils;

public class DirectoryStreamDemo {

	public static void main(String[] args) {
		PathUtils.initDirWithFiles();
        showFilesInRootDir();
        PathUtils.cleanupInitDirWithFiles();
	}
	
	private static void showFilesInRootDir(){
		Path rootDir = Paths.get("root");
		try(DirectoryStream<Path> rootdirStream = Files.newDirectoryStream(rootDir);)
        {
        	for(Path p:rootdirStream){
        		System.out.println(p.getFileName()+ 
        				(Files.isDirectory(p) ? "\tBeware : We can't see subdir's contents!":"") );
        	}
        } 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}

}
