package net.griefergames.customblocks.downloader;

import net.labymod.api.models.version.Version;
import net.labymod.api.util.version.SemanticVersion;
import java.util.HashMap;
import java.util.Map;

public class VersionData {

  public String fileName;
  public String oldFileName;

  public Map<String, String> versions = new HashMap<>();

  public Map<String, String> api = new HashMap<>();

}
