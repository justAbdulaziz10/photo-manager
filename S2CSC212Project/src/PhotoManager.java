public class PhotoManager {
    private LinkedList<Photo> photos;
 // Constructor
    public PhotoManager() {
        photos = new LinkedList<>();
    }
 // Return all managed photos
    public LinkedList<Photo> getPhotos() {
        return photos;
    }
 // Add a photo
    public void addPhoto(Photo p) {
        photos.insert(p);
    }
 // Delete a photo
    public void deletePhoto(String path) {
        Node<Photo> current = photos.getHead();
        Node<Photo> previous = null;
        while (current != null) {
            if (current.getData().getPath().equals(path)) {
                if (previous == null) {
                    photos.setHead(current.getNext());
                } else {
                    previous.setNext(current.getNext());
                }
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }
}
