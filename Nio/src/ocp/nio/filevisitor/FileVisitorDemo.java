package ocp.nio.filevisitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import ocp.nio.PathUtils;

public class FileVisitorDemo {

	public static void main(String[] args) {
	  PathUtils.initDirWithFiles();
	  try {
		//Files.walkFileTree(Paths.get("root"), new CustomFileVisitor());
		
		Files.walkFileTree(Paths.get("root"), new CustomFileVisitorSkipFiles());
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	  PathUtils.cleanupInitDirWithFiles();
	}

	static class CustomFileVisitor extends SimpleFileVisitor<Path>{        
		//beware args contains exception !
		@Override
		public FileVisitResult postVisitDirectory(Path arg0, IOException arg1) throws IOException {
			System.out.println("Post-visit dir : " + arg0.getFileName());
			return super.postVisitDirectory(arg0, arg1);
		}

		//beware args contains basicfileattributes !
		@Override
		public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
			System.out.println("Pre-visit dir: " + arg0.getFileName());
			return super.preVisitDirectory(arg0, arg1);
		}

		//beware args contains basicfileattributes !
		@Override
		public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1) throws IOException {
			System.out.println("Visit file : " + arg0.getFileName());
			return super.visitFile(arg0, arg1);
		}			
	}
	
	static class CustomFileVisitorSkipFiles extends SimpleFileVisitor<Path>{      
		@Override
		public FileVisitResult preVisitDirectory(Path arg0, BasicFileAttributes arg1) throws IOException {
			System.out.println("Pre-visit dir: " + arg0.getFileName()+". Skip files within dir..");
			return FileVisitResult.SKIP_SUBTREE;
		}
	}
	
	
}
