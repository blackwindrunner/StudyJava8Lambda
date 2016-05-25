package chapter7;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import chapter1.Album;
import chapter1.Artist;
import chapter1.SampleData;

public class Debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nationalityReportUsingPeek(SampleData.sampleShortAlbum);
	}
	//使用peek来控制流中间的步骤
	public static Set<String> imperativeNationalityReport(Album album) {
        // BEGIN imperative_nationality_report
		Set<String> nationalities = new HashSet<>();
		for (Artist artist : album.getMusicianList()) {
			if (artist.getName().startsWith("The")) {
				String nationality = artist.getNationality();
				System.out.println("Found nationality: " + nationality);
				nationalities.add(nationality);
			}
		}
		return nationalities;
        // END imperative_nationality_report
    }

    public static Set<String> forEachLoggingFailure(Album album) {
        // BEGIN foreach_logging_nationality_report
    	album.getMusicians()
    	.filter(artist -> artist.getName().startsWith("The"))
    	.map(artist -> artist.getNationality())
    	.forEach(nationality -> System.out.println("Found: " + nationality));

    	Set<String> nationalities
    	= album.getMusicians()
           .filter(artist -> artist.getName().startsWith("The"))
           .map(artist -> artist.getNationality())
           .collect(Collectors.<String>toSet());
        // END foreach_logging_nationality_report
        return nationalities;
    }

    public static Set<String> nationalityReportUsingPeek(Album album) {
        // BEGIN peek_nationality_report
    	Set<String> nationalities
    	= album.getMusicians()
           .filter(artist -> artist.getName().startsWith("J"))
           .map(artist -> artist.getNationality())
           .peek(nation -> System.out.println("Found nationality: " + nation))
           .collect(Collectors.<String>toSet());
        // END peek_nationality_report
        return nationalities;
    }
}
