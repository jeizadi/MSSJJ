import java.util.ArrayList;

/**
 * Class that stores an arrayList of all questionTypes
 * @author satchimehta
 *
 */
public class QuizType {

  private static ArrayList<String> quizTypes = new ArrayList <String>();
  
  /**
   * Call when user enters new type and presses "Add this quiz"
   * @param newType
   */
  public QuizType(String newType) {
    quizTypes.add(newType);
  }
  
  /**
   * Public accessor method for retrieving the updated questionType list
   * Called when user types new type and presses "Add this quiz"
   * @return
   */
  public ArrayList<String> getQuizTypes(){
    return quizTypes;
  }
}
