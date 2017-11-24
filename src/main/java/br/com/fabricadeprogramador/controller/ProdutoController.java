package br.com.fabricadeprogramador.controller;

import br.com.fabricadeprogramador.model.Produto;
import br.com.fabricadeprogramador.repository.ProdutoRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin("*")
public class ProdutoController {

    private static final Logger LOGGER = Logger.getLogger(ProdutoController.class.getName());

    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping(value = "/produtos/imagem/{cod}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> donwload(@PathVariable("cod") String codigoBarra) throws Exception {
        LOGGER.info("procurando imagem correspondente...");
        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        try {
            ClassPathResource classPathResource = new ClassPathResource("static/" + codigoBarra + ".jpg");

            InputStream inputStream = classPathResource.getInputStream();

            byte[] byteArray = IOUtils.toByteArray(inputStream);

            return new ResponseEntity<>(byteArray, headers, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.info("Não foi possível encontrar a imagem do produto!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/procurar/{content}")
    public ResponseEntity<List<Produto>> buscarProdutosPorCodigoOuDescricao (@PathVariable("content") String content) {
        return new ResponseEntity<>(produtoRepository.buscarProdutosPorCodigoOuDescricao(content), HttpStatus.OK);
    }

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity<Produto> buscarPorCodigoBarra(@PathVariable("codigo") String codigoBarra) {
        LOGGER.info("procurando por código de barras...");

        if(!codigoBarra.equals("")) {
            return new ResponseEntity<>(produtoRepository.buscarPorCodigoBarra(codigoBarra),
                                                HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/salvar")
    public void salvar (@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }

    @GetMapping("/remover/{id}")
    public void removerProduto(@PathVariable("id") Integer id) {
        produtoRepository.delete(id);
    }

    @GetMapping("/procurarPorId/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") Integer id){
        return produtoRepository.findOne(id);
    }

    @PutMapping("/editar")
    public void editarProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
    }


}
