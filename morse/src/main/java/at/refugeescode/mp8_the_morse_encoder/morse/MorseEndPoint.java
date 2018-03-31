package at.refugeescode.mp8_the_morse_encoder.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseEndPoint {
    int i = 0;
    String charFromMorse ="";

    @PostMapping("/morse")
    String chipher(@RequestBody String word){
        charFromMorse = charFromMorse + stringtoMorse(word);
        return  charFromMorse;
    }

    @GetMapping("/morse")
    String get(){
        String w ="";
        w = w + charFromMorse;
        return  w.replaceAll("\"","").trim() ;
    }
    public String stringtoMorse(String input){
        char Alphabet [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
        String MorseCode [] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|"};
        String result ="";

        for (int i = 0; i < input.length(); i ++){ //in your code, this is the inner for and it should be the outer one as it is here

            for(int j = 0; j < Alphabet.length; j++){ //same for this one

                if(input.toLowerCase().charAt(i) == Alphabet[j]){

                    result = MorseCode[j] + " || ";

                }//end if

            }//end inner for
        }//end outer for
        return result;


    }

}
