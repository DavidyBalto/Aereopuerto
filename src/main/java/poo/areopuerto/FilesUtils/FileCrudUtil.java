package poo.areopuerto.FilesUtils;

import java.io.IOException;
import java.util.List;

public class FileCrudUtil {

    public static int indexOfId(List<String> lines, int id) {
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(";", -1);
            if (parts.length > 0) {
                try {
                    int found = Integer.parseInt(parts[0].trim());
                    if (found == id) return i;
                } catch (NumberFormatException ignored) { }
            }
        }
        return -1;
    }

    public static boolean existsId(String path, int id) throws IOException {
        List<String> lines = FileUtil.readAllLines(path);
        return indexOfId(lines, id) >= 0;
    }

    public static void append(String path, String line) throws IOException {
        FileUtil.appendLine(path, line);
    }

    public static String readAllAsText(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (String l : FileUtil.readAllLines(path)) {
            sb.append(l).append("\n");
        }
        return sb.toString();
    }

    public static boolean replaceLineById(String path, int id, String newLine) throws IOException {
        List<String> lines = FileUtil.readAllLines(path);
        int idx = indexOfId(lines, id);
        if (idx < 0) return false;

        lines.set(idx, newLine);
        FileUtil.overwriteAllLines(path, lines);
        return true;
    }

    public static boolean deleteLineById(String path, int id) throws IOException {
        List<String> lines = FileUtil.readAllLines(path);
        int idx = indexOfId(lines, id);
        if (idx < 0) return false;

        lines.remove(idx);
        FileUtil.overwriteAllLines(path, lines);
        return true;
    }
}
