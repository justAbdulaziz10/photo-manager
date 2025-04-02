public class InvIndexPhotoManager {

	// 1- Do not build the inverted index at every call of Album.getPhotos(), otherwise it will
	// not improve the performance,
	// The index must be immediately updated after deleting or adding photos.
	// The tags associated with a photo cannot be changed.
	// Deleting photos may cause an existing tag to have an empty list of photos. As a
	// convention, a tag with no associated photos must be deleted from the index.

	// 2-Use a data structure that allows O(log n) in average to search for a tag.

	LinkedList<Photo> allPhotos;
	BST<LinkedList<Photo>> index;

	// Constructor
	public InvIndexPhotoManager() {
		invertedIndex = new BST<>();
		manager = new PhotoManager();
	}

	// Add a photo
	// this method need to be reviewed (findkey & insert)
	public void addPhoto(Photo p) {
		if (PhotoExist(allPhotos, p))
			return;
		allPhotos.insert(p);
		LinkedList<String> tags = p.getTags();
		if (tags.empty())
			return;
		tags.findFirst();
		while (!tags.last()) {
			String currentTag = tags.retrieve();
			boolean found = index.findkey(currentTag);
			if (!found) {
				LinkedList<Photo> currentPhoto = new LinkedList<Photo>();
				currentPhoto.insert(p);
				index.insert(currentTag, currentPhoto);
			} else {
				LinkedList<Photo> currentPhoto = index.retrieve();
				currentPhoto.insert(p);
			}
			tags.findNext();
		}
		// to add the last element:
		String currentTag = tags.retrieve();
		boolean found = index.findkey(currentTag);
		if (!found) {
			LinkedList<Photo> currentPhoto = new LinkedList<Photo>();
			currentPhoto.insert(p);
			index.insert(currentTag, currentPhoto);
		} else {
			LinkedList<Photo> currentPhoto = index.retrieve();
			currentPhoto.insert(p);
		}
	}

	// Delete a photo
	public void deletePhoto(String path) {

	}

	// Return the inverted index of all managed photos public
	public BST<LinkedList<Photo>> getPhotos() {
		return invertedIndex;
	}

	// helping method
	public boolean PhotoExist(LinkedList<Photo> L, Photo p) {
		if (L.empty())
			return false;
		L.findFirst();
		while (!L.last()) {
			if (L.retrieve().path.equals(p.path))
				return true;
			L.findNext();
		}
		if (L.retrieve().path.equals(p.path))
			return true;
		return false;

	}
}
