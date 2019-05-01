
//ALL DATA WILL BE PARSED FROM INPUT BY USER AND CREATED WHEN USER PRESSES ENTER


/**
 * Class that creates either a 4 or 5 answer question and stores the data
 * @author satchimehta
 */
public class QuestionAnswer{  
  String question;
  Answer answer1;
  Answer answer2;
  Answer answer3;
  Answer answer4;
  Answer answer5;
  String imageURL;
  String topic;


  /**
   * Constructor for a 4 answer question
   * @param question
   * @param correctAnswer
   * @param incorrectAnswer1
   * @param incorrectAnswer2
   * @param incorrectAnswer3
   */

  /**
   * Constructor for a 5 answer question
   * @param question
   * @param correctAnswer
   * @param incorrectAnswer1
   * @param incorrectAnswer2
   * @param incorrectAnswer3
   */
  public QuestionAnswer(String question, Answer[] answers, String imageURL, String topic) {
    this.question= question;
    this.answer1 = answers[0];
    this.answer2 = answers[1];
    this.answer3 = answers[2];
    this.answer4 = answers[3];
    this.answer5 = answers[4];
    this.imageURL = imageURL;
    this.topic = topic;
  }
  
  
}
