
public class Album {
	String name;
	String condition;
	PhotoManager manager;
	
	

	// Constructor
	public Album(String name, String condition, PhotoManager manager) {
		this.name=name;
		this.condition=condition;
		
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
		return manager;

	}
	
	
	// Return all photos that satisfy the album condition
	public LinkedList<Photo> getPhotos(){
		
	}
	//The list of photos that belong to the album is determined at the time when the method
	//getPhotos in Album is called, not when the album is created.
	
	
	// Return the number of tag comparisons used to find all photos of the album
	//The method public int getNbComps(): Computes the number of tag comparisons
	//made to determine the photos belonging to an album. Its purpose is to track efficiency
	//by counting tag comparisons
	public int getNbComps() {
		return 0; // we need to make it
		
	}
	
}
