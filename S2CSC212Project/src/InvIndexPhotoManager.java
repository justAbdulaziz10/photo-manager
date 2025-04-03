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

	private boolean removePhotoFromList(LinkedList<Photo> list, String path) {
	    // Check if the list is empty; if so, there is nothing to remove.
	    if (list.empty()) {
	        return false;
	    }
	    
	    // Start iterating from the first element in the list.
	    list.findFirst();
	    boolean found = false;
	    
	    // Loop through the list until the end is reached.
	    while (true) {
	        // Retrieve the current photo.
	        Photo current = list.retrieve();
	        
	        // Check if the current photo's path matches the specified path.
	        if (current.getPath().equals(path)) {
	            // Remove the photo from the list.
	            list.remove();
	            found = true;
	            break;  // Exit the loop after removal.
	        }
	        
	        // If this is the last element, exit the loop.
	        if (list.last()) {
	            break;
	        }
	        
	        // Move to the next element in the list.
	        list.findNext();
	    }
	    
	    // Return true if the photo was successfully removed, otherwise false.
	    return found;
	}


	// Delete a photo
	public void deletePhoto(String path) {
		Photo targetPhoto = null;
		allPhotos.findFirst();
		// Traverse the list to find the photo with the matching path.
		do {
		    Photo current = allPhotos.retrieve();
		    if (current.getPath().equals(path)) {
		        targetPhoto = current;
		        break;
		    }
		    allPhotos.findNext();
		} while (!allPhotos.last());

		// Check the last element if not already found.
		if (targetPhoto == null) {
		    Photo current = allPhotos.retrieve();
		    if (current.getPath().equals(path))
		        targetPhoto = current;
		}

		// If the photo is not found, do nothing.
		if (targetPhoto == null)
		    return;

		// Remove the photo from allPhotos.
		// (Assuming remove() deletes the current element in the iteration.)
		allPhotos.remove();

		// Now, update the inverted index for each tag associated with the photo.
		LinkedList<String> tags = targetPhoto.getTags();
		if (!tags.empty()) {
		    tags.findFirst();
		    while (!tags.last()) {
		        String tag = tags.retrieve();
		        if (index.findkey(tag)) {
		            // Retrieve the list of photos associated with the tag.
		            LinkedList<Photo> photoList = index.retrieve();
		            // Remove the photo from this list.
		            if (removePhotoFromList(photoList, path)) {
		                // If the list becomes empty, remove the tag from the index.
		                if (photoList.empty()) {
		                	index.removeKey(tag.hashCode());

		                }
		            }
		        }
		        tags.findNext();
		    }
		    // Process the last tag.
		    String tag = tags.retrieve();
		    if (index.findkey(tag)) {
		        LinkedList<Photo> photoList = index.retrieve();
		        if (removePhotoFromList(photoList, path)) {
		            if (photoList.empty()) {
		            	index.removeKey(tag.hashCode());

		            }
		        }
		    }
		}

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
