package poo.areopuerto.FilesUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void ensureParentAndFile(String path) throws IOException {
        File f = new File(path);
        File parent = f.getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                throw new IOException("No se pudo crear la carpeta: " + parent.getAbsolutePath());
            }
        }
        if (!f.exists()) {
            try (FileWriter fw = new FileWriter(f, true)) { }
        }
    }

    public static List<String> readAllLines(String path) throws IOException {
        ensureParentAndFile(path);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) lines.add(line);
            }
        }
        return lines;
    }

    public static void appendLine(String path, String line) throws IOException {
        ensureParentAndFile(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(line);
            bw.newLine();
        }
    }

    public static void overwriteAllLines(String path, List<String> lines) throws IOException {
        ensureParentAndFile(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        }
    }
}
