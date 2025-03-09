
public class Photo {
	String path;

	// Constructor
	public Photo(String path, LinkedList<String> tags) {
		this.path=path;
		
	}
	
	
	// Return the full file name (the path) of the photo. A photo is uniquely identified by its path.
	public String getPath() {
		return path;
	}

	
	// Return all tags associated with the photo
	public LinkedList<String> getTags(){
		
	}
	
	
}
