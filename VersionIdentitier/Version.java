 package VersionIdentitier;

import VersionIdentitier.Enum.Maintenance;

public final class Version {
    public Version(int major, int minor, int maintenance, int build) {
        this.major = major;
        this.minor = minor;
        this.build = build;
        this.maintenance = getMaintenanceByID(maintenance);
        sortData();
    }


    public Version(int major, int minor, int maintenance) {
        this.major = major;
        this.minor = minor;
        this.maintenance = getMaintenanceByID(maintenance);
        sortData();
    }


    public Version(int major, int minor) {
        this.major = major;
        this.minor = minor;
        sortData();
    }


    private void sortData(){
        if(major < 0)
            major = 0;
        if(minor < 0)
            minor = 0;
        if(build < 0)
            build = 0;
        if(maintenance.getVer() < 0)
            maintenance = Maintenance.Alpha;
        else if(maintenance.getVer() > 3)
            maintenance = Maintenance.Release;
    }

    private int major = 1;


    private int minor = 0;


    // 0 - Alpha
    // 1 - Beta
    // 2 - Release Candidate / 발매 후보
    // 3 - Release / 발매
    private Maintenance maintenance = Maintenance.Alpha;


    private int build = 0;


    public int getMajorVersion() {
        return major;
    }


    public int getMinorVersion() {
        return minor;
    }


    public int getBuild() {
        return build;
    }

    public static Maintenance getMaintenanceByID(int maintenance){
        switch (maintenance){
            case 0:
                return Maintenance.Alpha;
            case 1:
                return Maintenance.Beta;
            case 2:
                return Maintenance.Release_Candidate;
            case 3:
                return Maintenance.Release;
        }
        return Maintenance.Alpha;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    // Fixed for more readability.
    // Code edit by - Ranol
    //
    // Check input version is before than this version.
    // If version is same, return false.
    public boolean isVersionAfterThan(Version v){
        if(getMajorVersion() != v.getMajorVersion()) {
            return getMajorVersion() > v.getMajorVersion();
        }
        if(getMinorVersion() != v.getMinorVersion()) {
            return getMinorVersion() > v.getMinorVersion();
        }
        if(getMaintenance().getVer() != v.getMaintenance().getVer()) {
            return getMaintenance().getVer() > v.getMaintenance().getVer();
        }
        return getBuild() > v.getBuild();
    }

    // Fixed for more readability.
    // Code edit by - Ranol
    //
    // Check input version is after than this version.
    // If version is same, return false.
    public boolean isVersionBeforeThan(Version v){
        if(getMajorVersion() != v.getMajorVersion()) {
            return getMajorVersion() < v.getMajorVersion();
        }
        if(getMinorVersion() != v.getMinorVersion()) {
            return getMinorVersion() < v.getMinorVersion();
        }
        if(getMaintenance().getVer() != v.getMaintenance().getVer()) {
            return getMaintenance().getVer() < v.getMaintenance().getVer();
        }
        return getMaintenance().getVer() < v.getMaintenance().getVer();
    }

    // return version as normal version format.
    public String toString(){
        return String.valueOf(getMajorVersion() + "." + getMinorVersion() + "." + getMaintenance().getVer() + "." + getBuild());
    }
}
