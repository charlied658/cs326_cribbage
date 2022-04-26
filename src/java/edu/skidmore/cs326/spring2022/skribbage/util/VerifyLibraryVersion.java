package edu.skidmore.cs326.spring2022.skribbage.util;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

import edu.skidmore.cs326.spring2022.skribbage.SkribbageProperty;
import us.daveread.edu.graphics.surface.MainFrame;

/**
 * Methods for verifying versions of libraries and reporting issues.
 * 
 * @author readda
 */
public class VerifyLibraryVersion {
    /**
     * The logger.
     */
    private static final Logger LOG;

    /**
     * The Singleton instance.
     */
    private static final VerifyLibraryVersion INSTANCE;

    static {
        LOG = Logger.getLogger(VerifyLibraryVersion.class);
        INSTANCE = new VerifyLibraryVersion();
    }

    /**
     * Singleton constructor.
     */
    private VerifyLibraryVersion() {

    }

    /**
     * Get the Singleton instance.
     * 
     * @return The instance
     */
    public static VerifyLibraryVersion getInstance() {
        return INSTANCE;
    }

    /**
     * Check that the correct version of the graphics library is available.
     * Logs a warning if the minimum version is not found. Returns null if the
     * version is at or above the minimum. Otherwise a String is returned
     * containing the found and required version numbers separated by a comma.
     * 
     * @return Null if the version of the library meets the minimum
     *         requirement, otherwise a string containing the find and required
     *         version number, separated by a comma
     */
    public String checkGraphicsLibraryMinVersion() {
        try {
            String minRequiredGuiLibVersion =
                SkribbageProperty.GUI_LIBRARY_MIN_VERSION.getPropertyValue();
            @SuppressWarnings("unchecked")
            Class<MainFrame> mf =
                (Class<MainFrame>) Class
                    .forName("us.daveread.edu.graphics.surface.MainFrame");
            Field version = mf.getDeclaredField("VERSION");
            version.setAccessible(true);

            if (minRequiredGuiLibVersion
                .compareTo((String) version.get(mf)) > 0) {
                LOG.warn(
                    "Outdated version of GUI library on path. Found version "
                        + version.get(mf) + " but need at least version "
                        + minRequiredGuiLibVersion);
                return version.get(mf) + "," + minRequiredGuiLibVersion;
            }
            LOG.debug("Version of GUI library found: " + version.getByte(mf));
        }
        catch (Throwable t) {
            LOG.warn("Unable to verify GUI Library version", t);
        }

        return null;
    }

}
