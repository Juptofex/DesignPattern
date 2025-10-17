public class Album {
    private final String title;
    private final String artist;
    private final String label;
    private final String producer;
    private final String artist_country;
    private final String version;
    private final String genre;
    private final String release_date;
    private final boolean is_remasterized;
    private final String original_release_date;
    private final String standart_debit;
    private final String sub_debit;

    private Album(AlbumBuilder builder) {
        this.title = builder.title;
        this.artist = builder.artist;
        this.label = builder.label;
        this.producer = builder.producer;
        this.artist_country = builder.artist_country;
        this.version = builder.version;
        this.genre = builder.genre;
        this.release_date = builder.release_date;
        this.is_remasterized = builder.is_remasterized;
        this.original_release_date = builder.original_release_date;
        this.standart_debit = builder.standart_debit;
        this.sub_debit = builder.sub_debit;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLabel() {
        return label;
    }

    public String getProducer() {
        return producer;
    }

    public String getArtist_country() {
        return artist_country;
    }

    public String getVersion() {
        return version;
    }

    public String getGenre() {
        return genre;
    }

    public String getRelease_date() {
        return release_date;
    }

    public boolean isIs_remasterized() {
        return is_remasterized;
    }

    public String getOriginal_release_date() {
        return original_release_date;
    }

    public String getStandart_debit() {
        return standart_debit;
    }

    public String getSub_debit() {
        return sub_debit;
    }

    public static class AlbumBuilder {
        private final String title;
        private final String artist;
        private String label;
        private String producer;
        private String artist_country;
        private String version;
        private String genre;
        private String release_date;
        private boolean is_remasterized;
        private String original_release_date;
        private String standart_debit;
        private String sub_debit;

        public AlbumBuilder(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public AlbumBuilder label(String label) {
            this.label = label;
            return this;
        }

        public AlbumBuilder producer(String producer) {
            this.producer = producer;
            return this;
        }

        public AlbumBuilder artist_country(String artist_country) {
            this.artist_country = artist_country;
            return this;
        }

        public AlbumBuilder version(String version) {
            this.version = version;
            return this;
        }

        public AlbumBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public AlbumBuilder release_date(String release_date) {
            this.release_date = release_date;
            return this;
        }

        public AlbumBuilder is_remasterized(boolean is_remasterized) {
            this.is_remasterized = is_remasterized;
            return this;
        }

        public AlbumBuilder original_release_date(String original_release_date) {
            this.original_release_date = original_release_date;
            return this;
        }

        public AlbumBuilder standart_debit(String standart_debit) {
            this.standart_debit = standart_debit;
            return this;
        }

        public AlbumBuilder sub_debit(String sub_debit) {
            this.sub_debit = sub_debit;
            return this;
        }

        public Album build() {
            return new Album(this);
        }
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", label='" + label + '\'' +
                ", producer='" + producer + '\'' +
                ", artist_country='" + artist_country + '\'' +
                ", version='" + version + '\'' +
                ", genre='" + genre + '\'' +
                ", release_date='" + release_date + '\'' +
                ", is_remasterized=" + is_remasterized +
                ", original_release_date='" + original_release_date + '\'' +
                ", standart_debit='" + standart_debit + '\'' +
                ", sub_debit='" + sub_debit + '\'' +
                '}';
    }
}
