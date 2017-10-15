package VersionIdentitier;

import VersionIdentitier.Enum.Maintenance;

public class Version {
    public Version(int major, int minor, int maintenance, int build) {
        this.major = major;
        this.minor = minor;
        this.maintenance = maintenance;
        this.build = build;
        sortData();
    }


    public Version(int major, int minor, int maintenance) {
        this.major = major;
        this.minor = minor;
        this.maintenance = maintenance;
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
        if(maintenance < 0)
            maintenance = 0;
        else if(maintenance > 3)
            maintenance = 3;
    }

    private int major = 1;


    private int minor = 0;


    // 0 - Alpha
    // 1 - Beta
    // 2 - Release Candidate / 발매 후보
    // 3 - Release / 발매
    private int maintenance = 0;


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

    public Maintenance getMaintenance(){
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
        return null;
    }

    // Check input version is before than this version.
    // If version is same, return false.
    public boolean isVersionAfterThan(Version v){
        if(getMajorVersion() > v.getMajorVersion())
            return true;
        else if(getMajorVersion() >= v.getMajorVersion()){
            if(getMinorVersion() > v.getMinorVersion())
                return true;
            else if(getMinorVersion() >= v.getMinorVersion()){
                if(getMaintenance().getVer() > v.getMaintenance().getVer())
                    return true;
                else if(getMaintenance().getVer() >= v.getMaintenance().getVer()){
                    return getBuild() > v.getBuild();
                }else
                    return false;
            }else
                return false;
        }else
            return false;
    }


    // Check input version is after than this version.
    // If version is same, return false.
    public boolean isVersionBeforeThan(Version v){
        if(getMajorVersion() < v.getMajorVersion())
            return true;
        else if(getMajorVersion() <= v.getMajorVersion()){
            if(getMinorVersion() < v.getMinorVersion())
                return true;
            else if(getMinorVersion() <= v.getMinorVersion()){
                if(getMaintenance().getVer() < v.getMaintenance().getVer())
                    return true;
                else if(getMaintenance().getVer() <= v.getMaintenance().getVer()){
                    return getBuild() < v.getBuild();
                }else
                    return false;
            }else
                return false;
        }else
            return false;

    }
}
