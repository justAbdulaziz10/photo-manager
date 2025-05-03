public class PhotoManager {
	private LinkedList<Photo> photos;
	private BST<LinkedList<Photo>> invertedIndex; 
	private BST<String> tagNameMap; 
	
    public PhotoManager() {
        photos = new LinkedList<>();
        invertedIndex = new BST<>();
        tagNameMap = new BST<>();
    }
    
    public LinkedList<Photo> getPhotos() {
        return photos;
    }
    
    public void addPhoto(Photo p) {
    	if (photoExists(photos, p)) return;
        photos.insert(p);

        LinkedList<String> tags = p.getTags();
        if (tags.empty()) return;

        tags.findFirst();
        while (true) {
            String tag = tags.retrieve();
            int tagKey = stringToKey(tag);
            tagNameMap.insert(tagKey, tag);

            if (!invertedIndex.findkey(tagKey)) {
                LinkedList<Photo> list = new LinkedList<>();
                list.insert(p);
                invertedIndex.insert(tagKey, list);
            } else {
                invertedIndex.retrieve().insert(p);
            }

            if (tags.last()) break;
            tags.findNext();
        }
    }
    
    public boolean deletePhoto(String path) {
        if (photos.empty()) return false;

        photos.findFirst();
        while (true) {
            if (photos.retrieve().getPath().equals(path)) {
                Photo toDelete = photos.retrieve();
                photos.remove();
                removeFromIndex(toDelete);
                return true;
            }
            if (photos.last()) break;
            photos.findNext();
        }

        return false;
    }
    
    private void removeFromIndex(Photo photo) {
        LinkedList<String> tags = photo.getTags();
        if (tags.empty()) return;

        tags.findFirst();
        while (true) {
            String tag = tags.retrieve();
            int tagKey = stringToKey(tag);

            if (invertedIndex.findkey(tagKey)) {
                LinkedList<Photo> list = invertedIndex.retrieve();
                removePhotoFromList(list, photo.getPath());

                if (list.empty()) {
                    invertedIndex.remove_key(tagKey);
                }
            }

            if (tags.last()) break;
            tags.findNext();
        }
    }
    
    public BST<LinkedList<Photo>> getInvertedIndex() {
        return invertedIndex;
    }
    
    public String getTagName(int key) {
        if (tagNameMap.findkey(key)) {
            return tagNameMap.retrieve();
        }
        return "TAG_" + key;
    }

    private int stringToKey(String tag) {
        int key = 0;
        for (int i = 0; i < tag.length(); i++) {
            key = key * 31 + tag.charAt(i);
        }
        return key;
    }
    
    private boolean removePhotoFromList(LinkedList<Photo> list, String path) {
        if (list.empty()) return false;
        
        list.findFirst();
        boolean found = false;
        
        while (true) {
            Photo current = list.retrieve();
            if (current.getPath().equals(path)) {
                list.remove();
                found = true;
                break;  
            }
            
            if (list.last()) break;
            list.findNext();
        }
        
        return found;
    }

    private boolean photoExists(LinkedList<Photo> list, Photo p) {
        if (list.empty()) return false;
        list.findFirst();
        while (true) {
            if (list.retrieve().getPath().equals(p.getPath())) return true;
            if (list.last()) break;
            list.findNext();
        }
        return false;
    }
    @Override
   public String toString() {
        LinkedList<Photo> photos = getPhotos();
        int count = 0;
        if (!photos.empty()) {
            photos.findFirst();
            while (true) {
                count++;
                if (photos.last()) break;
                photos.findNext();
            }
        }
        return "PhotoManager with " + count + " photos";
    }
    
    public int getPhotosByTagWithCount(String tag, LinkedList<Photo> output) {
        int comparisons = 0;

        int tagKey = stringToKey(tag);
        BSTNode<LinkedList<Photo>> p = invertedIndex.root;
            
            while (p != null) {
                comparisons++;
                if (tagKey == p.key) {
                    LinkedList<Photo> photoList = p.data;
                    photoList.findFirst();
                    while (true) {
                        output.insert(photoList.retrieve());
                        if (photoList.last()) break;
                        photoList.findNext();
                    }
                    break;
                } else if (tagKey < p.key) {
                    p = p.left;  
                } else {
                    p = p.right;   
                }}
        return comparisons;
    }
}
