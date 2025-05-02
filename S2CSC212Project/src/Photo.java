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

}
