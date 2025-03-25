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
    if (photos.empty()) {
        return;
    }
    photos.findFirst();
    if (photos.retrieve().getPath().equals(path)) {
        photos.remove();
        return;
    }
    while (!photos.last()) {
        photos.findNext();
        if (photos.retrieve().getPath().equals(path)) {
            photos.remove();
            return;
        }
    }
}

}
