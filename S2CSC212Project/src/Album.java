 public class Album {
	String name;
	String condition;
	PhotoManager manager;
	private int tagComparisons = 0;

	
	

	// Constructor
	public Album(String name, String condition, PhotoManager manager) {
		this.name=name;
		this.condition=condition;
		this.manager=manager;
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
		
	    if (condition == null || condition.isEmpty() || manager == null) {
	        return new LinkedList<>();
	    }
	    
	    if (condition.contains("AND")) {
	        String[] conditions = condition.split("AND");
	        for (int i = 0; i < conditions.length; i++) {
	            conditions[i] = conditions[i].trim();
	        }
	        
	        LinkedList<Photo> matchingPhotos = getTagPhoto(conditions[0]);
	        
	        for (int i = 1; i < conditions.length; i++) {
	            LinkedList<Photo> nextConditionPhotos = getTagPhoto(conditions[i]);
	            matchingPhotos = AND(matchingPhotos, nextConditionPhotos);
	        }
	        
	        return matchingPhotos;
	    } else {
	        return getTagPhoto(condition);
	    }
	}

	
	public boolean tagInPhoto(String tagToFind, LinkedList<String> tagList) {
		if(tagToFind == null || tagList==null) {
			return false;
		}
		
		tagList.findFirst();
		while(true) {
			tagComparisons++;
			if(tagToFind.equals(tagList.retrieve())) {
				return true;
			}
			
			if(tagList.last()) {
				break;
			}
			
			tagList.findNext();
		}
		
		return false;
		
	}
	
	public boolean photoExist(LinkedList<Photo> L, Photo P) {
		
		if (L == null || P == null) {
	        return false;
	    }
	    
	    String pathToFind = P.getPath();
	    
	    L.findFirst();
	    while (true) {
	    	Photo currentPhoto = L.retrieve();
	        
	        if (currentPhoto != null && pathToFind.equals(currentPhoto.getPath())) {
	            return true;
	        }
	       
	        if (L.last()) {
	            break;
	        }
	        
	        L.findNext();
	    }
	    
	    return false;
		
	}
	
	LinkedList<Photo> getTagPhoto(String tag){
		LinkedList<Photo> result = new LinkedList<Photo>();
	    
	    if (tag == null || this.getManager() == null) {
	        return result;
	    }
	    
	    LinkedList<Photo> allPhotos = this.getManager().getPhotos();
	    
	    if (allPhotos == null || allPhotos.empty()) {
	        return result;
	    }
	    
	    allPhotos.findFirst();
	    while (true) {
	        Photo currentPhoto = allPhotos.retrieve();
	        
	        if (currentPhoto != null) {
	            LinkedList<String> photoTags = currentPhoto.getTags();
	            
	            if (photoTags != null && !photoTags.empty()) {
	                if (tagInPhoto(tag, photoTags)) {
	                    result.insert(currentPhoto);
	                }
	            }
	        }
	        
	        if (allPhotos.last()) {
	            break;
	        }
	        
	        allPhotos.findNext();
	    }
	    
	    return result;
		
	}
	
	LinkedList<Photo> AND(LinkedList<Photo> A, LinkedList<Photo> B){
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
		tagComparisons = 0;
	    getPhotos();  
	    return tagComparisons;
	}

	
}
