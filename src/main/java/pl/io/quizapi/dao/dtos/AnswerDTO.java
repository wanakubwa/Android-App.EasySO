package pl.io.quizapi.dao.dtos;


public class AnswerDTO {
    private String answer;
    private Boolean result;

    public AnswerDTO() {
    }

    public AnswerDTO(String answer, Boolean result) {
        this.answer = answer;
        this.result = result;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
