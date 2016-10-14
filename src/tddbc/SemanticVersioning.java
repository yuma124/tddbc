package tddbc;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 */
public class SemanticVersioning {
    private int major;
    private int minor;
    private int patch;

    public SemanticVersioning () {
    }

    public SemanticVersioning (int major, int minor, int patch) {
        setMajor(major);
        setMinor(minor);
        setPatch(patch);
    }

    public String getVersion() {
        return String.join(".", Arrays.asList(major, minor, patch).stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        if (major < 0) {
            throw new SemanticVersioningException();
        }
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        if (minor < 0) {
            throw new SemanticVersioningException();
        }
        this.minor = minor;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        if (patch < 0) {
            throw new SemanticVersioningException();
        }
        this.patch = patch;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SemanticVersioning)) {
            return false;
        }
        SemanticVersioning semver = (SemanticVersioning)obj;
        return getVersion().equals(semver.getVersion());
    }
}
