public class InvIndexPhotoManager {
	
	//1- Do not build the inverted index at every call of Album.getPhotos(), otherwise it will
	//not improve the performance,
	//The index must be immediately updated after deleting or adding photos.
	//The tags associated with a photo cannot be changed.
	//Deleting photos may cause an existing tag to have an empty list of photos. As a
	//convention, a tag with no associated photos must be deleted from the index.
	
	//2-Use a data structure that allows O(log n) in average to search for a tag.

	// Constructor
	public void Photomanager() {// it's not 'VOID' but i want the error to go

	}
	
	
	// Add a photo
	public void addPhoto(Photo p) {
		
	}
	
	
	// Delete a photo
	public void deletePhoto(String path) {
		
	}
	
	
	// Return the inverted index of all managed photos
	public BST<LinkedList<Photo>> getPhotos(){
		return null; //we need to make it
		
	}
	
	
	}
