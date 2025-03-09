
public class Album {
	String name;
	String condition;
	
	

	// Constructor
	//The photo manager organizes the photos into albums created by the user
	public Album(String name, String condition, PhotoManager manager) {
		this.name=name; //An album is identifiedby a unique name
		//regroups photos that satisfy certain conditions. The conditions used to
                //create albums consist in a sequence of tags separated by ”AND”:
		this.condition=condition;
		//An empty condition matches all photos.
	}
	
	
	// Return the name of the album
	public String getName() {
		return name;
	}
	
	// Return the condition associated with the album
	public String getCondition() {
		return condition;
	}
	
	
	// Return the manager
	public PhotoManager getManager() {

	}
	
	
	// Return all photos that satisfy the album condition
	public LinkedList<Photo> getPhotos(){
		
	}
	
	
	// Return the number of tag comparisons used to find all photos of the album
	public int getNbComps() {
		
	}
	
}
