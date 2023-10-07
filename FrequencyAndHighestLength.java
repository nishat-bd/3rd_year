import java.util.Scanner;

public class FrequencyAndHighestLength {
    public static void main(String[] args) {
        System.out.print("Enter the Sentence : ");
        Scanner input=new Scanner(System.in);
        String givenSentence = input.nextLine();
        input.close();

        String sentence=givenSentence.replaceAll("[^a-zA-Z ]","");
        String[] words=sentence.split(" ");  // Or, String[] words=givenSentence.replaceAll("[^a-zA-Z ]","").split(" ");

        int maxLength=0;
        int indexMaxLength=0;
        int maxFrequency=0;
        int indexMaxFrequency=0;

        for(int i=0;i<words.length;i++){
            if(maxLength<words[i].length()){
                maxLength=words[i].length();
                indexMaxLength=i;
            }
            int count=0;
            for(int j=i;j<words.length;j++){
                if(words[i].equals(words[j])){
                    count++;
                }
            }
            if(maxFrequency<count){
                maxFrequency=count;
                indexMaxFrequency=i;
            }
        }

        System.out.println("Word with Maximum length : "+words[indexMaxLength]);
        System.out.println("Most frequent word is : "+words[indexMaxFrequency]);
    }
}
