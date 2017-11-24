package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.model.Empresa;
import br.com.fabricadeprogramador.model.Produto;
import br.com.fabricadeprogramador.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;


/**
 * Created by Virmerson Bento dos Santos on 12/2/16.
 */
@RestController
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    //@GetMapping("/empresa/dados/{cod}")
    //private Empresa localizar(@PathVariable("cod") Integer id)
    
    @GetMapping("/empresa/dados")
    private Empresa localizar(){

    	return empresaRepository.buscar();
    	//return empresaRepository.buscar(id);

    }
    
    
    @RequestMapping(value = "/empresa/logo", method = RequestMethod.GET)
    public ResponseEntity<byte[]> donwload() throws Exception {
/*
        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        Empresa empresa = empresaRepository.findAll().get(0);

        byte[] byteArray = empresa.getLogo();

        return new ResponseEntity<>(byteArray, headers, HttpStatus.FOUND);
*/
    	// Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        ClassPathResource classPathResource = new ClassPathResource("static/imagens/empresa.jpg");

        InputStream inputStream = classPathResource.getInputStream();

        byte[] byteArray = IOUtils.toByteArray(inputStream);

        return new ResponseEntity<>(byteArray, headers, HttpStatus.OK);
    	
    }
}
