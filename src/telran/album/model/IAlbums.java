package telran.album.model;

import java.time.LocalDate;
import java.util.function.Predicate;

public interface IAlbums {

    boolean addPhoto(Photo photo);

    boolean removePhoto(int photoid, int albumid);

    boolean updatePhoto(int photoid, int albumid, String url);

    Photo getPhotoFromAlbum(int photoid, int albumid);

    Photo getAllPhotoFromAlbum(int albumid);

    Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    /*Photo[] findPhotoByPredicate(Predicate<Photo> predicate);*/
}
