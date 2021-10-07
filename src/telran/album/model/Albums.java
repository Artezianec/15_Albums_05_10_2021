package telran.album.model;

import java.time.LocalDate;

public class Albums implements IAlbums {
    private Photo[] photos;
    private int size;

    public Albums(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo == null || size == photos.length) {
            return false;
        }
        photos[size++] = photo;
        return true;
    }

    @Override
    public boolean removePhoto(int photoid, int albumid) {
        for (int i = 0; i < size; i++) {
            if (photoid == photos[i].getPhotoid() && albumid == photos[i].getAlbumid()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoid, int albumid, String url) {
        for (int i = 0; i < size; i++) {
            if (photoid == photos[i].getPhotoid() && albumid == photos[i].getAlbumid()) {
                System.out.println(photos[i]);
                photos[i].setUrl(url);
                System.out.println(photos[i]);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoid, int albumid) {
        for (int i = 0; i < size; i++) {
            if (photoid == photos[i].getPhotoid() && albumid == photos[i].getAlbumid()) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo getAllPhotoFromAlbum(int albumid) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getAlbumid() == albumid) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return new Photo[0];
    }

 /*    public Photo find (int v1, int v2) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoid() == v1 && photos[i].getAlbumid() == v2) {
                return photos[i];
            }
        }
        return null;
    }

   public Photo[] findPhotoByPredicate(Predicate<Photo> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                count++;
            }
        }
        Photo[] res = new Photo[count];
        for (int i = 0, j = 0; i < res.length; i++) {
            if (predicate.test(photos[i])) {
                res[j++] = photos[i];
            }
        }
        return res;
    }*/
}
