package poo.areopuerto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import poo.areopuerto.FilesUtils.*;
import poo.areopuerto.models.AereopuertoModel;

/* Datos para pruebas
        Aereopuerto AE = new Aereopuerto("Aere", 2, "Ecuador", "Quito", 2, true);
        AereopuertoModel A= new AereopuertoModel();
        Avion A1 = new AvionDeCarga("ABC", "DFG", "HIJG", true, 1234);
        Avion A2 = new AvionPasajeros("ABC", "DFG", "HIJG", true, 1234);
        A.agregar(A1.toString(), "avion.txt");
        A.agregar(A2.toString(), "avion.txt");
        A.agregar(AE.toString(), "aereopuerto.txt");
*/

public class SCRUD {

  public void agregar(String datos, String path){
    try(BufferedWriter br = new BufferedWriter(new FileWriter(path,true))){
        br.write(datos+"\n");
        br.newLine();
        System.out.println("Agregando datos");
    } catch (IOException ex) {
        System.out.println("Error al agregar datos");
        System.getLogger(AereopuertoModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
  }
  public boolean eliminar(int id, String path){
        List<String> lines;
        try {
          lines = FileUtil.readAllLines(path);
          int idx = indexOfId(lines, id);
          if (idx < 0) return false;
          lines.remove(idx);
          FileUtil.overwriteAllLines(path, lines);
          return true;
        } catch (IOException e) {
          e.printStackTrace();
        }
        return false;
  }
  public boolean actualizar(String path, int id, Object obj) throws IOException {
    List<String> lines = FileUtil.readAllLines(path);
    int idx = indexOfId(lines, id);
    if (idx < 0) return false;
    String newLine = obj.toString();
    lines.set(idx, newLine);
    FileUtil.overwriteAllLines(path, lines);
    return true;
  }



  public int indexOfId(List<String> lines, int id) {
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
}
