public class Photo {
	String path;
	LinkedList<String> tags;

	public Photo(String path, LinkedList<String> tags) { 
		this.path = path;
		this.tags = tags;
	}

	public String getPath() {  
		return path;
	}

	public LinkedList<String> getTags() {
		return tags;
	}

	public void displayPhoto() {
		// this method is for testing only !!
		System.out.println("Path: " + path);
		System.out.print("Tags: ");
		tags.display();

	}
}
