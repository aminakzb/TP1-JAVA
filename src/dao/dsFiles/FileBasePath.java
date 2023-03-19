package dao.dsFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileBasePath {
    Path FILEBASEFOLDER = Paths.get("FileBase");
    Path CONGESFOLDER = Paths.get(FILEBASEFOLDER.toString(), "congés");

    private static void createFileOrDirectory(Path path, boolean isFile, String header) {

        if (!isFile) {
            if (!path.toFile().exists()) {
                path.toFile().mkdir();
                System.out.println(path.getFileName() + " a été créé avec succès");
            } else
                System.out.println(path.getFileName() + " existe déjà");

        } else {
            if (!path.toFile().exists()) {
                try {
                    path.toFile().createNewFile();
                    Files.writeString(path, header);
                    System.out.println(path.getFileName() + " a été créé avec succès");

                } catch ( IOException e) {
                    e.printStackTrace();
                }
            } else
                System.out.println(path.getFileName() + " existe déjà");

        }

    }

    static void changeFile(Path path, String header) {

        if (path.toFile().exists()) {
            try {
                path.toFile().delete();
                path.toFile().createNewFile();
                Files.writeString(path, header);
                System.out.println(path.getFileName() + " a été changé avec succès");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            System.out.println(path.getFileName() + " n'existe pas");

    }

    static void createFileBase() {

        createFileOrDirectory(FILEBASEFOLDER, false, "NULL");
        createFileOrDirectory(CONGESFOLDER, true, CONGE_TABLE_HEADER);

    }


    String CONGE_TABLE_HEADER = "ID\t\t\tDEMANDEUR\t\t\tNBR JOURS\t\t\tDATE DEBUT\t\t\tDATE FIN\t\t\tTYPE CONGE\n";

    public static void main(String[] args) {
        createFileBase();



    }
}
