package net.griefergames.customblocks;

import net.labymod.api.Constants;
import net.labymod.api.Constants.Files;
import net.labymod.api.Laby;
import net.labymod.api.loader.platform.PlatformEnvironment;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GrieferGamesCustomblockConstants {

  public static final String LABY_FABRIC_ADDON_NAME = "labyfabric";

  public static final Path MODS_DIRECTORY_PATH = getWorkingDirectory(PlatformEnvironment.getRunningVersion());

  //Constants.Files.LABYMOD_DIRECTORY.resolve("fabric");
  //public static final String FABRIC_VERSION_PATH = FABRIC_DIRECTORY + "/%s";
  //public static final String MODS_DIRECTORY_PATH = FABRIC_VERSION_PATH + "/mods";

//  public static Path versionedPath(String path) {
//    return versionedPath(path, PlatformEnvironment.getRunningVersion());
//  }
//
//  public static Path versionedPath(String path, String version) {
//    return Paths.get(String.format(path, new Object[] { version }), new String[0]);
//  }

  public static Path getWorkingDirectory(String version) {
    String path = System.getProperty("net.labymod.fabric-dir");
    if (path == null) {
      return Files.LABYMOD_DIRECTORY.resolve("fabric").resolve(version).resolve("mods");
    }
    return Paths.get(path).resolve(version).resolve("mods");
  }

}
