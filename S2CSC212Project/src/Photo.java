public class Photo {
	String path;
	LinkedList<String> tags;

	private Photo(String path, LinkedList<String> tags) {
		this.path = path;
		this.tags = tags;
	}

	private String getPath() {
		return path;
	}

	private LinkedList<String> getTags() {
		return tags;
	}

	private void displayPhoto() {
		// this method is for testing only !!
		System.out.println("Path: " + path);
		System.out.print("Tags: ");
		tags.display();

	}
}
