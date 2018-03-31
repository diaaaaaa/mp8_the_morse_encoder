package at.refugeescode.mp8_the_morse_encoder.encoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EncoderEndPoint {

    private String word ;

    @GetMapping("/word")
    String getWord(){

        return  word;
    }

    @PostMapping("/word")
    void sendWordToMorse(@RequestBody String wordFromOut){

        word = wordFromOut ;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/morse";
        for (Character charc: word.toCharArray()) {
            restTemplate.postForEntity(url,charc, String.class);
        }

        //word = wordFromOut + " .... Hi from Encoder Endpoint post Mapping .... ";
    }

}
