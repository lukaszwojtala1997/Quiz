/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Lukasz
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String[] contents = new String[10];
        String[] answerA = new String[10];
        String[] answerB = new String[10];
        String[] answerC = new String[10];
        String[] answerD = new String[10];
        String[] correctAnswer = new String[10];
        int nrLines = 1;
        int nrQuestion = 0;
        int punkty = 0;
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader("Quiz.txt"));
        String dane;
        while((dane = reader.readLine()) != null){
            switch (nrLines) {
                case 1 -> contents[nrQuestion] = dane;
                case 2 -> answerA[nrQuestion] = dane;
                case 3 -> answerB[nrQuestion] = dane;
                case 4 -> answerC[nrQuestion] = dane;
                case 5 -> answerD[nrQuestion] = dane;
                case 6 -> correctAnswer[nrQuestion] = dane;
            }
            if(nrLines == 6){
                nrLines = 0;
                nrQuestion++;
           
            }
             nrLines++;
        }
        reader.close();
        
        for(int i = 0; i <= 9; i++)
        {
            System.out.println(contents[i]);
            System.out.println("a: " + answerA[i]);
            System.out.println("b: " + answerB[i]);
            System.out.println("c: " + answerC[i]);
            System.out.println("d: " + answerD[i]);
            System.out.println("What is your answer");
            String odpowiedzGracza = scanner.nextLine();
            if(odpowiedzGracza.equals(correctAnswer[i])){
                System.out.println("Good answer");
                punkty++;
            }
            else
                System.out.println("Wrong answer. Correct:" + correctAnswer[i]);
        }
        System.out.println("End of the quiz. Your number of points: " + punkty);
        
    }
    
}
