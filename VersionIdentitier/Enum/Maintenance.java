package VersionIdentitier.Enum;

public enum Maintenance {
    Alpha(0), Beta(1), Release_Candidate(2), Release(3);


    Maintenance(int ver) {
        this.ver = ver;
    }


    private int ver;


    public int getVer() {
        return ver;
    }
}
