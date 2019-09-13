import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

    Directory root;

    public FileSystem() {
        root = new Directory();
    }

    public List<String> ls(String path) {
        if (path == null || path.isEmpty()) {
            return new ArrayList<>();
        }

        String[] paths = path.split("/");
        Directory currDir = root;
        int i=0;
        for(i=0; i<paths.length-1; i++) {
            currDir = currDir.dirs.get(paths[i]);
        }
        if(i < paths.length && currDir.files.containsKey(paths[i])) {
            return Arrays.asList(paths[i]);
        }
        List<String> list = new ArrayList<>();
        list.addAll(currDir.dirs.keySet());
        list.addAll(currDir.files.keySet());
        Collections.sort(list);
        return list;
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        Directory currDir = root;
        for(int i=0; i<paths.length; i++) {
            if(!currDir.dirs.containsKey(paths[i])) {
                currDir.dirs.put(paths[i], new Directory());
            }
            currDir = currDir.dirs.get(paths[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        Directory currDir = root;
        int i=0;
        for(i=0; i<paths.length-1; i++) {
            currDir = currDir.dirs.get(paths[i]);
        }
        if (!currDir.files.containsKey(paths[i])) {
            currDir.files.put(paths[i], "");
        }
        currDir.files.put(paths[i], currDir.files.get(paths[i])+content);
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        Directory currDir = root;
        int i=0;
        for(i=0; i<paths.length-1; i++) {
            currDir = currDir.dirs.get(paths[i]);
        }
        return currDir.files.get(paths[i]);
    }

}

class Directory {
    Map<String, Directory> dirs;
    Map<String, String> files;

    Directory() {
        dirs = new HashMap<>();
        files = new HashMap<>();
    }
}
