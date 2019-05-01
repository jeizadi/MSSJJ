import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileReaderWriter {
  JSONObject jsonQ;

  public FileReaderWriter() {
    jsonQ = new JSONObject();

  }

  // { JSONOBJECT –> "key":"value"
  // "meta-data":"unused",
  // "questionText": "If a good hash function is found and a reasonable table size is used for a
  // hash table, then the operations of put, remove, and get should achieve an average time
  // complexity of _____ where $N$ is the number of items and $TS$ is the size of the table.",
  // "topic": "hash table",
  // "image":"goodhash2_AK.jpg",
  // "choiceArray":
  // [ JSONARRAY CONTAINS JSON OBJECT
  // {"isCorrect":"T","choice":"$O(1)$"} JSON OBJECT,
  // {"isCorrect":"F","choice":"$O(log N)$"},
  // {"isCorrect":"F","choice":"$O(log_{TS} N)$"},
  // {"isCorrect":"F","choice":"$O(N^{TS})$"},
  // {"isCorrect":"F","choice":"$O(N)$"}
  // ] JSONARRAY END
  // } JSONOBJECT END,
  public void writeQuestion(String question, String quizType, String imageURL, Answer[] answers) {
    // add em to jsonobject
    jsonQ.put("meta-data", "unused");
    jsonQ.put("questionText", question);
    jsonQ.put("topic", quizType);
    jsonQ.put("image", imageURL);

    JSONArray ansArray = new JSONArray();
    // create new json object for each answer object(all answers)
    // add isCorrect value and Choice value
    for (int i = 0; i < answers.length; i++) {
      JSONObject choice = new JSONObject();
      choice.put("isCorrect", answers[i].isCorrect);
      choice.put("choice", answers[i].answer);
      ansArray.add(choice);
    }
    jsonQ.put("choiceArray", ansArray);

    // Writing to a file, orders elements from smallest to largest
    // image which is 'null' goes first because its the smallest even tho it shouldn't.
    try (FileWriter file = new FileWriter("satchiJose.json")) {
      file.write(jsonQ.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public static QuestionAnswer readQuestion(String jsonFilePath)
      throws FileNotFoundException, IOException, ParseException {
    Object obj = new JSONParser().parse(new FileReader(jsonFilePath));
    // typecasting to JSONObject
    JSONObject jsonObj = (JSONObject) obj;
    String question = (String) jsonObj.get("questionText");
    String topic = (String) jsonObj.get("topic");
    String imageURL = (String) jsonObj.get("image");
    JSONArray answers = (JSONArray) jsonObj.get("choiceArray");
    Answer[] answersArray = new Answer[5];
    for (int i =0; i< 5; i++) {
     JSONObject answer1 = (JSONObject)answers.get(i);
      boolean isCorrect = (boolean) answer1.get("isCorrect");
      String choice = (String) answer1.get("choice"); 
      Answer currAnswer = new Answer(choice, isCorrect);
      answersArray[i] = currAnswer;
    }
    
    QuestionAnswer newQuestion = new QuestionAnswer( question, answersArray,
        imageURL, topic);
    return newQuestion;
    //ADD TO DATA STRUCTURE
  }



  public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
//    Answer[] incAns = new Answer[4];
//    Answer ans1 = new Answer("good", true);
//    Answer ans2 = new Answer("bad", false);
//    Answer ans3 = new Answer("horrible", false);
//    Answer ans4 = new Answer("decent", false);
//    incAns[0] = ans1;
//    incAns[1] = ans2;
//    incAns[2] = ans3;
//    incAns[3] = ans4;
    // writeQuestion("How are ya?", "Greeting", null, incAns );
    
   QuestionAnswer test =  readQuestion("jsonEx.json");
    System.out.println(test.question);
    
  }
}



// public String readQuestion(String jsonFilepath ) throws FileNotFoundException, IOException,
// ParseException {
// //parsing file
// Object obj = new JSONParser().parse(new FileReader(jsonFilepath));
// //typecasting to JSONObject
// JSONObject jo = (JSONObject) obj;
//
//// Array made of packages
// JSONArray question = (JSONArray) jo.get("question");
//// create graph from file
// JSONObject currentPkg = (JSONObject) question.get(0);
// String name = (String) currentPkg.get("name");
// return "";
//
//
//
//
//// public void constructGraph(String jsonFilepath) throws FileNotFoundException, IOException,
// ParseException {
//// //parsing file
//// Object obj = new JSONParser().parse(new FileReader(jsonFilepath));
//// //typecasting to JSONObject
//// JSONObject jo = (JSONObject) obj;
//// //Array made of packages
//// JSONArray packages = (JSONArray) jo.get("packages");
//// //create graph from file
//// for (int i = 0; i < packages.size(); i++) {
//// JSONObject currentPkg = (JSONObject) packages.get(i);
//// String name = (String) currentPkg.get("name");
//// graph.addVertex(name);
////
//// JSONArray dependencies = (JSONArray) currentPkg.get("dependencies");
//// for (int j = 0; j < dependencies.size(); j++) {
//// String currentDep = (String) dependencies.get(j);
//// graph.addEdge(name, currentDep);
////
//// }
////
//// }
////
//// }
// }
// }
