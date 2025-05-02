public class Test {
	public static void main(String[] args) {
		PhotoManager manager = new PhotoManager();
		Photo photo1 = new Photo("hedgehog.jpg",toTagsLinkedList("animal, hedgehog, apple, grass, green"));
		manager.addPhoto(photo1);
		Photo photo2 = new Photo("bear.jpg",toTagsLinkedList("animal, bear, cab, grass,wind"));
		manager.addPhoto(photo2);
		Photo photo3 = new Photo("orange-butterfly.jpg",toTagsLinkedList("insect,butterfly, flower, color"));
		manager.addPhoto(photo3);
		Photo photo4 = new Photo("black-butterfly.jpg",toTagsLinkedList("insect,butterfly, flower, black"));
		manager.addPhoto(photo4);
		Photo photo5 = new Photo("raccoon.jpg",toTagsLinkedList("animal,raccon, log, snow"));
		manager.addPhoto(photo5);
		Photo photo6 = new Photo("wolf.jpg",toTagsLinkedList("animal,wolf, mountain, sky, snow, cloud"));
		manager.addPhoto(photo6);
		Photo photo7 = new Photo("panda.jpg",toTagsLinkedList("animal,bear, panda, grass"));
		manager.addPhoto(photo7);
		Photo photo8 = new Photo("fox.jpg",toTagsLinkedList("animal,fox, tree, forest, grass"));
		manager.addPhoto(photo8);
		Photo photo9 = new Photo(" ",toTagsLinkedList(" "));
		manager.addPhoto(photo9);
		
		System.out.println("we have added photos");
		System.out.println();

		
		Album normalAlbum1 = new Album("Album1", "bear", manager, false);
		Album normalAlbum2 = new Album("Album2", "animal AND grass", manager,false);
		Album normalAlbum3 = new Album("Album3", "", manager,false);
		
		System.out.println("we have created linkedlist Albums");

		
		Album invertedAlbum4 = new Album("Album4", "bear", manager,true);
		Album invertedAlbum5 = new Album("Album5", "animal AND grass", manager,true);
		Album invertedAlbum6 = new Album("Album6", "", manager,true);
		
		System.out.println("we have created invertedBST Albums");
		System.out.println();

		System.out.println("--------------------------------------------------------------------------");
		System.out.println("now let's get all photos paths and tags: ");
		System.out.println();
   
		System.out.println("Get photo1 path and tags:");
		System.out.println("photo1 path: " + photo1.getPath());
		System.out.println("photo1 tags: "+ photo1.getTags());
		System.out.println();
		
		System.out.println("Get photo2 path and tags:");
		System.out.println("photo2 path: " + photo2.getPath());
		System.out.println("photo2 tags: "+ photo2.getTags());
		System.out.println();
		
		System.out.println("Get photo3 path and tags:");
		System.out.println("photo3 path: " + photo3.getPath());
		System.out.println("photo3 tags: "+ photo3.getTags());
		System.out.println();
		
		System.out.println("Get photo4 path and tags:");
		System.out.println("photo4 path: " + photo4.getPath());
		System.out.println("photo4 tags: "+ photo4.getTags());
		System.out.println();
		
		System.out.println("Get photo5 path and tags:");
		System.out.println("photo5 path: " + photo5.getPath());
		System.out.println("photo5 tags: "+ photo5.getTags());
		System.out.println();
		
		System.out.println("Get photo6 path and tags:");
		System.out.println("photo6 path: " + photo6.getPath());
		System.out.println("photo6 tags: "+ photo6.getTags());
		System.out.println();
		
		System.out.println("Get photo7 path and tags:");
		System.out.println("photo7 path: " + photo7.getPath());
		System.out.println("photo7 tags: "+ photo7.getTags());
		System.out.println();
		
		System.out.println("Get photo8 path and tags:");
		System.out.println("photo8 path: " + photo8.getPath());
		System.out.println("photo8 tags: "+ photo8.getTags());
		System.out.println();
		
		System.out.println("Get photo9 path and tags:");
		System.out.println("photo9 path: " + photo9.getPath());
		System.out.println("photo9 tags: "+ photo9.getTags());
		System.out.println();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		
        System.out.println("now let's get linkedlests Albums name, conditions and photos:");
		System.out.println();

		normalAlbum1.getPhotos();
		System.out.println("Get album1 name, condition, and photos:");
		System.out.println("album1 name: " + normalAlbum1.getName());
		System.out.println("album1 condition: " + normalAlbum1.getCondition());
		System.out.println("album1 manager: " + normalAlbum1.getManager());

		
		normalAlbum1.getPhotos();
		System.out.println();
		
		System.out.println("Get album2 name, condition, and photos:");
		System.out.println("album2 name: " + normalAlbum2.getName());
		System.out.println("album2 condition: " +normalAlbum2.getCondition());
		System.out.println("album2 manager: " + normalAlbum2.getManager());

		normalAlbum2.getPhotos();
		System.out.println();
		
		System.out.println("Get album3 name, condition, and photos:");
		System.out.println("album3 name: " + normalAlbum3.getName());
		System.out.println("album3 condition: " +normalAlbum3.getCondition());
		System.out.println("album3 manager: " + normalAlbum3.getManager());

		normalAlbum3.getPhotos();
		System.out.println();
		
		System.out.println("--------------------------------------------------------------------------");
	
        System.out.println("now let's get invertedBST Albums name, conditions and photos:");
		System.out.println();
		
		System.out.println("Get album4 name, condition, and photos:");
		System.out.println("album4 name: " + invertedAlbum4.getName());
		System.out.println("album4 condition: " + invertedAlbum4.getCondition());
		System.out.println("album4 manager: " + invertedAlbum4.getManager());
		
		invertedAlbum4.getPhotos();
		System.out.println();
		
		System.out.println("Get album5 name, condition, and photos:");
		System.out.println("album5 name: " + invertedAlbum5.getName());
		System.out.println("album5 condition: " + invertedAlbum5.getCondition());
		System.out.println("album5 manager: " + invertedAlbum5.getManager());

		invertedAlbum5.getPhotos();
		System.out.println();
		
		System.out.println("Get album6 name, condition, and photos:");
		System.out.println("album6 name: " + invertedAlbum6.getName());
		System.out.println("album6 condition: " + invertedAlbum6.getCondition());
		System.out.println("album6 manager: " + invertedAlbum6.getManager());

		invertedAlbum6.getPhotos();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		
		System.out.println("normal LinkedList Content:");
		printNormalList(manager);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		
		
		
		System.out.println("InvertedIndexBST Content:");
		printInvertedIndex(manager.getInvertedIndex(),manager);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		normalAlbum1.getPhotos();
		System.out.println("Comparisons (normal): " + normalAlbum1.getNbComps());
		invertedAlbum4.getPhotos();
		System.out.println("Comparisons (invertedBST): " + invertedAlbum4.getNbComps());
		System.out.println();
		
		long total = 0;
		for (int i = 0; i < 100; i++) {
		    long s = System.nanoTime();
		    normalAlbum2.getPhotos();
		    long e = System.nanoTime();
		    total += (e - s);
		}
		System.out.println("Average time(normal): " + (total / 100) + " ns");


		total = 0;
		for (int i = 0; i < 100; i++) {
		    long s = System.nanoTime();
		    invertedAlbum5.getPhotos();
		    long e = System.nanoTime();
		    total += (e - s);
		}
		System.out.println("Average time(invertedBST): " + (total / 100) + " ns");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		
		System.out.println("Delete the photo 'bear.jpg':");
		if (manager.deletePhoto("bear.jpg")) {
		    System.out.println("bear.jpg deleted successfully from normal manager.");
			System.out.println("Photos after deletion (normal manager):");
			printAllPhotos(manager);
			System.out.println();
		} else {
		    System.out.println("bear.jpg not found in normal manager.");
			System.out.println();

		}
		System.out.println("--------------------------------------------------------------------------");

		
		System.out.println("Delete the photo 'cat.jpg':");
		if (manager.deletePhoto("cat.jpg")) {
		    System.out.println("cat.jpg deleted successfully from normal manager.");
			System.out.println("Photos after deletion (normal manager):");
			printAllPhotos(manager);
			System.out.println();
		} else {
		    System.out.println("cat.jpg not found in normal manager.");
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------");



		System.out.println("Delete the photo 'fox.jpg':");
		if (manager.deletePhoto("fox.jpg")) {
		    System.out.println("fox.jpg deleted successfully from inverted index.");
			System.out.println("Inverted Index after deletion:");

			printInvertedIndex(manager.getInvertedIndex(),manager);
			System.out.println();
		} else {
		    System.out.println("fox.jpg not found in inverted index.");
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------");

		
		System.out.println("Delete the photo 'bird.jpg':");
		if (manager.deletePhoto("bird.jpg")) {
		    System.out.println("bird.jpg deleted successfully from inverted index.");
			System.out.println("Inverted Index after deletion:");
			printInvertedIndex(manager.getInvertedIndex(),manager);
			System.out.println();
		} else {
		    System.out.println("bird.jpg not found in inverted index.");
			System.out.println();

		}
		System.out.println("--------------------------------------------------------------------------");

		
		System.out.println("Photos after deletion (normal manager):");
		printNormalList(manager);
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");

		
		normalAlbum1.getPhotos();
		System.out.println("Comparisons (normal): " + normalAlbum1.getNbComps());
		invertedAlbum4.getPhotos();
		System.out.println("Comparisons (invertedBST): " + invertedAlbum4.getNbComps());
		System.out.println();
		
		total = 0;
		for (int i = 0; i < 100; i++) {
		    long s = System.nanoTime();
		    normalAlbum2.getPhotos();
		    long e = System.nanoTime();
		    total += (e - s);
		}
		System.out.println("Average time(normal): " + (total / 100) + " ns");




		total = 0;
		for (int i = 0; i < 100; i++) {
		    long s = System.nanoTime();
		    invertedAlbum5.getPhotos();
		    long e = System.nanoTime();
		    total += (e - s);
		}
		System.out.println("Average time(ivertedBST): " + (total / 100) + " ns");
		System.out.println();
		
		}
	
	
	public static void printAllPhotos(PhotoManager manager) {
	    LinkedList<Photo> photos = manager.getPhotos();
	    
	    if (photos.empty()) {
	        System.out.println("No photos in manager.");
			System.out.println();
	        return;
	    }
	    
	    photos.findFirst();
	    while (true) {
	        Photo p = photos.retrieve();
	        System.out.println(p.getPath());
	        if (photos.last()) break;
	        photos.findNext();
	    }
	}
	
	public static void printInvertedIndex(BST<LinkedList<Photo>> index, PhotoManager manager) {
	    if (index.empty()) {
	        System.out.println("Inverted index is empty.");
	        return;
	    }

	    printBST(index.root, manager);
	}

	private static void printBST(BSTNode<LinkedList<Photo>> node, PhotoManager manager) {
	    if (node == null)
	        return;

	    printBST(node.left, manager);

	    int tagKey = node.key;
	    String tagName = manager.getTagName(tagKey); 
	    System.out.print(tagName + " -> ");

	    LinkedList<Photo> photos = node.data;
	    if (photos.empty()) {
	        System.out.println("[empty]");
	    } else {
	        photos.findFirst();
	        while (true) {
	            System.out.print(photos.retrieve().getPath());
	            if (photos.last()) break;
	            System.out.print(", ");
	            photos.findNext();
	        }
	        System.out.println();
	    }

	    printBST(node.right, manager);
	}
	
	public static void printNormalList(PhotoManager manager) {
	    LinkedList<Photo> photos = manager.getPhotos();
	    
	    if (photos.empty()) {
	        System.out.println("Photo list is empty.");
	        return;
	    }

	    photos.findFirst();
	    while (true) {
	        System.out.println(photos.retrieve().getPath());
	        if (photos.last()) break;
	        photos.findNext();
	    }
	}
	
	private static LinkedList<String> toTagsLinkedList(String tags) {
		LinkedList<String> result = new LinkedList<String>();
		String[] tagsArray = tags.split("\\s*,\\s*");
		for (int i = 0; i < tagsArray.length; i++) {
			result.insert(tagsArray[i]);
			}
		return result;
		}
	}
