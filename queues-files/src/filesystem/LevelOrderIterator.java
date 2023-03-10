package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;

import structures.Queue;
import support.filesystem.FileIterator;

/**
 * An iterator to perform a level order traversal of part of a 
 * filesystem.
 */
public class LevelOrderIterator extends FileIterator<File> {
	
	public Queue<File> q;

	/**
	 * Instantiate a new LevelOrderIterator, rooted at the rootNode.
	 * @param rootNode
	 * @throws FileNotFoundException if the rootNode does not exist
	 */
	public LevelOrderIterator(File rootNode) throws FileNotFoundException {
        	// TODO 1
		if (!rootNode.exists()){
			throw new FileNotFoundException();
		}
		q = new Queue<File>();
		q.enqueue(rootNode);
	}
	
	//@Override
	public boolean hasNext() {
        	// TODO 2
            return !q.isEmpty();
	}

	//@Override
	public File next() throws NoSuchElementException {
        	// TODO 3
		if (q.isEmpty()){
			throw new NoSuchElementException();
		}
		File f = q.dequeue();
		if (f.isDirectory()) {
			File[] children = f.listFiles();
			Arrays.sort(children);
			for (File child : children){
				q.enqueue(child);
		}	
		}
		return f;
	}

	//@Override
	public void remove() {
		// Leave this one alone.
		throw new UnsupportedOperationException();		
	}

}
