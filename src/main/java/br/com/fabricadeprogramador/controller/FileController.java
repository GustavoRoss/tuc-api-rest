package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.model.Empresa;
import br.com.fabricadeprogramador.model.Produto;
import br.com.fabricadeprogramador.repository.EmpresaRepository;
import br.com.fabricadeprogramador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

@RestController
@CrossOrigin
public class FileController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Transactional
    @PostMapping("/admin/upload/precos")
    public ResponseEntity<String> uploadPrecos(MultipartHttpServletRequest request) {
        try {

            produtoRepository.deleteAll();
            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                // Nome
                String uploadedFile = itr.next();
                // Bytes
                MultipartFile file = request.getFile(uploadedFile);
                //Lendo o file
                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                StringBuilder sb = new StringBuilder();

                //Linha por linha do file
                for (String line; (line = reader.readLine()) != null; ) {

                    //Extraindo código de barras
                    String codBarra = line.substring(0, 13);
                    String descricao = line.substring(13, 32);
                    String valorInteiro = line.substring(33, 43);
                    String centavos = line.substring(43, 45);
                    String valor = valorInteiro + "." + centavos;

                    Double dbValor = new Double(valor);

                    produtoRepository.save(new Produto(codBarra, descricao, dbValor));

                }

            }
        } catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


    @Transactional
    @PostMapping("/admin/upload/logo")
    public ResponseEntity<String> uploadLogo(MultipartHttpServletRequest request) throws IOException {
        Empresa empresa;
        try {
             empresa = empresaRepository.findAll().get(0);

        }catch (Exception e){
              empresa=   empresaRepository.save(new Empresa());
        }

        try {


            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                // Nome
                String uploadedFile = itr.next();
                // Bytes
                MultipartFile file = request.getFile(uploadedFile);


                empresa.setLogo(file.getBytes());

                empresaRepository.save(empresa);

            }
        } catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }


}
