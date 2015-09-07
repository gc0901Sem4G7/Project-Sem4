package doituong;

public class FQA {

    private int id;

    private String question;

    private String answer;
    
    private String username;
    
    private String status;

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FQA() {
    }

    public FQA(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }
    public FQA(int id, String question, String answer, String username, String status) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.username = username;
        this.status = status;
    }
    public FQA(String question, String answer, String username, String status) {
        this.question = question;
        this.answer = answer;
        this.username = username;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
