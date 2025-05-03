 public class Album {
	String name;
	String condition;
	PhotoManager manager;
	boolean useInverted;
	private int tagComparisons = 0;
	private int myBstComparisons = 0;
	private int myTagComparisons = 0;

	public Album(String name, String condition, PhotoManager manager, boolean useInverted) {
		this.name=name;
		this.condition=condition;
		this.manager=manager;
		this.useInverted = useInverted;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCondition() {
		return condition;
	}
	
	
	public PhotoManager getManager() {
		return manager;

	}
	
	public LinkedList<Photo> getPhotos() {
	    tagComparisons = 0;
	    if (useInverted) 
	    	BST.bstComparisons = 0;

	    if (manager == null) return new LinkedList<>();
	    if (condition == null || condition.isEmpty()) return manager.getPhotos();

	    String[] tags = condition.split("AND");
	    for (int i = 0; i < tags.length; i++) 
	    	tags[i] = tags[i].trim();

	    LinkedList<Photo> result;

	    if (useInverted) {
	        result = new LinkedList<>();
	        myBstComparisons = 0;
	        
	        myBstComparisons += manager.getPhotosByTagWithCount(tags[0], result);

	        for (int i = 1; i < tags.length; i++) {
	            LinkedList<Photo> next = new LinkedList<>();
	            myBstComparisons += manager.getPhotosByTagWithCount(tags[i], next);
	            result = AND(result, next);
	        }
	    } else {
	        result = getTagPhoto(tags[0]);
	        for (int i = 1; i < tags.length; i++) {
	            LinkedList<Photo> next = getTagPhoto(tags[i]);
	            result = AND(result, next);
	        }
	        myTagComparisons = tagComparisons;
	    }

	    return result;
	}

	private LinkedList<Photo> getTagPhoto(String tag){
	    LinkedList<Photo> result = new LinkedList<>();
	    
	    if (tag == null || manager == null) return result;

	    LinkedList<Photo> allPhotos = manager.getPhotos();
	    if (allPhotos == null || allPhotos.empty()) return result;

	    allPhotos.findFirst();
	    while (true) {
	        Photo p = allPhotos.retrieve();
	        LinkedList<String> tags = p.getTags();

	        if (tagInPhoto(tag, tags)) {
	            result.insert(p);
	        }

	        if (allPhotos.last()) break;
	        allPhotos.findNext();
	    }

	    return result;
	}
	

	public boolean tagInPhoto(String tagToFind, LinkedList<String> tagList) {
	    if(tagToFind == null || tagList == null) {
	        return false;
	    }

	    tagList.findFirst();
	    while (true) {
	        tagComparisons++;    
	        if (tagToFind.equals(tagList.retrieve())) {
	            return true;
	        }
	        if (tagList.last()) {
	            break;
	        }
	        tagList.findNext();
	    }

	    return false;
	}

	
	public boolean photoExist(LinkedList<Photo> L, Photo P) {
	    if (L == null || P == null) return false;

	    String pathToFind = P.getPath();
	    L.findFirst();
	    while (true) {
	        Photo currentPhoto = L.retrieve();
	        if (currentPhoto != null && pathToFind.equals(currentPhoto.getPath())) {
	            return true;
	        }

	        if (L.last()) break;
	        L.findNext();
	    }

	    return false;
	}
	
	
   public LinkedList<Photo> AND(LinkedList<Photo> A, LinkedList<Photo> B){
		LinkedList<Photo> results = new LinkedList<>();
	    
	    if (A == null || A.empty()) {
	        if (B != null && !B.empty()) {
	            B.findFirst();
	            while (true) {
	                results.insert(B.retrieve());
	                if (B.last()) {
	                    break;
	                }
	                B.findNext();
	            }
	            return results;
	        } else {
	            return results;
	        }
	    } else if (B == null || B.empty()) {
	        A.findFirst();
	        while (true) {
	            results.insert(A.retrieve());
	            if (A.last()) {
	                break;
	            }
	            A.findNext();
	        }
	        return results;
	    }
	    
	    A.findFirst();
	    while (true) {
	        Photo photoA = A.retrieve();
	        
	        if (photoExist(B, photoA)) {
	            results.insert(photoA);
	        }
	        
	        if (A.last()) {
	            break;
	        }
	        A.findNext();
	    }
	    
	    return results;
	}
	
   public int getNbComps() {
	    if (useInverted) {
	        return myBstComparisons;
	    } else {
	        return myTagComparisons;
	    }
	}
	
}
