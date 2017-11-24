package br.com.fabricadeprogramador.helper;



import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {


    public static void removeFolder(File f) {
        // Se o arquivo passado for um diretório
        if (f.isDirectory()) {
            f.delete();
        }
    }

    public static void removeFiles(File f) {
        // Se o arquivo passado for um diretório
        if (f.isDirectory()) {
                /* Lista todos os arquivos do diretório em um array
                   de objetos File */
            File[] files = f.listFiles();
            // Identa a lista (foreach) e deleta um por um
            for (File file : files) {
                file.delete();
            }
        }
    }

    /**
     *
     * @param file Arquivo do tipo MultipartFile
     * @param folderRoot pasta raiz ex: grupo, usuario, evento
     * @param folderId id do objeto persistido que é a pasta onde os arquivos ficam salvos
     * @param fileName
     */
    public static  void uploadImage(MultipartFile file, String folderRoot, String folderId, String fileName) {
        if (file !=null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                //creating a folder
                File pastaCriar = new File(folderRoot+ "/" + folderId);
                pastaCriar.mkdir();
                //Remove the files from de folder if it already exists so as not to accumulate
                removeFiles(pastaCriar);
                //Defining a filename
                Path pathFile = Paths.get(fileName);

               //Saving the file
                BufferedOutputStream stream =
                        new BufferedOutputStream(Files.newOutputStream(pathFile));

                stream.write(bytes);
                stream.close();

            } catch (Exception e) {

                throw new RuntimeException("The API can't save the image", e);

            }
        }
    }


    public static void downloadImage(String folderRoot,  String image, HttpServletResponse response){
        try {

  
            
            
            
            //Image path on the server
            if (image!=null && !image.isEmpty()) {
                String filePathToBeServed = folderRoot+ "/" + image;
               
            	ClassPathResource classPathResource = new ClassPathResource("static/"+filePathToBeServed );

                InputStream inputStream = classPathResource.getInputStream();
             
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment; filename=" + image);
                IOUtils.copy(inputStream, response.getOutputStream());
                response.flushBuffer();
                inputStream.close();
            }
        } catch (Exception e){

            throw new RuntimeException("The API can't do image download", e);
        }

    }
}
